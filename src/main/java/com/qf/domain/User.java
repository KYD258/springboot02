package com.qf.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String pic;
}
