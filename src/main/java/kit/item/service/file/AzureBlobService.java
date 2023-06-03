package kit.item.service.file;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AzureBlobService {

	@Autowired
	BlobServiceClient blobServiceClient;

	@Autowired
	BlobContainerClient blobContainerClient;

	public String upload(MultipartFile multipartFile) throws IOException {

		// 파일 확장자 검증
		if (!isImageFile(multipartFile)) {
			throw new IllegalArgumentException("올바른 이미지 파일이 아닙니다.");
		}

		// Todo UUID
		String fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
		BlobClient blob = blobContainerClient.getBlobClient(fileName);
		blob.upload(multipartFile.getInputStream(), multipartFile.getSize(), true);

		return blob.getBlobUrl();
	}

	private boolean isImageFile(MultipartFile multipartFile) {
		String originalFilename = multipartFile.getOriginalFilename();
		if (!StringUtils.hasText(originalFilename)) {
			return false;
		}
		String fileExtension = getFileExtension(originalFilename);
		return fileExtension != null && (fileExtension.equalsIgnoreCase("jpg")
				|| fileExtension.equalsIgnoreCase("jpeg")
				|| fileExtension.equalsIgnoreCase("png")
				|| fileExtension.equalsIgnoreCase("gif")
				|| fileExtension.equalsIgnoreCase("webp")
				|| fileExtension.equalsIgnoreCase("bmp")
				|| fileExtension.equalsIgnoreCase("svg")
				|| fileExtension.equalsIgnoreCase("ico")
				|| fileExtension.equalsIgnoreCase("tiff")
				|| fileExtension.equalsIgnoreCase("tif")
				|| fileExtension.equalsIgnoreCase("jfif")
				|| fileExtension.equalsIgnoreCase("pjpeg")
				|| fileExtension.equalsIgnoreCase("pjp")
				|| fileExtension.equalsIgnoreCase("avif")
				|| fileExtension.equalsIgnoreCase("apng")
				|| fileExtension.equalsIgnoreCase("pdf")
				|| fileExtension.equalsIgnoreCase("eps")
				|| fileExtension.equalsIgnoreCase("raw")
				|| fileExtension.equalsIgnoreCase("cr2")
				|| fileExtension.equalsIgnoreCase("nef")
				|| fileExtension.equalsIgnoreCase("orf")
				|| fileExtension.equalsIgnoreCase("sr2")
				|| fileExtension.equalsIgnoreCase("heif")
				|| fileExtension.equalsIgnoreCase("heic")
				|| fileExtension.equalsIgnoreCase("indd")
				|| fileExtension.equalsIgnoreCase("psd")
				|| fileExtension.equalsIgnoreCase("ai")
				// 추가적으로 지원하려는 이미지 확장자를 여기에 추가할 수 있습니다.
		);
	}

	private String getFileExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
			return null;
		}
		return fileName.substring(dotIndex + 1).toLowerCase();
	}

	public byte[] getFile(String fileName) throws URISyntaxException {

		BlobClient blob = blobContainerClient.getBlobClient(fileName);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		blob.download(outputStream);
		final byte[] bytes = outputStream.toByteArray();
		return bytes;

	}

	public List<String> listBlobs() {

		PagedIterable<BlobItem> items = blobContainerClient.listBlobs();
		List<String> names = new ArrayList<String>();
		for (BlobItem item : items) {
			names.add(item.getName());
		}
		return names;

	}

	public Boolean deleteBlob(String blobName) {

		BlobClient blob = blobContainerClient.getBlobClient(blobName);
		blob.delete();
		return true;
	}

}
