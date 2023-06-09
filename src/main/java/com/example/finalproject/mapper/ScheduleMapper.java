package com.example.finalproject.mapper;

import com.example.finalproject.domain.Schedule;
import com.example.finalproject.dto.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface ScheduleMapper {
    public ScheduleDTO findById(HashMap map);
    public List<ScheduleDTO> findByRouteId(ScheduleDTO scheduleDTO);
    public int save(Schedule schedule);
    public List<Schedule> findAll();
    public List<ScheduleDTO> findAllDTO();
    public List<Schedule> findDaily(String date);

}
