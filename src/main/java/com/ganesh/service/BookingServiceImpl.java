package com.ganesh.service;

import com.ganesh.dto.BookingRequest;
import com.ganesh.dto.BookingResponse;
import com.ganesh.entity.PassengerInfo;
import com.ganesh.entity.PaymentInfo;
import com.ganesh.exception.InsufficentBalanceException;
import com.ganesh.repository.PassengerInfoRepository;
import com.ganesh.repository.PaymentInfoRepository;
import com.ganesh.utility.PaymentGatewaySimulator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final PaymentInfoRepository paymentInfoRepository;

    private final PassengerInfoRepository passengerInfoRepository;

    @Override
    public BookingResponse bookTicket(BookingRequest bookingRequest) throws InsufficentBalanceException {
        BookingResponse bookingResponse = null;
        PassengerInfo passengerInfo = passengerInfoRepository.save(bookingRequest.getPassengerInfo());
        PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();

        // Simulate tx failure due to insufficient balance in a/c
        PaymentGatewaySimulator.validateFareBalanceCriteria(paymentInfo.getAccountNo(), paymentInfo.getTotalFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setTotalFare(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        bookingResponse = new BookingResponse();
        bookingResponse.setStatus("success");
        bookingResponse.setPassengerInfo(passengerInfo);
        bookingResponse.setPnr(UUID.randomUUID().toString().split("-")[0]);
        bookingResponse.setTotalFare(passengerInfo.getFare());
        return bookingResponse;
    }
}
