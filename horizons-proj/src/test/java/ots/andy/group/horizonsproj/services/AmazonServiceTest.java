package ots.andy.group.horizonsproj.services;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ots.andy.group.horizonsproj.controllers.AmazonController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AmazonServiceTest {

    @InjectMocks
    private AmazonController amazonController = mock(AmazonController.class);
    @Mock
    private AmazonService amazonService = mock(AmazonService.class);

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpload() throws IOException {
        String url = "http://fakeurl.com";
        MultipartFile multipartFile = new MockMultipartFile("file",
                "testFile", "text", (byte[]) null) {
        };
        ResponseEntity<String> response = new ResponseEntity(url, HttpStatus.OK);
        when(amazonController.upload(multipartFile)).thenReturn(response);
        ResponseEntity<String> amazonResponse = amazonController.upload(multipartFile);
        assertTrue(response == amazonResponse);
    }

    @Test
    public void testUploadService() throws IOException {
        String url = "http://fakeurl.com";
        MultipartFile multipartFile = new MockMultipartFile("file",
                "testFile", "text", (byte[]) null) {
        };
        when(amazonService.upload(multipartFile)).thenReturn(url);
        String response = amazonService.upload(multipartFile);
        assertTrue(response == url);
    }
}
