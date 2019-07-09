package com.team.house.protal.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.*;
import com.team.house.service.DistrictService;
import com.team.house.service.HouseService;
import com.team.house.service.StreetService;
import com.team.house.service.TypeService;
import com.team.house.util.HouseParam;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller("houseController2")
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private StreetService streetService;

    @RequestMapping("goFabu")
    public String goFabu(Model model,HttpSession session){
        List<Type> typeList=typeService.getTypeList();
        List<District> districtList=districtService.getDistrictList();
        Object user = session.getAttribute("user");
        System.out.println(user);
        model.addAttribute("typeList",typeList);
        model.addAttribute("districtList",districtList);
        return "fabu";
    }
    @RequestMapping("getStreetByDid")
    @ResponseBody
    public List<Street> getStreetByDid(Integer id){
        List<Street> list=streetService.getStreetByDid(id);
        return list;
    }
    @RequestMapping("doFabu")
    public String doFabu(HttpSession session, House house, @RequestParam(name = "pfile",required = false) CommonsMultipartFile pfile)throws Exception{
        String filename=pfile.getOriginalFilename();
        String expname = filename.substring(filename.lastIndexOf("."));
        String s = System.currentTimeMillis() + expname;
        String path="D:/images/"+s;
        File file = new File(path);
        pfile.transferTo(file);
        System.out.println(s);
        house.setId(System.currentTimeMillis()+"");  //设置编号
        //设置用户id
        Object user1 = session.getAttribute("user");
        System.out.println(user1);
        Users user=(Users)session.getAttribute("user");
        System.out.println(user.getName());
        house.setUserId(user.getId());
        //设置图片
        house.setPath(s);
        house.setId(System.currentTimeMillis()+"");

        house.setIsdel(0);
        house.setIspass(0);
        int i=houseService.addHouse(house);
        if (i>0){
            return "redirect:getHouse";
        }else {
            file.delete();
        }
        return "redirect:getHouse";
    }
    @RequestMapping("getHouse")
    public String getHouse(Page page, HttpSession session, Model model) throws Exception{
        Integer uid=((Users)session.getAttribute("user")).getId();
        PageInfo<House> pageInfo=houseService.getHouseByUser(uid,page);
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";
    }
    @RequestMapping("goUpdate")
    public String goUpdate(String id,Model model){
        House house=houseService.getHouse(id);
        model.addAttribute("house",house);
        return "upfabu";
    }
    @RequestMapping("updateHouse")
    public String updateHouse(String oldPath,House house,@RequestParam(name = "pfile",required = false) CommonsMultipartFile pfile)throws  Exception{
        String filename = pfile.getOriginalFilename();
        if (filename.equals("")){

        }else {
            String expname=filename.substring(filename.lastIndexOf("."));  //上传文件的扩展名
            String saveFileName=System.currentTimeMillis()+expname;  //保存文件名称
            String path="d:/images/"+saveFileName;  //保存路径   替换原图
            File saveFile=new File(path);
            pfile.transferTo(saveFile);  //上传文件新图

            //2.删除原有图片
            new File("d:/images/"+oldPath).delete();

            //3.设置新图片
            house.setPath(saveFileName);
        }
        houseService.updateHouse(house);
        return "redirect:getHouse";
    }
    @RequestMapping("deleteHouse")
    public String deleteHouse(String id){
        houseService.deleteHouse(id);
        return "redirect:getHouse";
    }
    @RequestMapping("getHouseByP")
    public String getHouseByP(HouseParam houseParam, Model model){
        PageInfo<House> info=houseService.getHouseByParam(houseParam);
        model.addAttribute("info",info);
        model.addAttribute("param",houseParam);
        return "list";
    }
}
