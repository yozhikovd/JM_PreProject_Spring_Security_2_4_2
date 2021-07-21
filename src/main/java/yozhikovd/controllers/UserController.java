package yozhikovd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yozhikovd.models.User;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("userInfo")
    public String showAllUsers(Model model, Principal principal) {

        return "show-all-users";
    }




}
