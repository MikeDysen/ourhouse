package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.util.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class UsersController {
    @Autowired
    private UsersService usersService;
@RequestMapping("getUsers")
@ResponseBody
    public Map<String,Object> getUsers(UserParam userParam){
        PageInfo<Users> info=usersService.getUsersList(userParam);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(Integer id){
    int i=usersService.deleteUser(id);
    return "{\"result\":"+i+"}";
    }

}
