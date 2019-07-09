package com.team.house.protal.controller;

import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "streetController2")
@RequestMapping("/page/")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreetByDistrictId")
    @ResponseBody
            public List<Street> getStreetByDid(Integer id){
        List<Street> streetList=streetService.getStreetByDid(id);
        return streetList;
    }


}
