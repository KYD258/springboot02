package com.qf.service.impl;

import com.qf.dao.UserMapper;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.utils.UploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UploadUtils uploadUtils;
    @Override
    public boolean insert(MultipartFile file, User user) {
        String path;
        if(file!=null&&file.getOriginalFilename()!=""){
            path = uploadUtils.upload(file);
            user.setPic(path);
        }
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean delete(int id) {
        return userMapper.delete(id) > 0;
    }

    @Override
    public boolean update(MultipartFile file, User user) {
        String path = "";
        if(file!=null&&(!file.getOriginalFilename().equals(""))){
            path = uploadUtils.upload(file);
        }
        System.out.println(path);
        user.setPic(path);
        return userMapper.update(user) > 0;
    }

    @Override
    public List<User> selectAll() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    @Override
    public User selectOne(int id) {
        return userMapper.selectOne(id);
    }
}
