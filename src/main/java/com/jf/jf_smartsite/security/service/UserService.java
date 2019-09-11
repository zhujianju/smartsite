package com.jf.jf_smartsite.security.service;

import com.jf.jf_smartsite.security.entity.User;

public interface UserService {

    User findOne(String username);

}
