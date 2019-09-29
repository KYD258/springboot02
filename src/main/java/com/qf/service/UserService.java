package com.qf.service;

import com.qf.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    boolean insert(MultipartFile file, User user);
    boolean delete(int id);
    boolean update(MultipartFile file, User user);
    List<User> selectAll();
    User selectOne(int id);
}
