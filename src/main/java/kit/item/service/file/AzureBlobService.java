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

		if(
				!multipartFile.getContentType().equals("image/png") &&
						!multipartFile.getContentType().equals("image/jpg") &&
						!multipartFile.getContentType().equals("image/jpeg") &&
						!multipartFile.getContentType().equals("image/gif") &&
						!multipartFile.getContentType().equals("image/webp")
		)
			return "NOT_IMAGE";
		else{
			// Todo UUID
			String fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
			BlobClient blob = blobContainerClient.getBlobClient(fileName);
			blob.upload(multipartFile.getInputStream(), multipartFile.getSize(), true);

			return blob.getBlobUrl();
		}
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
