package com.psl.crud.Service;

import java.util.ArrayList;

import com.psl.crud.Model.DAOUser;
import com.psl.crud.Model.UserDTO;
import com.psl.crud.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public  class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       DAOUser user=userDao.findByUsername(username);
       if(user==null)
       {
           throw new UsernameNotFoundException("User not found with username"+username);

       }
       return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());

    }



    public DAOUser save(UserDTO user) {

        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

}