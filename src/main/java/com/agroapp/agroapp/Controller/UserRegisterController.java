package com.agroapp.agroapp.Controller;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agroapp.agroapp.Entity.Role;
import com.agroapp.agroapp.Entity.User;
import com.agroapp.agroapp.Service.RoleService;
import com.agroapp.agroapp.Service.UserDetailsServiceImp;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/v1/agroapp")
public class UserRegisterController {
    
    @Autowired
    UserDetailsServiceImp userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/register")
    public String register_get(
        Model model
    ) {
        List<Role> roles = (List<Role>) roleService.getAllRoles();
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roles);
        return "views/UserRegister";
    }

    @PostMapping("/register")
    public String register_post(
        @ModelAttribute("user") @Valid User user,
        BindingResult result
    ){
        if(result.hasErrors()){
            return "views/UserRegister";
        }

        System.out.println("Roles: " + user.getRoles());

        // Save user into db
        try {
            userService.saveNewUser(user);
            Set<Role> selectedRoles = user.getRoles().stream()
                .map(roleId -> (Role) roleService.getRoleById(roleId.getId()))
                .collect(Collectors.toSet());
            user.setRoles(selectedRoles);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("NO SE PUDO GUARDAR USUARIO:" + user.getEmail());
        }

        // CHECK: May return to a custom dashboard
        return "redirect:/";
    }
}
