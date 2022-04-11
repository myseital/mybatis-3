package com.mao;

import com.mao.mapper.WarehouseMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Test {

  public static void main(String[] args) throws Exception {
    String resource = "mybatis.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    SqlSession sqlSession1 = sqlSessionFactory.openSession();
    //从调用者角度来讲 与数据库打交道的对象 SqlSession
    //通过JDK动态代理 去帮我们执行SQL
    WarehouseMapper mapper = sqlSession.getMapper(WarehouseMapper.class);
    WarehouseMapper mapper1 = sqlSession1.getMapper(WarehouseMapper.class);
    Map<String,Object> map = new HashMap<>();
    map.put("id","1");

    System.out.println(mapper.selectAll(map));
    // 一级缓存不会执行sql
    System.out.println(mapper.selectAll(map));
    // 二级缓存不会执行sql
    System.out.println(mapper1.selectAll(map));

    sqlSession.close();
    sqlSession1.close();
  }
}
