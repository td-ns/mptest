package com.ns.mptest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ns.mptest.entiy.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getTest(int age);
}
