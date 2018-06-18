package pl.dezet.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequestMapping("/")
@RestController
public class UserController {

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }
}

