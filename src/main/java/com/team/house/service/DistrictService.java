package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.util.Page;

import java.util.List;

public interface DistrictService {
        PageInfo<District> getDistrictList(Page page);
        int addDistrict(District district);
        int updateDistrict(District district);
        District getDistrictById(Integer id);
        int deleteDistrict(Integer id);
        int deleteDistricts(List<Integer> ids);
        List<District> getDistrictList();
}
