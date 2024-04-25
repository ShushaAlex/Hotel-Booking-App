package org.example.hotelbookingapp.mapper;

import org.example.hotelbookingapp.dto.room.RoomCreateRequestDto;
import org.example.hotelbookingapp.dto.room.RoomResponseDto;
import org.example.hotelbookingapp.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public RoomResponseDto roomResponseDto(Room room) {
        return new RoomResponseDto(
                room.getId(),
                room.getHotel().getTitle(),
                room.getBedCount(),
                room.isPetFriendly(),
                room.getPrice()
        );
    }

    public Room toRoom(RoomCreateRequestDto dto) {
        return Room.builder()
                .bedCount(dto.bedCount())
                .isPetFriendly(dto.isPetFriendly())
                .price(dto.price())
                .build();
    }
}
