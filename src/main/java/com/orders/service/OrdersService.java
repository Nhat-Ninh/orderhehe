package com.orders.service;

import java.util.List;
import java.util.Map;

import com.orders.DTO.OrdersDTO;

public interface OrdersService {
public List<OrdersDTO> findAll (Map<String, Object> find);
}
