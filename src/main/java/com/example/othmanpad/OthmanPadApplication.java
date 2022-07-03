package com.example.othmanpad;

import com.example.othmanpad.entity.AppUser;
import com.example.othmanpad.entity.Role;
import com.example.othmanpad.entity.Story;
import com.example.othmanpad.service.AppUserService;
import com.example.othmanpad.service.StoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
@Slf4j

public class OthmanPadApplication {

    public static void main(String[] args) {
        SpringApplication.run(OthmanPadApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner runner (StoryService storyService) {
//        return args -> {
//        storyService.createStory(new Story(null,"sdffas","fdsafadgsas","gasdgdsaga","hadsasdha",false,null,null,null,null,null));
//
//        }
//    }

//    @Bean
//    CommandLineRunner runner (AppUserService appUserService){
//        return args -> {
//
////            appUserService.createUser(new AppUser(null,"OthmanMaher","123456", LocalDate.of(2000,8,21).toString(),new ArrayList<>()));
//            appUserService.createRole(new Role(null,"USER"));
//            appUserService.createRole(new Role(null,"ADMIN"));
//            appUserService.addRoleToUser("OthmanMaher","USER");
//            appUserService.addRoleToUser("OthmanMaher","ADMIN");
////
//////            			userService.addRoleToUser("OthmanMaher","ADMIN");
//////			userService.addRoleToUser("OthmanMaher","USER");
//        };
//    }
}
