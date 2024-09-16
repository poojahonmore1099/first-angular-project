package com.restapi.restapi.helper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
 public final String UPLOAD_DIR="C:\\Users\\uvtechsoft\\Downloads\\restapi\\src\\main\\resources\\static\\Image";
 
 public boolean uploadFile(MultipartFile multipartFile) throws IOException
 {
	 boolean file=false;
	Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
	file=true;
	return file;
 }

}
