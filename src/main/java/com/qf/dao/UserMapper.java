package com.qf.dao;

import com.qf.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insert(User user);
    int delete(int id);
    int update(User user);
    List<User> selectAll();
    User selectOne(int id);
}
