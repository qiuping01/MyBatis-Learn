package com.test.mapper;

import com.test.entity.Class;
import com.test.entity.Student;
import com.test.repository.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现接口的代理对象
        ClassRepository repository = sqlSession.getMapper(ClassRepository.class);
        Class aClass = repository.findByClaId(1);
        System.out.println(aClass);
        Class aClass1 = repository.findByClaId(1);
        System.out.println(aClass1);
    }
}