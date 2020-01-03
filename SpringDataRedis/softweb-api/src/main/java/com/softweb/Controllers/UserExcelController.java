package com.softweb.Controllers;

import com.softweb.dto.UserDto;
import com.softweb.services.database.IUserDbService;
import com.softweb.services.excel.IUserExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/excel/user")
public class UserExcelController {

    @Autowired
    private IUserExcelService userExcelService;

    @GetMapping("/getusers")
    public List<UserDto> getUsersFromExce() {
        return  userExcelService.getUsersFromExcel("MyExcelFile.xlsx");
    }

    @GetMapping("/createxcel")
    public String creatUersExcel() {
        return  userExcelService.creatUersExcel();
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> download() {
        return  userExcelService.download();
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        return userExcelService.upload(file);
    }
}
