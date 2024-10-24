package com.orders.Repository;

import java.util.List;
import java.util.Map;

import com.orders.Repository.entity.OrdersEntity;

public interface OrdersRepository {
public List<OrdersEntity> findAll (Map<String, Object> find);
}
