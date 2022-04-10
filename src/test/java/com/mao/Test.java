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
    //从调用者角度来讲 与数据库打交道的对象 SqlSession
    //通过动态代理 去帮我们执行SQL
    WarehouseMapper mapper = sqlSession.getMapper(WarehouseMapper.class);
    Map<String,Object> map = new HashMap<>();
    map.put("id","1");
    System.out.println(mapper.selectAll(map));
    sqlSession.close();
  }
}
