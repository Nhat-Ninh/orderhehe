package com.orders.Repository.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.orders.Repository.OrdersRepository;
import com.orders.Repository.entity.OrdersEntity;
@Repository
public class OrdersRepositoryImpl implements OrdersRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/orders";
	static final String USER = "root";
	static final String PASS = "123456";
	@Override
	public List<OrdersEntity> findAll(Map<String, Object> find) {
		String sql = "  SELECT * FROM orders.monan ";
		String sql1 = " ";
		if (find.get("monAnId") != null) {
			sql1 += " AND monan.monAnId LIKE '% " + find.get("monAnId")+ " %'";
		}
		sql += " WHERE 1=1 "+ sql1;
		List<OrdersEntity> results = new ArrayList<OrdersEntity>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql)) {
			System.out.println("Success");
			while(rs.next()) {
				OrdersEntity entity = new OrdersEntity();
				entity.setMonAnId(rs.getString("monAnId"));
				entity.setTenMon(rs.getString("tenMon"));
				entity.setMoTa(rs.getString("moTa"));
				entity.setGia(rs.getLong("gia"));
				entity.setLoaiId(rs.getLong("loaiId"));
				entity.setHinhAnhUrl(rs.getString("hinhAnhUrl"));
				entity.setCoSan(rs.getString("coSan"));
				entity.setTrangThai(rs.getString("trangThai"));
				entity.setNgayTao(rs.getString("ngayTao"));
				results.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FALSE...");
		}
		return results;
	}

}
