package yozhikovd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yozhikovd.models.User;
import yozhikovd.services.UserService;

import javax.jws.WebParam;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

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
    public String addNewUser(@ModelAttribute("user") User user) {
        return "add-new-user";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";

    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
