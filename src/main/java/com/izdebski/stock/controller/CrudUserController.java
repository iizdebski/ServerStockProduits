package com.izdebski.stock.controller;

import com.izdebski.stock.entity.Role;
import com.izdebski.stock.entity.User;
import com.izdebski.stock.repository.RoleRepository;
import com.izdebski.stock.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/crud_user")
public class CrudUserController extends CrudController<User, Long> {

    @Autowired
    private RoleRepository roleRepository;

    public List <User> getAll(){
        List<User> users = super.getAll();
        users.forEach(user -> user.setPassword(null));
        return users;
    }

    public void add(@RequestBody User user) {
        Role role = roleRepository.findByName(RoleEnum.ROLE_USER.getName());
        user.setRoles(Arrays.asList(role));
        user.setEnable(true);
        super.add(user);
    }
}