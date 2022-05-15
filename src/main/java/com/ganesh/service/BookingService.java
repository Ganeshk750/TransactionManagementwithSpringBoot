package com.ganesh.service;

import com.ganesh.dto.BookingRequest;
import com.ganesh.dto.BookingResponse;
import com.ganesh.exception.InsufficentBalanceException;

public interface BookingService {

    public BookingResponse bookTicket(BookingRequest bookingRequest) throws InsufficentBalanceException;
}
