package com.qf.controller;

import com.qf.commons.R;
import com.qf.domain.User;
import com.qf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String insert(@RequestParam("file")MultipartFile file, @ModelAttribute User user){
        if(userService.insert(file,user)){
            return "success";
        }
       return "error";
    }

    @RequestMapping("/selectAll")
    public String selectAll(Model model){
        List<User> list = userService.selectAll();
        model.addAttribute("list",list);
        return "show";
    }
    @RequestMapping("/showAdd")
    public String showAdd(){
        return "add";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public R delete(int id){
        if(userService.delete(id)){
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/selectOne")
    public String selectOne(Model model, int id){
        User user = userService.selectOne(id);
        model.addAttribute(user);
        return "update";
    }

    @RequestMapping("/up")
    public String upload(@RequestParam("file")MultipartFile file, @ModelAttribute User user) {

        if(userService.update(file, user)) {
            return "redirect:selectAll";
        }
        return "redirect:selectOne";
    }
}
