package com.example.rest_demo.service.ImplementedService;

import com.example.rest_demo.model.user;
import com.example.rest_demo.repository.userRepository;
import com.example.rest_demo.service.userService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userServiceImp implements userService {

    private final userRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public userServiceImp(userRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

        @Override
        public user addUser(user u)  {

            user u1 = userRepo.findByEmail(u.getEmail());
            if( u1 != null){
                throw new IllegalArgumentException("Email already exists");

            }
            String password = u.getPassword();
            String hashedPassword = passwordEncoder.encode(password);
            u.setPassword(hashedPassword);
            System.out.println(hashedPassword+"wtvr"+ password);
            System.out.println(u);
            System.out.println(u1);
            return userRepo.save(u);
        }



    @Override
    public user login(String email, String password) throws Exception {
        try {
            user u1 = userRepo.findByEmail(email);

            if (u1 == null) {
                throw new Exception("User not found");
            }




            if (passwordEncoder.matches(password, u1.getPassword())) {
                return u1;
            } else {
                throw new Exception("Incorrect password");
            }
        } catch (Exception e) {
            throw new Exception("User not found");
        }
    }

}
