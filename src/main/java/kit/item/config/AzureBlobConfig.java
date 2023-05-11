package kit.item.config;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:azure/azure.properties")
public class AzureBlobConfig {

	@Value("${azure.storage.string}")
	private String connectionString;

	@Value("${azure.storage.name}")
	private String containerName;

	@Bean
	public BlobServiceClient clobServiceClient() {
		return new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
	}

	@Bean
	public BlobContainerClient blobContainerClient() {
		return clobServiceClient().getBlobContainerClient(containerName);
	}
}