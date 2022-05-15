package com.ganesh.utility;

import com.ganesh.exception.InsufficentBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentGatewaySimulator {

    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    {
        accountBalanceMap.put("acnt-1212",2000.0);
        accountBalanceMap.put("acnt-1214",2500.0);
        accountBalanceMap.put("acnt-1313",4000.0);
        accountBalanceMap.put("acnt-1414",3000.0);
    }

    public static boolean validateFareBalanceCriteria(String accountNo, Double fare) throws InsufficentBalanceException {
        if(fare > accountBalanceMap.get(accountNo)){
            throw new InsufficentBalanceException("You do not have sufficient balance in your account: "+accountNo);
        }
        return true;
    }
}
