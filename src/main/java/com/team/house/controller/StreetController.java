package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreet")
    @ResponseBody
    public Map<String, Object> getStreet(Page page) {
        PageInfo<Street> info = streetService.getStreetList(page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        System.out.println(info.getList());
        return map;
    }

    @RequestMapping("getStreetsByDistrictId")
    @ResponseBody
    public Map<String, Object> getStreet(Integer id, Page page) {
        PageInfo<Street> info = streetService.getStreetsByDistrictId(id, page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        System.out.println(info.getList());
        return map;
    }
    @RequestMapping("deleteStreet")
    @ResponseBody
    public String deleteStreet(Integer id){
        int i=streetService.deleteStreet(id);
        return  "{\"result\":"+i+"}";
    }
    @RequestMapping("deleteStreets")
    @ResponseBody
    public String deleteStreets(String id){
        String[] arr=id.split(",");
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i <arr.length ; i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        int i = streetService.deleteStreets(list);
        return  "{\"result\":"+i+"}";
    }
}
