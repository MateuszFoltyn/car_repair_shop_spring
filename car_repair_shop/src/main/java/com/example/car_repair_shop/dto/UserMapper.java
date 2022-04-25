package com.example.car_repair_shop.dto;

import com.example.car_repair_shop.persistance.User;
import com.example.car_repair_shop.persistance.UserRole;
import com.example.car_repair_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserMapper {

    public static UserDTO toDTO(User user) {
        Long userId = user.getId();
        List<String> roles = user
                .getRoles()
                .stream()
                .map(UserRole::getRole)
                .collect(Collectors.toList());

        return new UserDTO(userId, roles);

    }



}
