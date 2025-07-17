package com.test.mapper;

import com.test.entity.Class;
import com.test.entity.Customer;
import com.test.entity.Goods;
import com.test.entity.User;
import com.test.repository.*;
import com.test.util.ParameterPOJO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现接口的代理对象
        GoodsRepository goodsRepository = sqlSession.getMapper(GoodsRepository.class);
        Goods goods = goodsRepository.getById(3);
        System.out.println("商品ID：" +goods.getId());
        System.out.println("商品名称：" + goods.getName());
        List<Customer> customers = goods.getCustomers();
        for (Customer customer : customers) {
            System.out.println("客户信息：" + customer.getId() + "-" + customer.getName());
        }
    }
}