package ee.bcs.valiit.bronapp.controller;

import ee.bcs.valiit.bronapp.data.User;
import ee.bcs.valiit.bronapp.model.AuthenticatedUser;
import ee.bcs.valiit.bronapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() { return "/static/index.html";}

    @GetMapping("/booking")
    public String booking() { return "/static/booking.html";}

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            return "/static/error.html";
        }
        if (logout != null) {
            return "/static/logout.html";
        }
        return "/static/login.html";
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    public AuthenticatedUser user() {
        AuthenticatedUser principal = new AuthenticatedUser();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        if (user != null) {
            principal.setId(user.getId());
            principal.setUsername(user.getUsername());
            principal.setName(user.getName());
            principal.setEmail(user.getEmail());
            principal.setRoles(AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        }
        return principal;

    }

}