package org.example.hotelbookingapp.service;

import org.example.hotelbookingapp.dto.RoomCreateRequestDto;
import org.example.hotelbookingapp.dto.RoomResponseDto;
import org.example.hotelbookingapp.entity.Room;
import org.example.hotelbookingapp.mapper.RoomMapper;
import org.example.hotelbookingapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Transactional
    public RoomResponseDto saveRoom(RoomCreateRequestDto requestDto) {
        Room room = roomMapper.toRoom(requestDto);
        room.getHotel().addRoom(room);

        return roomMapper.roomResponseDto(roomRepository.save(room));
    }


}
