package kit.item.service.repairShop;

import kit.item.domain.repair.RepairResult;
import kit.item.domain.repair.RepairResultImage;
import kit.item.domain.repair.Reservation;
import kit.item.domain.repair.ReservationImage;
import kit.item.dto.request.repair.RequestRepairResultCreateDto;
import kit.item.dto.response.repairShop.ResponseRepairDto;
import kit.item.dto.response.repairShop.ResponseReservationInfoDto;
import kit.item.exception.DuplicateHashValueException;
import kit.item.repository.repairShop.RepairResultImageRepository;
import kit.item.repository.repairShop.RepairResultRepository;
import kit.item.repository.repairShop.ReservationRepository;
import kit.item.service.file.AzureBlobService;
import kit.item.util.hash.Hash;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RepairResultService {
    private final RepairResultRepository repairResultRepository;
    private final ReservationRepository reservationRepository;
    private final RepairResultImageRepository repairResultImageRepository;
    private final Hash hashUtil;
    private final AzureBlobService azureBlobService;

    public ResponseReservationInfoDto findReservationInfo(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            Reservation reservationInfo = reservation.get();
            List<ReservationImage> reservationImages = reservationInfo.getReservationImages();
            List<String> reservationImageUrls = new ArrayList<>();
            for (ReservationImage reservationImage : reservationImages) {
                reservationImageUrls.add(reservationImage.getUrl());
            }

            return ResponseReservationInfoDto.builder()
                    .productName(reservationInfo.getItDevice().getProduct().getName())
                    .productImageUrl(reservationInfo.getItDevice().getCategory().getImageUrl())
                    .applicationDate(reservationInfo.getApplicationDate())
                    .reservationDate(reservationInfo.getReservationDate())
                    .comment(reservationInfo.getComment())
                    .reservationImages(reservationImageUrls)
                    .build();
        }
        return null;
    }

    public ResponseRepairDto getRepairResult(Long repairResultId) {
        Optional<RepairResult> repairResult = repairResultRepository.findById(repairResultId);
        if (repairResult.isPresent()) {
            RepairResult repairResultInfo = repairResult.get();

            return ResponseRepairDto.builder()
                    .comment(repairResultInfo.getComment())
                    .date(repairResultInfo.getDate())
                    .beforeRepairResultImages(repairResultImageRepository.findImagesByRepairResultId(repairResultId, true))
                    .afterRepairResultImages(repairResultImageRepository.findImagesByRepairResultId(repairResultId, false))
                    .build();
        }
        return null;
    }

    public boolean createRepairResult(RequestRepairResultCreateDto requestRepairResultCreateDto) throws DuplicateHashValueException {
        Optional<Reservation> reservation = reservationRepository.findById(requestRepairResultCreateDto.getReservationId());
        if (reservation.isPresent()) {
            RepairResult repairResult = RepairResult.builder()
                    .comment(requestRepairResultCreateDto.getReportResultComment())
                    .date(LocalDateTime.now())
                    .reservation(reservation.get())
                    .build();
            repairResultRepository.save(repairResult);
            List<RepairResultImage> repairResultBeforeImages = null;
            List<RepairResultImage> repairResultAfterImages = null;

            try {
                if (checkInputImageByHash(requestRepairResultCreateDto.getReportBeforeImgs(), requestRepairResultCreateDto.getReportAfterImgs())) {
                    throw new DuplicateHashValueException("중복된 이미지가 존재합니다.");
                }

                if (checkImageByHash(requestRepairResultCreateDto.getReportBeforeImgs())) {
                    throw new DuplicateHashValueException("중복된 이미지가 존재합니다.");
                }

                if (checkImageByHash(requestRepairResultCreateDto.getReportAfterImgs())) {
                    throw new DuplicateHashValueException("중복된 이미지가 존재합니다.");
                }

                repairResultBeforeImages = saveRepairResultImages(requestRepairResultCreateDto.getReportBeforeImgs(), true);
                repairResultAfterImages = saveRepairResultImages(requestRepairResultCreateDto.getReportAfterImgs(), false);

                repairResultBeforeImages.forEach(repairResultImage -> {
                    repairResultImage.setRepairResult(repairResult);
                    repairResultImageRepository.save(repairResultImage);
                    }
                );

                repairResultAfterImages.forEach(repairResultImage -> {
                    repairResultImage.setRepairResult(repairResult);
                    repairResultImageRepository.save(repairResultImage);
                    }
                );
            } catch (IOException e) {
                log.info("파일 업로드 실패");
            } catch (NoSuchAlgorithmException e) {
                log.info("해시 알고리즘 실패");
            }
            return true;
        }
        return false;
    }

    private boolean checkInputImageByHash(List<MultipartFile> beforeImages, List<MultipartFile> afterImages) {
        String hash = "";
        List<MultipartFile> requestImages = new ArrayList<>();
        requestImages.addAll(beforeImages);
        requestImages.addAll(afterImages);

        List<String> hashList = new ArrayList<>();
        requestImages.forEach(requestImage -> {
            try {
                hashList.add(hashUtil.encrypt(requestImage.getBytes()));
            } catch (NoSuchAlgorithmException e) {
                log.info("해시 알고리즘 실패");
            } catch (IOException e) {
                log.info("파일 업로드 실패");
            }
        });

        for (String hashValue : hashList) {
            if (hashList.contains(hashValue)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkImageByHash(List<MultipartFile> requestImages) throws IOException, NoSuchAlgorithmException {
        String hash = "";
        for (MultipartFile requestImage : requestImages) {
            hash = hashUtil.encrypt(requestImage.getBytes());
            if (repairResultImageRepository.existsByHash(hash)) {
                return true;
            }
        }
        return false;
    }

    private List<RepairResultImage> saveRepairResultImages(List<MultipartFile> requestImages, boolean isBefore) {
        List<RepairResultImage> repairResultImages = new ArrayList<>();

        if (requestImages != null) {
            requestImages.forEach(requestImage -> {
                String fileUrl = null;
                try {
                    fileUrl = azureBlobService.upload(requestImage);
                } catch (IOException e) {
                    log.info("파일 업로드 실패");
                }
                try {
                    repairResultImages.add(RepairResultImage.builder()
                            .url(fileUrl)
                            .hash(hashUtil.encrypt(requestImage.getBytes()))
                            .isBefore(isBefore)
                            .build());
                } catch (NoSuchAlgorithmException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return repairResultImages;
        }
        return null;
    }
}
