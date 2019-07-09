package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.UsersService;
import com.team.house.util.MD5Utils;
import com.team.house.util.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    public PageInfo<Users> getUsersList(UserParam userParam) {
        PageHelper.startPage(userParam.getPage(),userParam.getRows());
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        if (userParam!=null){
            if (userParam.getName()!=null&&!userParam.getName().equals("")){
                criteria.andNameLike("%"+userParam.getName()+"%");
            }
            if (userParam.getTelephone()!=null&&!userParam.getTelephone().equals("")){
                criteria.andTelephoneLike("%"+userParam.getTelephone()+"%");
            }

        }

        List<Users> usersList=usersMapper.selectByExample(usersExample);
        PageInfo<Users> info=new PageInfo<Users>(usersList);
        return info;
    }

    public int deleteUser(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    public Users login(String name, String password) {
        //要注意的几点  比对用户名 密码  页面注册 保存用户的时候 给密码加密了  这里进行匹配的时候也要将密码加密
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        //criteria.andPasswordEqualTo(password);  //匹配不加密的密码
        List<Users> list=usersMapper.selectByExample(usersExample);
        if (list.size()==0){
            return null;
        }else {
            return list.get(0);
        }

    }

    public int checkName(String name) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Users> list=usersMapper.selectByExample(usersExample);
        return list.size();
    }

    public int addUser(Users user) {//注册添加用户的时候 ，要给用户提交的密码加密  而且 默认为非管理员
        user.setIsadmin(0);
        String s = MD5Utils.md5Encrypt(user.getPassword());
        user.setPassword(s);
        return usersMapper.insertSelective(user);
    }
}
