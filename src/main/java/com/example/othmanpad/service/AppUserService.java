package com.example.othmanpad.service;

import com.example.othmanpad.entity.AppUser;
import com.example.othmanpad.entity.Role;
import com.example.othmanpad.repository.AppUserRepo;
import com.example.othmanpad.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        AppUser user = appUserRepo.findAppUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found In the DataBase By This Username!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> { authorities.add(new SimpleGrantedAuthority(role.getRoleName()));});
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;
    public AppUser getAppUser(String username){
        return appUserRepo.findAppUserByUsername(username);
    }

    public List<AppUser> getUsers() {
        return appUserRepo.findAll();
    }

    public AppUser createUser(AppUser appUser) {
        AppUser userByUsername = appUserRepo.findAppUserByUsername(appUser.getUsername());
        if(userByUsername != null){
            throw new IllegalStateException("email is taken");
        }
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepo.save(appUser);

    }

    public Role createRole(Role role){
        Role roleByName = roleRepo.findByRoleName(role.getRoleName());
        if(roleByName!=null){
            throw new IllegalStateException("role is already existed");

        }
        return roleRepo.save(role);
    }

    public void addRoleToUser(String username,String roleName){
        AppUser user= appUserRepo.findAppUserByUsername(username);
        Role role=roleRepo.findByRoleName(roleName);
        user.getRoles().add(role);

    }
}
