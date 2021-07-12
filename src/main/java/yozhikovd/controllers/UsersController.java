package yozhikovd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yozhikovd.models.User;
import yozhikovd.services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String showAllUsers(Model model) {
        model.addAttribute("usersList", userService.userList());
        return "show-all-users";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("userById", userService.getUserById(id));
        return "show-user-by-id";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("newUser") User user) {
        return "add-new-user";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("newUser") User user) {
        userService.addNewUser(user);
        return "redirect:/users";
    }
}
