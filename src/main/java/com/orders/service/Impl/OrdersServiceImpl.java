package com.orders.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.DTO.OrdersDTO;
import com.orders.Repository.OrdersRepository;
import com.orders.Repository.entity.OrdersEntity;
import com.orders.service.OrdersService;
@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public List<OrdersDTO> findAll(Map<String, Object> find) {
		List<OrdersEntity> entities = ordersRepository.findAll(find);
		List<OrdersDTO> results = new ArrayList<OrdersDTO>();
		for(OrdersEntity it : entities) {
			OrdersDTO dto = new OrdersDTO();
			dto.setMonAnId(it.getMonAnId());
			dto.setTenMon(it.getTenMon());
			dto.setMoTa(it.getMoTa());
			dto.setGia(it.getGia());
			if(it.getLoaiId()==1) {
				dto.setLoaiId("Mì");
			}
			if(it.getLoaiId()==2) {
				dto.setLoaiId("Cơm");
			}
			if(it.getLoaiId()==3) {
				dto.setLoaiId("Canh");
			}
			if(it.getLoaiId()==4) {
				dto.setLoaiId("Mực");
			}
			if(it.getCoSan().equals("1")) {
				dto.setCoSan("Còn hàng");
			}
			if(!it.getCoSan().equals("1")) {
				dto.setCoSan("Món ăn đã hết");
			}
			dto.setTrangThai(it.getTrangThai());
			dto.setNgayTao(it.getNgayTao());
			results.add(dto);
		}
		return results;
	}

}
