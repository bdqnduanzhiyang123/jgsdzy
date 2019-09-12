
import cn.kgc.mybatis.bean.User;
import cn.kgc.mybatis.mapper.UserMapper;
import cn.kgc.mybatis.util.Mybatisutil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;


public class TestUser {
   SqlSession sqlSession =null;
   UserMapper userMapper = null;
    @Before
    public void before(){

        sqlSession = Mybatisutil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public  void test01(){
        /*List<User> list = userMapper.getUserListByUserName("孙");*/
        System.out.println(userMapper.getUserListByUserName("孙").size());
        /*System.out.println(list.get(1).toString());*/
    }
    @Test
    public  void test02() throws Exception {
        User user = new User();
        user.setUserCode("asd");
        user.setUserName("asdsad");
        user.setUserPassword("12354568");
        user.setGender(2);
        Date parse = null;
        parse = new SimpleDateFormat("yyyy-MM-dd").parse("2011-05-09");
        // user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2011-0509"));
        user.setBirthday(parse);
        user.setPhone("15252525252");
        user.setAddress("全国各地");
        user.setUserRole(1);
        user.setCreatedBy(2);
        user.setCreationDate(new Date());
        Integer addUser = userMapper.addUser(user);
        sqlSession.commit();
        System.out.println(addUser);
    }
    @Test
    public  void  test03(){
        User user = new User();
        user.setId(21);
        user.setUserCode("qwer");
        user.setUserName("quadsa");
        user.setUserPassword("84563");
        System.out.println(userMapper.updateUser(user));
        sqlSession.commit();
    }

    @Test
    public  void  test04(){
        userMapper.delete(20);
        sqlSession.commit();
    }

    @Test
    public void  test05(){
    userMapper.updateUserPwd(1,"548452");
    sqlSession.commit();
    }
    @Test
    public  void  test06(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("KeyUserName","孙");
        map.put("KeyUserRole","3");
        List<User> userList = userMapper.getUserListByMap(map);
        System.out.println(userList.size());
    }
    @Test
    public void  test07(){
        List<User> userList = userMapper.getByListUserRoleAndUserName(1, "孙");
        System.out.println(userList.size());
    }
   @Test
   public  void  test08(){
        User user = new User();
        user.setId(15);
        user.setUserCode("528");
        user.setUserName("wsxz");
        user.setUserPassword("7sda");
       Integer updateuser = userMapper.updateUser(user);
       sqlSession.commit();
       System.out.println(updateuser);
   }
   @Test
   public void  test09(){
        userMapper.getUserList_choose("s", "孙", 2, 3);

   }
   @Test
   public  void  test10(){
       Map<String,Object> map =  new HashMap<String, Object>();
       map.put("userRoles", Arrays.asList(1,3));
       userMapper.getUserListByMap(map);
   }

//   public void test13(){
//       System.out.println(userMapper.getDetailByauthor("王").size());
//   }
//    @After
//    public void after(){
//
//        Mybatisutil.closeSqlSession(sqlSession);
//    }

}
