package ch.zhaw.CineSearch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.CineSearch.entity.Times;
import ch.zhaw.CineSearch.entity.TimesRepository;

@Component
public class TimesController {

    @Autowired
    private TimesRepository timesRepository;

    public Optional<Times> listTimesById(Long showtimeId) {
        return timesRepository.findById(showtimeId);
        } 
    }