package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.house.util.HouseParam;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    public PageInfo<House> getHouseList(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        HouseExample houseExample = new HouseExample();
        List<House> houseList=houseMapper.selectByExample(houseExample);
        PageInfo<House> info=new PageInfo<House>(houseList);
        return info;
    }

    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }
    public PageInfo<House> getHouseByUser(Integer id, Page page){
        PageHelper.startPage(page.getPage(),page.getRows());
        //查询所有记录
        List<House> list=houseMapper.getHouseByUserId(id);
        return new PageInfo<House>(list);
    }

    public House getHouse(String id) {
        return houseMapper.getHouseById(id);
    }

    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public int deleteHouse(String id) {
        House house=new House();
        house.setId(id);
        house.setIsdel(1);

        return houseMapper.updateByPrimaryKeySelective(house);
    }
    //查询未审核的房屋信息

    public PageInfo<House> getHouseByIsPass(HouseParam houseParam, Integer ispass) {
        PageHelper.startPage(houseParam.getPage(),houseParam.getRows());

        List<House> list=houseMapper.getHouseByIsPass(ispass);
        PageInfo<House> info=new PageInfo<House>(list);

        return info;
    }



    public int doPass(String id,Integer ispass) {
        House house=new House();
        house.setId(id);
        house.setIspass(ispass);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public PageInfo<House> getHouseByParam(HouseParam houseParam) {
        PageHelper.startPage(houseParam.getPage(),houseParam.getRows());
        List<House> houseList=houseMapper.getHouseByParam(houseParam);
        return new PageInfo<House>(houseList);
    }

}
