package com.sy.service.common;

import com.sy.mapper.common.UserMapper;
import com.sy.model.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getUserList(User user) throws Exception {
        return mapper.getUserList(user);
    }

    @Override
    public List<User> getUserListBySearch(User user) throws Exception {
        return mapper.getUserListBySearch(user);
    }

    @Override
    public User getLoginUser(User user) throws Exception {
        return mapper.getLoginUser(user);
    }

    @Override
    public User getUserById(User user) throws Exception {
        return mapper.getUserById(user);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public int addUser(User user) throws Exception {
        return mapper.addUser(user);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public int modifyUser(User user) {
        return mapper.modifyUser(user);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public int modifyUserRole(User user) {
        return mapper.modifyUserRole(user);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public int delUserPic(User user) {
        return mapper.delUserPic(user);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public int deleteUser(User user) {
        return mapper.deleteUser(user);
    }

    @Override
    public int count(User user) throws Exception {
        return mapper.count(user);
    }

    @Override
    public int loginCodeIsExit(User user) throws Exception {
        return mapper.loginCodeIsExit(user);
    }
}
