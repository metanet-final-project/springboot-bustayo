package com.example.finalproject.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ScheduleDTO {
    private int id;
    private RouteDTO routeDTO;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date endTime;
    private BusDTO busDTO;
    private int price;
    private int countSeat;
}
