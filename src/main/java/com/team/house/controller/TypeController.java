package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.service.TypeService;
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
public class TypeController {
    @Autowired
    private TypeService typeService;
@RequestMapping("getType")
@ResponseBody
    public Map<String,Object> getType(Page page){
        PageInfo<Type> info=typeService.getTypeList(page);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("addType")
    @ResponseBody
    public String addType(Type type){
        int i=typeService.addType(type);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("updateType")
    @ResponseBody
    public String updateType(Type type){
    int i=typeService.updateType(type);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("deleteType")
    @ResponseBody
    public String deleteType(Integer id){
    int i=typeService.deleteType(id);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("getTypeById")
    @ResponseBody
    public Type getTypeById(Integer id){
        Type type = typeService.getTypeBYId(id);
        return type;
    }
    @RequestMapping("deleteTypes")
    @ResponseBody
    public String deleteTypes(String id){
    String[]  arr=id.split(",");
    List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i <arr.length ; i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        int i=typeService.deleteTypes(list);
        return "{\"result\":"+i+"}";

    }
}
