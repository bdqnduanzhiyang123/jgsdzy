package cn.kgc.mybatis.mapper;

import cn.kgc.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //根据用户名进行模糊查询
     public List<User> getUserListByUserName(String userName);
    //增加
    public  Integer addUser(User user);
    //修改
    public  Integer updateUser(User user);
    //删除
    public Integer delete(Integer id);
    //修改密码
    public Integer updateUserPwd(@Param("id") Integer id,
                                 @Param("newPwd") String newPwd);
    //Map入参
    public  List<User> getUserListByMap(Map<String,Object> map);
    //通过角色ID获取角色的相关信息
    public  List<User> getRoleByUserRole(Integer userRole);

    //根据用户角色id和 用户名进行模糊查询
    public List<User> getByListUserRoleAndUserName(@Param("UserRole")Integer userRole,
                                                   @Param("userName") String userName);
    //根据用户id修改用户信息
    public  Integer uodateById(User user);

    //userCode 和 userName 模糊查询
    public List<User> getUserList_choose(@Param("userCode")String userCode,
                                         @Param("userName")String userName,
                                         @Param("gender") Integer gender,
                                         @Param("userRole") Integer userRole);

    //使用foreach MAP集合
    public List<User> getUserListMap(Map<String,Object> map);


    //


}
