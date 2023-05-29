package com.example.BookMyShowdemo.Controller;

import com.example.BookMyShowdemo.Service.implementation.ShowServiceImpl;
import com.example.BookMyShowdemo.dto.requestDto.Showdto;
import com.example.BookMyShowdemo.dto.responseDto.ShowResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody Showdto showdto){
        return showService.addShow(showdto);
    }

    @GetMapping("/get/{id}")
    public ShowResponseDto getShow(@PathVariable int id){
        return showService.getShow(id);
    }
}
