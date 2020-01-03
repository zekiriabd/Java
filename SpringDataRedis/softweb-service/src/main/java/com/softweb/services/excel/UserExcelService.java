package com.softweb.services.excel;


import com.softweb.IUserDao;
import com.softweb.User;
import com.softweb.dto.UserDto;
import com.softweb.mapping.IUserMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserExcelService implements IUserExcelService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserMapper mapper;


    public  List<UserDto>  getUsersFromExcel(String fileName){

        List<UserDto> users = new ArrayList<>();
      try{
          FileInputStream excelFile = new FileInputStream(new File(fileName));
          Workbook workbook = new XSSFWorkbook(excelFile);
          Sheet page1 = workbook.getSheetAt(0);
          int rowscount = page1.getLastRowNum();
          for (int i=1; i< rowscount; i++){

              UserDto user = UserDto.builder()
                      .id((int)page1.getRow(i).getCell(0).getNumericCellValue())
                      .firstName(page1.getRow(i).getCell(1).getStringCellValue())
                      .lastName(page1.getRow(i).getCell(2).getStringCellValue())
                      .build();

              users.add(user);
          }
          workbook.close();
      }
      catch (Exception ex){
          System.out.println(ex);
      }
        return  users;
    }


    public String creatUersExcel() {

        List<User> dbusers = userDao.findAll();
        String fileName = "";
        try {
            fileName =  java.util.UUID.randomUUID().toString() + ".xlsx";
            Workbook workbook = new XSSFWorkbook();
            Sheet page1 = workbook.createSheet();

            Row row = page1.createRow(0);
            row.createCell(0).setCellValue("Id");
            row.createCell(1).setCellValue("FirstName");
            row.createCell(2).setCellValue("LastName");

            int i= 1;
            for (User user : dbusers){
                row = page1.createRow(i++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getFirstName());
                row.createCell(2).setCellValue(user.getLastName());
            }
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return fileName;
    }

    public ResponseEntity<InputStreamResource> download() {
        try {
            String fileName = creatUersExcel();

            InputStreamResource fileStream = new InputStreamResource(new FileInputStream(new File(fileName)));
            HttpHeaders header = new HttpHeaders();
            header.add("Content-Disposition", "attachment;filename=" + fileName);

            return ResponseEntity.ok()
                    .headers(header)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(fileStream);

        }catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    }

    public String upload(MultipartFile file) {
        String result = "";
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            InputStream inputStream = file.getInputStream();
            Files.copy( inputStream, Paths.get("d:\\" + filename), StandardCopyOption.REPLACE_EXISTING);
            result = "Files successfully uploaded";
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
        return result;
    }



}