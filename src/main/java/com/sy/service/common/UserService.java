package com.sy.service.common;


import com.sy.model.common.User;

import java.util.List;

public interface UserService {


    /**
     * 查询用户列表
     * @return
     */
    public List<User> getUserList(User user) throws Exception;

    /**
     * 搜索用户
     * @param user
     * @return
     */
    public List<User> getUserListBySearch(User user) throws Exception;

    /**
     * 查询登录的用户
     * @param user
     * @return
     */
    public User getLoginUser(User user) throws Exception;

    /**
     * 按主键查询用户
     * @param user
     * @return
     */
    public User getUserById(User user) throws Exception;

    /**
     * 新增用户
     * @param user
     * @return
     */
    public int addUser(User user) throws Exception;

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int modifyUser(User user);

    /**
     * 根据用户角色修改用户
     * @param user
     * @return
     */
    public int modifyUserRole(User user);

    /**
     * 删除用户图片
     * @param user
     * @return
     */
    public int delUserPic(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    public int deleteUser(User user);

    /**
     * 分页查询用户数
     * @param user
     * @return
     * @throws Exception
     */
    public int count(User user) throws Exception;

    /**
     * 用户名是否存在
     * @param user
     * @return
     * @throws Exception
     */
    public int loginCodeIsExit(User user) throws Exception;
}
