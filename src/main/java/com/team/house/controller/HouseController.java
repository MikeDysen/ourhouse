package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import com.team.house.util.HouseParam;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("getHouse")
    @ResponseBody
    public Map<String,Object> getHouse(Page page){
        PageInfo<House> info=houseService.getHouseList(page);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("getHouseNoPass")
    @ResponseBody
    public Map<String,Object> getHouseNoPass(HouseParam houseParam){
        PageInfo<House> info = houseService.getHouseByIsPass(houseParam,0);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;

    }
    @RequestMapping("getHousePassed")
    @ResponseBody
    public Map<String,Object> getHousePassed(HouseParam houseParam){
        PageInfo<House> info = houseService.getHouseByIsPass(houseParam,1);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("YesPass")
    @ResponseBody
    public String YesPass(String id){
        int i = houseService.doPass(id,1);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("NoPass")
    @ResponseBody
    public String NoPass(String id){
        int i = houseService.doPass(id,0);
        return "{\"result\":"+i+"}";
    }

}
