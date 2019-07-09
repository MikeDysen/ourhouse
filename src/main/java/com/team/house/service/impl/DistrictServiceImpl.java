package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.DistrictService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    public PageInfo<District> getDistrictList(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        DistrictExample districtExample = new DistrictExample();
        List<District> districtList = districtMapper.selectByExample(districtExample);
        PageInfo<District> info = new PageInfo<District>(districtList);
        return info;
    }

    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    public District getDistrictById(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }
//此处可加事物注解 以表明 该方法是被事物管理的 @Transactional
    //当加了注解后 先调用删除街道的方法，再调用删除区域的方法，最后 加个return 1
    //表示 如果上面都完成了  才return 1 否则 视为任务失败
    public int deleteDistrict(Integer id) {
        int j = streetMapper.deleteStreetByDistrictId(id);
        int i = districtMapper.deleteByPrimaryKey(id);
        int k = j >= 1 && i == 1 ? 1 : 0;
        return k;

    }

    public int deleteDistricts(List<Integer> ids) {

        return districtMapper.deleteDistricts(ids);
    }

    public List<District> getDistrictList() {
        return districtMapper.selectByExample(null);
    }
}

