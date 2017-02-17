/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author Trung Duc
 */
public class FileUploadUtil {

    
    public String upload(FormFile getfile) throws FileNotFoundException, IOException {
        System.out.println("file" + getfile.getFileName());
        String filename = "";
        FileOutputStream outputStream = null;
        FormFile fileN = null;

        fileN = getfile;
        String part = "/Users/brass/Documents/BuaYaiKorat/web/images/" + fileN.getFileName();  //เปลี่ยนตามเครื่อง
        outputStream = new FileOutputStream(new File(part));
        outputStream.write(fileN.getFileData());

        filename = getfile.getFileName();
        return filename;
    }
      

    public  byte[] fileToByteArray(String fileName) throws FileNotFoundException, IOException {
        String filePath = "/Users/brass/Documents/ProjectClub/web/image/uploade/" + fileName;
        File file = new File(filePath);
        BufferedInputStream inputStream = null;
       byte[] imageBytes = null ;
        // uploads a file
        try {
            FileInputStream fis = new FileInputStream(file);
            inputStream = new BufferedInputStream(fis);
             imageBytes = new byte[(int) file.length()];
            inputStream.read(imageBytes);

          

//            inputStream.close();
            System.out.println("File uploaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            inputStream.close();
        }
        return imageBytes;
    }
    

    private static String PATH_REPORT = "/Users/brass/Documents/ProjectClub/web/Report/";
    public static String uploadSingleFile(File file,String fileName,String fileType,String path){
        String pathFile = "";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        String dt = dateFormat.format(date);               
        File destFile = new File("C:/FilePackageUpload/" + dt + fileName);
        
        try {
            FileUtils.copyFile(file, destFile);
            pathFile = path + dt + fileName;
        } catch (IOException ex) {
            System.err.println("Could not copy file " + fileName);
             System.err.println(ex.getMessage());
        }                
        
    return pathFile;
    }
}
