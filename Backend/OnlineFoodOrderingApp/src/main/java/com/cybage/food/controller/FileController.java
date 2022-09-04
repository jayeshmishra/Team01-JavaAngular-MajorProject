package com.cybage.food.controller;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.food.service.FileService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/foodapp")
public class FileController {
	 private final FileService fileService;


	    public FileController(FileService fileService) {
	        this.fileService = fileService;
	    }

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws FileUploadException {
	        fileService.save(file);

	        return ResponseEntity.status(HttpStatus.OK)
	                             .body(new String("Uploaded the file successfully: " + file.getOriginalFilename()));
	    }
}
