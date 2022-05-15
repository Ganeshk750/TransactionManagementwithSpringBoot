package com.ganesh.controller;

import com.ganesh.dto.BookingRequest;
import com.ganesh.dto.BookingResponse;
import com.ganesh.exception.InsufficentBalanceException;
import com.ganesh.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/booking")
    public BookingResponse bookTicket(@RequestBody BookingRequest bookingRequest) throws InsufficentBalanceException {
       return bookingService.bookTicket(bookingRequest);
    }
}
