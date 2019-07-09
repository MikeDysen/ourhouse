package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
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
public class DistrictController {

    @Autowired
    private DistrictService districtService;
    @Autowired
    private StreetService streetService;


    @RequestMapping("getDistrict")
    @ResponseBody
    //返回的是 一个Map集合，存的有总行数 和当前页的信息
    public Map<String,Object> getDistrict(Page page){
        PageInfo<District> info = districtService.getDistrictList(page);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
    @RequestMapping("addDistrict")
    @ResponseBody
    //返回的是 添加数据的结果 0或1？ 怎样把 数字或字符串 以JSON的格式返回？
    public String addDistrict(District district){
        int i = districtService.addDistrict(district);
        return  "{\"result\":"+i+"}";
    }
    @RequestMapping("getSingleDistrict")
    @ResponseBody
    public District getDistrict(Integer id){
        return districtService.getDistrictById(id);
    }
    @RequestMapping("updateDistrict")
    @ResponseBody
    public String updateDistrict(District district){
        int i=districtService.updateDistrict(district);
        return  "{\"result\":"+i+"}";
    }
    @RequestMapping("deleteSingleDistrict")
    @ResponseBody
    public String deleteSingleDistrict(Integer id){
        int i=districtService.deleteDistrict(id);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("deleteDistricts")
    @ResponseBody
    public String deleteDistricts(String id){//这里 接收的从前台串过来的 参数 是字符串 保存的是id
                                            //所以要将字符串转化为集合
        String[] arr=id.split(",");
        List<Integer> list=new ArrayList<Integer>();//方法所需要的参数是一个集合
        for (int i = 0; i <arr.length ; i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        int i=districtService.deleteDistricts(list);
        return "{\"result\":"+i+"}";
    }
}
