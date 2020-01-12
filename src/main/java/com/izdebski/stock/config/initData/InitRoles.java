package com.izdebski.stock.config.initData;

import com.izdebski.stock.entity.Role;
import com.izdebski.stock.repository.RoleRepository;
import com.izdebski.stock.util.RoleEnum;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitRoles implements ApplicationRunner {
    private final RoleRepository roleRepository;

    public InitRoles(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Init Roles .....");

        Role roleUser = roleRepository.findByName(RoleEnum.ROLE_USER.getName());
        if(roleUser == null){
            roleUser = new Role(RoleEnum.ROLE_USER);
            roleRepository.save(roleUser);
        }

        Role roleAdmin = roleRepository.findByName(RoleEnum.ROLE_USER.getName());
        if(roleAdmin == null){
            roleAdmin = new Role(RoleEnum.ROLE_ADMIN);
            roleRepository.save(roleAdmin);
        }
    }
}