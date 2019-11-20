package com.jjh.filecontrol;

import java.io.File;
import java.io.FileInputStream;

public class FileUtil {
	
	static final String path = "./file/";
	static final String filename = "HeavyData_1.txt";
	static final String newFilename = "HeavyData_1_copy.txt";
	
	
	public byte[] getFileByte() {		
		
		File file = null;
		FileInputStream fis = null;
		byte[] file2Byte = null;
		
		try {
			
			file = new File(path + filename);
			System.out.println("[FileUtil::getFileByte] file size : " + file.length() + "byte");
			file2Byte = new byte[(int) file.length()];
			fis = new FileInputStream(file);
			fis.read(file2Byte);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[FileUtil::getFileByte] Exception : " + e.getMessage());
			file2Byte = null;
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (Exception e2) {}
		}
		
		return file2Byte;
		
	}
	
	public void mekeFile(byte[] in) {
		
	}
	
	
}
