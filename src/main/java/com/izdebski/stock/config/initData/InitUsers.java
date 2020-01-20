package com.izdebski.stock.config.initData;


import com.izdebski.stock.entity.Role;
import com.izdebski.stock.entity.User;
import com.izdebski.stock.repository.RoleRepository;
import com.izdebski.stock.repository.UserRepository;
import com.izdebski.stock.util.RoleEnum;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(2)
public class InitUsers implements ApplicationRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public InitUsers(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Init Users .....");

        Role roleUser = roleRepository.findByName(RoleEnum.ROLE_USER.getName());
        Role roleAdmin = roleRepository.findByName(RoleEnum.ROLE_USER.getName());

        User user = new User("user", "user", true);
        user.setRoles(Arrays.asList(roleUser));

        userRepository.save(user);

        User admin = new User("admin", "admin", true);
        admin.setRoles(Arrays.asList(roleUser, roleAdmin));

        userRepository.save(admin);

        System.out.println("end.");

    }
}