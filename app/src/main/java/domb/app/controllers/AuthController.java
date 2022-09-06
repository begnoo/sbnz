package domb.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import domb.app.model.User;
import domb.app.requests.JwtAuthRequest;
import domb.app.responses.AuthenticatedUserResponse;
import domb.app.model.Role;
import domb.app.security.utils.TokenUtils;
import domb.app.services.UserService;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    private final TokenUtils tokenUtils;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Autowired
    public AuthController(TokenUtils tokenUtils, AuthenticationManager authenticationManager,
                                    UserService userService) {
        this.tokenUtils = tokenUtils;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthRequest authenticationRequest) {

        User user = userService.findByEmail(authenticationRequest.getUsername());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<Role> roles = user.getRoles();

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            user = (User) authentication.getPrincipal();
            String fingerprint = tokenUtils.generateFingerprint();
            List<String> rolesString = roles.stream().map(role -> role.getAuthority()).collect(Collectors.toList());
            String jwt = tokenUtils.generateToken(user.getUsername(), fingerprint, rolesString);
            int expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok().body(new AuthenticatedUserResponse(jwt, expiresIn));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader(name="Authorization") String token) {
        token = token.replace("Bearer", "").trim();
        return ResponseEntity.ok("Logout successful.");
    }


}
