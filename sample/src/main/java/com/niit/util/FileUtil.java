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
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	private static Path path;
	public static boolean fileCopyNIO(MultipartFile file, String fileName,HttpServletRequest request) {
		
		String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\ShoppingCartImages\\"+fileName);
		
		
		File dest = new File(path.toString());
		System.out.println("Where is it uploading?"+ dest.getAbsolutePath());
		if (!dest.exists()) {
			dest.mkdir();
		}

		try {
			file.transferTo(dest);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
