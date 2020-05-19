package com.example.demo.Services;

import com.example.demo.DAO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServices implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserroleRespository userroleRespository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<Role> roleList = new ArrayList<>();
        if(user == null)
            throw new UsernameNotFoundException("username does not exist");

        System.out.println(user);
        List<Userrole> userroleList = userroleRespository.findByUserId(user.getId());

        for(Userrole userrole : userroleList){
            Optional<Role> role = roleRepository.findById(userrole.getRoleid());
            roleList.add(role.get());
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),roleList);
    }
}
