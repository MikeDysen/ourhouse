package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.util.UserParam;

public interface UsersService {
    PageInfo<Users> getUsersList(UserParam userParam);
    int deleteUser(Integer id);
    Users login(String name,String password);
    int addUser(Users user);
    int checkName(String name);
}
