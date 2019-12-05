package com.softweb;

import com.softweb.dto.UserDto;

import java.util.List;
public interface IUserService {
    List<UserDto> GetUsers();
}
