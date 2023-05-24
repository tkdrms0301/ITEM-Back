package kit.item.controller;

import kit.item.service.file.AzureBlobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
public class AzureController {

	@Autowired
	private AzureBlobService azureBlobAdapter;

	@PostMapping("/file-upload")
	public ResponseEntity<String> upload(@RequestParam MultipartFile file) throws IOException {

		String fileUrl = azureBlobAdapter.upload(file);

		return ResponseEntity.ok(fileUrl);
	}

	@GetMapping("/file-download")
	public ResponseEntity<List<String>> getAllBlobs() {

		List<String> items = azureBlobAdapter.listBlobs();
		return ResponseEntity.ok(items);
	}

	@DeleteMapping("file-delete")
	public ResponseEntity<Boolean> delete(@RequestParam String fileName) {

		azureBlobAdapter.deleteBlob(fileName);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> getFile(@RequestParam String fileName) throws URISyntaxException {

		ByteArrayResource resource = new ByteArrayResource(azureBlobAdapter.getFile(fileName));

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).headers(headers).body(resource);
	}
}
