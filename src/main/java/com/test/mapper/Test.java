package com.test.mapper;

import com.test.entity.Class;
import com.test.entity.Customer;
import com.test.entity.Goods;
import com.test.entity.User;
import com.test.repository.ClassRepository;
import com.test.repository.CustomerRepository;
import com.test.repository.StudentRepository;
import com.test.repository.UserRepository;
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
        CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
        Customer customer = customerRepository.getById(1);
        System.out.println("客户ID：" + customer.getId());
        System.out.println("客户姓名：" + customer.getName());
        List<Goods> goods = customer.getGoods();
        for (Goods good : goods) {
            System.out.println("购买的商品：" + good.getId()+good.getName());
        }
    }
}