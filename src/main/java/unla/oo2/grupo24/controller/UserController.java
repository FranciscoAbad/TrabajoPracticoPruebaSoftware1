package unla.oo2.grupo24.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unla.oo2.grupo24.entity.User;
import unla.oo2.grupo24.entity.UserRole;
import unla.oo2.grupo24.helpers.ViewRouteHelper;
import unla.oo2.grupo24.repository.IUserRepository;
import unla.oo2.grupo24.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;


@Controller
public class UserController {

    private final IUserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserController(IUserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        return ViewRouteHelper.USER_REGISTER;
    }
    @PostMapping("/register/form")
    public ResponseEntity<String> registerUser(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("adminPassword") String adminPassword) {
        // Validate the username and password as per your requirements
        // ...

String adminPass="unlaAdmin1234*";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPass=passwordEncoder.encode(password);


        // Create a new User object with the registration details
        User newUser = new User(username, encodedPass,true);

        // Save the new user to the UserRepository
        userRepository.save(newUser);
        roleRepository.save(new UserRole(newUser,"ROLE_AUDITOR"));
        if(adminPassword.equals(adminPass)){
            roleRepository.save(new UserRole(newUser,"ROLE_ADMIN"));
        }

        return ResponseEntity.ok("User registered successfully");
    }


    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(name="error",required=false) String error,
                        @RequestParam(name="logout", required=false) String logout) {
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        return ViewRouteHelper.USER_LOGIN;
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return ViewRouteHelper.USER_LOGOUT;
    }

    @GetMapping("/loginsuccess")
    public String loginCheck() {
        return "redirect:/index";
    }
}