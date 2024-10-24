package com.orders.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orders.DTO.OrdersDTO;
import com.orders.service.OrdersService;

@RestController
public class OrdersAPI {
@Autowired
private OrdersService ordersService;
@GetMapping("/api/order")
private Object getorders (@RequestParam(required = false) Map<String, Object> find) {
	List<OrdersDTO> dtos = ordersService.findAll(find);
	return dtos;
}
}
