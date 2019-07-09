package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.StreetService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;
    @Autowired
    private DistrictMapper districtMapper;
    public PageInfo<Street> getStreetList(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        StreetExample streetExample=new StreetExample();
        List<Street> streetList=streetMapper.selectByExample(streetExample);
        if (streetList!=null&&streetList.size()>0) {
            for (Street street : streetList) {
                Integer id = street.getDistrictId();
                District district = districtMapper.selectByPrimaryKey(id);
                street.setDistrict(district);
            }
        }
        PageInfo<Street> info=new PageInfo<Street>(streetList);
        return info;
    }
//在區域中查看 區域下的街道 並用datagrid分頁顯示
    public PageInfo<Street> getStreetsByDistrictId(Integer id,Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        List<Street> list=streetMapper.selectByExample(streetExample);
        return new PageInfo<Street>(list);
    }

    public int addStreet(Street street) {
        return streetMapper.insertSelective(street);
    }

    public int updateStreet(Street street) {
        return streetMapper.updateByPrimaryKeySelective(street);
    }

    public Street getStreetById(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }

    public int deleteStreet(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    public int deleteStreets(List<Integer> ids) {
        return streetMapper.deleteStreets(ids);
    }

    public List<Street> getStreetByDid(Integer id) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        return streetMapper.selectByExample(streetExample);
    }
}
