package org.example.hotelbookingapp.mapper;

import org.example.hotelbookingapp.dto.RoomCreateRequestDto;
import org.example.hotelbookingapp.dto.RoomResponseDto;
import org.example.hotelbookingapp.entity.Hotel;
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

    //TODO починить связь с отелем
    public Room toRoom(RoomCreateRequestDto dto) {
        return Room.builder()
                .hotel(new Hotel().builder().id(dto.hotelId()).build())
                .bedCount(dto.bedCount())
                .isPetFriendly(dto.isPetFriendly())
                .price(dto.price())
                .build();
    }
}
