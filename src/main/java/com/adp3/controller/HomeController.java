package com.adp3.controller;

import com.adp3.entity.standalone.Employee;
import com.adp3.repository.standalone.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: Megan Jacobs
 * Class: Part Time
 * Student number: 211137162
 * Controller: HomeController created for mapping to home/index path of the application
 */

@RestController
public class HomeController {

    /*method used to map to url to path
     * @param: baseUrl (localhost:8080/home)
     * @return: EmployeeTimeManagement Application as /home
     * */
    @Autowired
    EmployeeRepository repo;

    @RequestMapping({"/", "/index","/home"})
    @ResponseBody
    public String indexPage(Model model){
        List<Employee> emp=(List<Employee>) repo.findAll();
        model.addAttribute("empllist",emp);
        return "index";

    }


//    @RequestMapping({"/", "/index","/home"})
//    @ResponseBody
//    public String index(){
//        return "you in";
//    }
//
//    //login form
//    @RequestMapping("/index.html")
//    public String login(){
//        return "index.html";
//    }
//    //login form
//    @RequestMapping("/index.html")
//    public String loginError(Model model){
//        model.addAttribute("loginError", true);
//        return "index.html";
//    }
}
