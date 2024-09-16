package com.restapi.restapi.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restapi.restapi.helper.FileUploadHelper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploaderHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
	    System.out.println(file.getOriginalFilename());
	    System.out.println(file.getSize());
	    System.out.println(file.getContentType());

	    // Check if the file is empty
	    if (file.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty. Please upload a valid file.");
	    }

	    // Try to upload the file
	    boolean result = fileUploaderHelper.uploadFile(file);
	    
	    // Return appropriate response based on the result
	    if (result) {
	        return ResponseEntity.ok("File uploaded successfully.");
	    } else {
	        // If the file upload fails, return an error
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed. Please try again.");
	    }
	}

	
	

    @GetMapping("/files")
    public ResponseEntity<List<String>> getAllFiles() {
        File folder = new File(fileUploaderHelper.UPLOAD_DIR);
        File[] files = folder.listFiles();
        List<String> fileNames = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add("/Image/" + file.getName());  // Send back URL of the image
                }
            }
        }

        return ResponseEntity.ok(fileNames);
    }
}
