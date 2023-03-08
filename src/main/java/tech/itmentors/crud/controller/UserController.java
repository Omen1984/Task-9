package tech.itmentors.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tech.itmentors.crud.model.User;
import tech.itmentors.crud.service.UserService;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("user/add-page")
    public String addUserPage(@ModelAttribute User user) {
        return "user-add";
    }

    @PostMapping("user/save")
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("user/update-page/{id}")
    public String updateUserPage(ModelMap model, @PathVariable("id") long id) {
        User user = userService.findById(id);
        if (user != null) {
            model.addAttribute("user", user);
        }

        return "user-update";
    }

    @PutMapping("user/update")
    public String update(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping ("user/delete/{id}")
    public String delete(@PathVariable long id) {
        userService.deleteById(id);
        return "redirect:/";
    }




}
