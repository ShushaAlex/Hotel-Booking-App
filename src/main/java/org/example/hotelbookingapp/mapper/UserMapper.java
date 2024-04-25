package org.example.hotelbookingapp.mapper;

import org.example.hotelbookingapp.dto.user.UserResponseDto;
import org.example.hotelbookingapp.entity.Booking;
import org.example.hotelbookingapp.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getBookings().stream().map(Booking::getId).collect(Collectors.toSet())
        );
    }
}
