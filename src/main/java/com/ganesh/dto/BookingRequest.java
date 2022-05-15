package com.ganesh.dto;

import com.ganesh.entity.PassengerInfo;
import com.ganesh.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private PaymentInfo paymentInfo;

    private PassengerInfo passengerInfo;

}
