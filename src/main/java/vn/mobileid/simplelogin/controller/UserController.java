///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package vn.mobileid.simplelogin.controller;
//
//import java.security.Principal;
//import java.util.Base64;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import vn.mobileid.simplelogin.entity.User;
//
///**
// *
// * @author MSI-NT
// */
//@RestController
//@CrossOrigin
//public class UserController {
//
//    @RequestMapping("/login")
//    public boolean login(@RequestBody User user) {
//        return user.getUserName().equals("user") && user.getPassword().equals("password");
//    }
//
//    @RequestMapping("/user")
//    public Principal user(HttpServletRequest request) {
//        String authToken = request.getHeader("Authorization")
//                .substring("Basic".length()).trim();
//        return () -> new String(Base64.getDecoder()
//                .decode(authToken)).split(":")[0];
//    }
//}
