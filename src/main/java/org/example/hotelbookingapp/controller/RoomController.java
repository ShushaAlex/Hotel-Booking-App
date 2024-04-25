package org.example.hotelbookingapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.hotelbookingapp.dto.room.RoomCreateRequestDto;
import org.example.hotelbookingapp.dto.room.RoomResponseDto;
import org.example.hotelbookingapp.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public RoomResponseDto saveRoom(@RequestBody @Valid RoomCreateRequestDto room) {
        return roomService.saveRoom(room);
    }

    @GetMapping
    public List<RoomResponseDto> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/byDate")
    public List<RoomResponseDto> findFreeRooms(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "dd.MM.yyyy")
            LocalDate endDate) {
        return roomService.findFreeRoomsByDate(startDate, endDate);
    }

    @GetMapping("/byBedCount")
    public List<RoomResponseDto> findByBedCount(@RequestParam("bedCount") byte bedCount) {
        return roomService.findByBedCount(bedCount);
    }

}
