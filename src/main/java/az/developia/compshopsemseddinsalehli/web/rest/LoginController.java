package az.developia.compshopsemseddinsalehli.web.rest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentications")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
