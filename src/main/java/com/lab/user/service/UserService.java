package com.lab.user.service;

import com.lab.common.exception.ApiException;
import com.lab.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final Map<Long, UserDto> userStore = new ConcurrentHashMap<>();

    public UserService() {
        // Initialize mock users
        userStore.put(1L, new UserDto(1L, "John Doe", "john@example.com"));
        userStore.put(2L, new UserDto(2L, "Jane Smith", "jane@example.com"));
        userStore.put(3L, new UserDto(3L, "Bob Wilson", "bob@example.com"));
    }

    public List<UserDto> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    public UserDto getUserById(Long id) {
        UserDto user = userStore.get(id);
        if (user == null) {
            throw new ApiException(404, "USER_NOT_FOUND", "User not found with id: " + id);
        }
        return user;
    }
}
