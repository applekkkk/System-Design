package com.lk.service.impl;

import com.lk.dao.UserDao;
import com.lk.domain.User;
import com.lk.service.UserService;
import com.lk.utils.Md5Util;
import com.lk.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserName(String username) {
        User user= userDao.findByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        //加密
        String md5String=Md5Util.getMD5String(password);
        userDao.add(username,md5String);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userDao.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Integer id=ThreadLocalUtil.get("id");
        userDao.updateAvatar(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Integer id=ThreadLocalUtil.get("id");
        newPwd=Md5Util.getMD5String(newPwd);
        userDao.updatePwd(newPwd, id);
    }
}
