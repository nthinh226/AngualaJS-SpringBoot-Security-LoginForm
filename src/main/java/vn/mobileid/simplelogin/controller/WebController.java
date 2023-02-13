/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.mobileid.simplelogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MSI-NT
 */
@Controller
public class WebController {

    @RequestMapping(value = {"/", "/home"})
    public String homepage() {
        return "home"; // Trả về home.html
    }

    @RequestMapping("/login")
    public String login() {
        return "login"; // Trả về login.html
    }

    @RequestMapping("/products")
    public String home() {
        return "product"; // Trả về product.html
    }
}
