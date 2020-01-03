package com.softweb.services.excel;

import com.softweb.User;
import com.softweb.dto.UserDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IUserExcelService {
    List<UserDto> getUsersFromExcel(String fileName);
    String creatUersExcel();
    ResponseEntity<InputStreamResource> download();
    String upload(MultipartFile file);
}
