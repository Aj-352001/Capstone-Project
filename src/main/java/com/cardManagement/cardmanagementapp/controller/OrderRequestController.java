package com.cardManagement.cardmanagementapp.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cardManagement.cardmanagementapp.entities.OrderRequest;
import com.cardManagement.cardmanagementapp.entities.OrderResponse;
import com.cardManagement.cardmanagementapp.service.OrderRequestService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class OrderRequestController {
	
	@Autowired
	private OrderRequestService orderRequestService;
	
	
	
	@PostMapping("/createOrder")
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest)throws RazorpayException {
		
		try {
			return this.orderRequestService.createOrder(orderRequest);
			
		} catch (RazorpayException e) {
			throw e;
		}
	}


//	private Order createRazorPayOrder(Double amount) throws RazorpayException {
//		JSONObject options = new JSONObject();
//		options.put("amount", amount * 100.0);
//		options.put("currency", "INR");
//		options.put("receipt", "txn_123456");
//		options.put("payment_capture", 1); // You can enable this if you want to do Auto Capture.
//		return client.orders.create(options);
//	}
	
}
