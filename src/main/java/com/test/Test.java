package com.test;

import com.test.entity.User;
import com.test.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现接口的代理对象
        UserRepository repository = sqlSession.getMapper(UserRepository.class);
        User user = new User();
        List<Integer> ids = Arrays.asList(1, 4, 6);
        user.setIds(ids);
        List<User> list = repository.getByIds(user);
        for(User user1 : list){
            System.out.println(user1);
        }
    }
}