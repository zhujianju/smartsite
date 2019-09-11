package com.jf.jf_smartsite.security.service.impl;

import com.jf.jf_smartsite.security.entity.User;
import com.jf.jf_smartsite.security.mapper.UserMapper;
import com.jf.jf_smartsite.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findOne(String username) {
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        User user = userMapper.selectOneByExample(example);
        return user;
    }
}
