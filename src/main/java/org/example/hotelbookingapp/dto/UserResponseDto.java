package org.example.hotelbookingapp.dto;

import java.util.Set;

public record UserResponseDto(
        Long id,
        String username,
        String email,
        Set<Long> bookingIds
) {
}
