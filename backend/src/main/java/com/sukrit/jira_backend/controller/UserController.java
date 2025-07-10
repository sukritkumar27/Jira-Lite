package com.sukrit.jira_backend.controller;

import com.sukrit.jira_backend.dto.GenericResponse;
import com.sukrit.jira_backend.dto.user.UserDto;
import com.sukrit.jira_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<GenericResponse<UserDto>> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(new GenericResponse<>(userService.getUserById(userId)));
    }

}
