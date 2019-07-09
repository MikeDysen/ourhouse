package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.util.Page;

import java.util.List;

public interface StreetService {
   PageInfo<Street> getStreetList(Page page);
   //在區域中查看 區域下的街道 並用datagrid分頁顯示
   PageInfo<Street> getStreetsByDistrictId(Integer id,Page page);
   int addStreet(Street street);
   int updateStreet(Street street);
   Street getStreetById(Integer id);
   int deleteStreet(Integer id);
   int deleteStreets(List<Integer> ids);
   List<Street> getStreetByDid(Integer id);



}
