package com.example.finalproject.service;

import com.example.finalproject.annotation.Trace;
import com.example.finalproject.domain.Route;
import com.example.finalproject.dto.RouteDTO;
import com.example.finalproject.mapper.RouteMapper;
import com.example.finalproject.mapper.TerminalMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private TerminalMapper terminalMapper;

    @Override
    public int save(Route route) {
        return routeMapper.save(route);
    }

    @Override
    public List<Route> findAll() {
        return routeMapper.findAll();
    }

    @Override
    public int update(Route route) {
        return routeMapper.update(route);

    }

    @Trace
    @Transactional
    @Override
    public List<RouteDTO> findAllByStartTerminalId(int startTerminalId) {
        List<Route> routeList = routeMapper.findAllByStartTerminalId(startTerminalId);
        List<RouteDTO> routeDTOList = new ArrayList<>();
        routeList.forEach(route -> {
            RouteDTO routeDTO = new RouteDTO();
            routeDTO.setId(route.getId());
            routeDTO.setStartTerminal(terminalMapper.findById(route.getStartId()));
            routeDTO.setEndTerminal(terminalMapper.findById(route.getEndId()));
            routeDTO.setTravelTime(route.getTravelTime());
            routeDTOList.add(routeDTO);
        });
        return routeDTOList;
    }

    @Trace
    @Transactional
    @Override
    public List<RouteDTO> findAllDTO() {
        List<Route> routeList = routeMapper.findAll();
        List<RouteDTO> routeDTOList = new ArrayList<>();
        routeList.forEach(route -> {
            RouteDTO routeDTO = new RouteDTO();
            routeDTO.setId(route.getId());
            routeDTO.setStartTerminal(terminalMapper.findById(route.getStartId()));
            routeDTO.setEndTerminal(terminalMapper.findById(route.getEndId()));
            routeDTO.setTravelTime(route.getTravelTime());
            routeDTOList.add(routeDTO);
        });
        return routeDTOList;
    }




    @Override
    public int delete(int id) {
        return routeMapper.delete(id);

    }

    @Override
    public List<Route> find(int startId) {
        return routeMapper.find(startId);
    }

    @Override
    public int findByStartEndPoint(int startId, int endId) {
        Route route = new Route();
        route.setStartId(startId);
        route.setEndId(endId);
        return routeMapper.findByStartEndPoint(route);
    }
}
