package com.example.car_repair_shop.web;

import com.example.car_repair_shop.persistance.User;
import com.example.car_repair_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<User> signup(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
