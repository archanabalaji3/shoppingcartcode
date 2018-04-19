package com.niit.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileUtil {
	
	@Autowired
	private static Path path;
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public boolean fileCopyNIO(MultipartFile file, String fileName,HttpServletRequest request) 
	{
     	String rootDirectory= request.getSession().getServletContext().getRealPath("/");
	    path = Paths.get(rootDirectory + "\\resources\\images\\"+fileName);	
	    File dest = new File(path.toString());

		System.out.println("where it is uploading ??" + dest.getAbsolutePath());
		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
