package project.controller;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController
{

    @RequestMapping(value = "testing", method = RequestMethod.GET)
    public String test(){
        return "TESTING";
    }
}
