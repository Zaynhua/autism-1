package com.autism.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autism.model.Person;
import com.autism.service.impl.PersonServiceImpl;

@Controller
@RequestMapping("/")
@Api(value="restful",description="测试")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;
    
    @ApiOperation(value="测试专用")
    @RequestMapping(value="/showPerson")
    //如果不加@ResonseBody注解的话，返回字符串会被当做路径跳转，所以如果要想返回字符串信息，加上一个@ResonseBody注解就好了
    public String showPersons(Model model){
        List<Person> persons = personService.loadPersons();
        model.addAttribute("persons", persons);
        return "showperson";
    }
}
