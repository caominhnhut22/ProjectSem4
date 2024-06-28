package prjS4.ProjectSem4.securities.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import prjS4.ProjectSem4.entities.Access;

import prjS4.ProjectSem4.entities.Accounts;
import prjS4.ProjectSem4.securities.dto.LoginRequest;
import prjS4.ProjectSem4.securities.dto.RegisterRequest;
import prjS4.ProjectSem4.securities.jwt.JwtResponse;
import prjS4.ProjectSem4.securities.jwt.JwtService;
import prjS4.ProjectSem4.securities.service.IAccessService;
import prjS4.ProjectSem4.securities.service.IAccountService;
import prjS4.ProjectSem4.securities.service.IRoleService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAccessService accessService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest registerRequest) {
        // Log the incoming request
        System.out.println("Incoming register request: " + registerRequest);

        Accounts newAccount = new Accounts();
        newAccount.setUserName(registerRequest.getUserName());
        String encodedPassword = passwordEncoder.encode(registerRequest.getUserPassword());
        newAccount.setUserPassword(encodedPassword); // Encode password
        newAccount.setUserStatus(1);

        // Log encoded password
        System.out.println("Encoded password: " + encodedPassword);

        accountService.save(newAccount);

        Access access = new Access();
        access.setAccId(newAccount);
        access.setRoleId(roleService.findByRoleNum(5));
        accessService.save(access);

        return "Đăng ký tài khoản thành công";
    }
    
//    @PostMapping("/login")
//    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
//        try {
//            System.out.println("Logging in with Username: " + loginRequest.getUserName());
//            System.out.println("Logging in with Password: " + loginRequest.getUserPassword());
//
//            // Fetch user details manually
//            UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUserName());
//
//            // Log fetched user details
//            System.out.println("Fetched UserDetails: " + userDetails.getUsername() + ", Password: " + userDetails.getPassword());
//
//            // Manually check password
//            if (!passwordEncoder.matches(loginRequest.getUserPassword(), userDetails.getPassword())) {
//                System.out.println("Password mismatch");
//                throw new RuntimeException("Tên đăng nhập hoặc mật khẩu không chính xác");
//            }
//
//            // Authentication
//            Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getUserPassword())
//            );
//
//            // Log authenticated user details
//            System.out.println("Authenticated User: " + userDetails.getUsername());
//
//            // Generate token
//            String jwt = jwtService.generateToken(userDetails);
//
//            // Log generated token
//            System.out.println("Generated JWT: " + jwt);
//
//            // Return token
//            return new JwtResponse(jwt);
//        } catch (AuthenticationException e) { // Log the exception
//            // Log the exception
//            throw new RuntimeException("Tên đăng nhập hoặc mật khẩu không chính xác");
//        }
//    }
    
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUserName(),
                loginRequest.getUserPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateToken(authentication);

        return new JwtResponse(jwt);
    }
    
}



