package com.cardManagement.cardmanagementapp.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cardManagement.cardmanagementapp.entities.OrderRequest;
import com.cardManagement.cardmanagementapp.entities.OrderResponse;
import com.razorpay.Order;
import com.razorpay.RazorpayException;


public interface OrderRequestService {
	
	OrderResponse createOrder (OrderRequest orderRequest)throws RazorpayException;
	//JSONObject createRazorPayOrder (Double amount)throws RazorpayException;

}
