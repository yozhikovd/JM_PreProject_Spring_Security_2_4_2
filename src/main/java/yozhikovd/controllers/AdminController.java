package yozhikovd.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import yozhikovd.models.Role;
import yozhikovd.models.User;
import yozhikovd.services.UserService;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("")
    public String showAllUsers(Model model) {
        model.addAttribute("usersList", userService.userList());
        return "show-all-users";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("userById", userService.getUserById(id));
        return "show-current-user";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "add-new-user";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @RequestParam(required = false, name = "ADMIN") String ADMIN,
                             @RequestParam(required = false, name = "USER") String USER) {
        if (bindingResult.hasErrors())
            return "add-new-user";

        Set<Role> roles = new HashSet<>();
        if (ADMIN != null) {
            roles.add(new Role(1, ADMIN));
        }
        if (USER != null) {
            roles.add(new Role(2, USER));
        }
        if (ADMIN == null && USER == null) {
            roles.add(new Role(2, USER));
        }

        user.setRoles(roles);
        userService.addNewUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";

    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id,
                         @RequestParam(required = false, name = "ADMIN") String ADMIN,
                         @RequestParam(required = false, name = "USER") String USER){

        if (bindingResult.hasErrors())
            return "edit-user";

        Set<Role> roles = new HashSet<>();
        if (ADMIN != null) {
            roles.add(new Role(1, ADMIN));
        }
        if (USER != null) {
            roles.add(new Role(2, USER));
        }
        if (ADMIN == null && USER == null ) {
            roles.add(new Role(2, USER));
        }
            user.setRoles(roles);

        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }


    @GetMapping("/error")
    public String error() {
        return "error";
    }

}
