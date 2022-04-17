package com.ns.mptest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ns.mptest.entiy.Student;
import com.ns.mptest.entiy.User;
import com.ns.mptest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@MapperScan("com.ns.mptest.mapper")
@SpringBootTest
class MptestApplicationTests {

    @Autowired
    private UserMapper userMapper;


    //mp复杂查询
    @Test
    void testSelect(){
        //ge  gt le lt
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",20);
        List<User> users = userMapper.selectList(queryWrapper);
    }
    //分页查询
    @Test
    void testSelectPage(){
        Page <User> page =new Page<>(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        //返回对象所得到分页所有数据

        long pages = userPage.getPages();//总页数
        long current = userPage.getCurrent();//当前页
        List<User> records = userPage.getRecords();//查询数据集合
        long total = userPage.getTotal(); //总记录数
        boolean hasNext = userPage.hasNext(); //下一页
        boolean hasPrevious = userPage.hasPrevious();//上一页

        System.out.println(pages);    //输出总页数
        System.out.println(current);  //输出当前页
        System.out.println(records);  //当前页的数据
        System.out.println(total);    //输出总记录数
        System.out.println(hasNext);  //是否有下一页
        System.out.println(hasPrevious); //是否有上一页
    }
    @Test
    void findAll(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

    //添加
    @Test
    public void testAdd() {
        User user = new User();
        user.setName("书简");
        user.setAge(20);
        user.setEmail("1243@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    //删除
    @Test
    void deleteById(){
        int i = userMapper.deleteById(1505422581458731010L);
        System.out.println(i);
    }
    //修改
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1505377120102322177L);
        user.setName("lucymary");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    //测试乐观锁
    @Test
    public void testOptimisticLocker() {
        //根据id查询
        User user=userMapper.selectById(1505383244310474753L);
        //修改
        user.setName("宁松");
        //user.setVersion(user.getVersion()+1);
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    @Test
    public void test(){
        User page1 = userMapper.getTest(10);
        System.out.println(page1);
    }


}
