package ots.andy.group.horizonsproj.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.iot.model.CannedAccessControlList;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class AmazonService {

    public  static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

    Dotenv dotenv = Dotenv.load();
    public String upload(MultipartFile multipartFile) throws IOException {
        AWSCredentials credentials = new BasicAWSCredentials(
                dotenv.get("AMAZON_ACCESS"),
                dotenv.get("AMAZON_SECRET")
        );
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_WEST_1)
                .build();

        String keyName = multipartFile.getOriginalFilename();
        String bucket = "horizons-image-bucket";
        File file = multipartToFile(multipartFile, keyName);
        PutObjectRequest request = new PutObjectRequest(bucket, keyName, file);
        s3client.putObject(request);
        URL myURL = s3client.getUrl(bucket, keyName);
        return myURL.toString();
    }
}
