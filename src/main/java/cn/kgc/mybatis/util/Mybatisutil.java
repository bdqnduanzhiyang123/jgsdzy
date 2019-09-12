package cn.kgc.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Mybatisutil {
    private  static SqlSessionFactory sqlSessionFactory;
    static {
        InputStream inputStream = Mybatisutil.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    public  static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(false);//trun 自动提交
    }
    public  static void closeSqlSession(SqlSession sqlSession){
        if (sqlSession !=null){
            sqlSession.close();
        }
    }
}
