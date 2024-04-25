package org.example.hotelbookingapp.service;

import org.example.hotelbookingapp.dto.room.RoomCreateRequestDto;
import org.example.hotelbookingapp.dto.room.RoomResponseDto;
import org.example.hotelbookingapp.entity.Hotel;
import org.example.hotelbookingapp.entity.Room;
import org.example.hotelbookingapp.exception.HotelException;
import org.example.hotelbookingapp.mapper.RoomMapper;
import org.example.hotelbookingapp.repository.HotelRepository;
import org.example.hotelbookingapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;

    @Autowired
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.roomMapper = roomMapper;
    }

    public List<RoomResponseDto> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::roomResponseDto)
                .toList();
    }

    public List<RoomResponseDto> findByBedCount(byte bedCount) {
        return roomRepository.findAllByBedCount(bedCount)
                .stream()
                .map(roomMapper::roomResponseDto)
                .toList();
    }

    public List<RoomResponseDto> findFreeRoomsByDate(LocalDate startDate, LocalDate endDate) {
        Collection<Room> reservedByDate = roomRepository.findFreeRooms(startDate, endDate);
        return reservedByDate.stream()
                .map(roomMapper::roomResponseDto)
                .toList();
    }

    @Transactional
    public RoomResponseDto saveRoom(RoomCreateRequestDto requestDto) {
        Hotel hotel = hotelRepository.findById(requestDto.hotelId()).orElseThrow(() -> new HotelException("no such hotel"));
        Room room = roomMapper.toRoom(requestDto);
        room.setHotel(hotel);
        hotel.addRoom(room);

        return roomMapper.roomResponseDto(roomRepository.save(room));
    }

}
