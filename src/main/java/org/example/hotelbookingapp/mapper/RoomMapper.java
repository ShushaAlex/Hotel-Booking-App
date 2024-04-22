package org.example.hotelbookingapp.mapper;

import org.example.hotelbookingapp.dto.RoomCreateRequestDto;
import org.example.hotelbookingapp.dto.RoomResponseDto;
import org.example.hotelbookingapp.entity.Hotel;
import org.example.hotelbookingapp.entity.Room;
import org.example.hotelbookingapp.exception.HotelNotFoundException;
import org.example.hotelbookingapp.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    private final HotelRepository hotelRepository;

    @Autowired
    public RoomMapper(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

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
        Hotel hotel = hotelRepository.findById(dto.hotelId()).orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        return Room.builder()
                .hotel(hotel)
                .bedCount(dto.bedCount())
                .isPetFriendly(dto.isPetFriendly())
                .price(dto.price())
                .build();
    }
}
