package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.util.HouseParam;
import com.team.house.util.Page;

public interface HouseService {
    //查询所有房屋信息
    PageInfo<House> getHouseList(Page page);
    int addHouse(House house);
    public PageInfo<House> getHouseByUser(Integer id, Page page);
    House getHouse(String id);
    int updateHouse(House house);
    int deleteHouse(String id);
    //查询未审核的房屋信息  并分页显示
    PageInfo<House> getHouseByIsPass(HouseParam houseParam, Integer ispass);
    //进行审查操作
    int doPass(String id,Integer ispass);
    //
    PageInfo<House> getHouseByParam(HouseParam houseParam);
}
