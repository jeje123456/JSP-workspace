package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import member.Order;

public class OrderDao {
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public  OrderDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Order> findAll() {
		List<Order> ordersList = new ArrayList<Order>();

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from shop.order");
			rs = pstmt.executeQuery(); // 쿼리문 실행

			while (rs.next()) { // 반복문으로 orders 리스트 저장
				Order order = new Order();
				
				order.setOrderID(rs.getInt("orderID"));
				order.setCartID(rs.getInt("cartID"));
				order.setUserID(rs.getString("userID"));
				order.setUserName(rs.getString("userName")); ;
				order.setUserAdd(rs.getString("userAdd"));
				order.setUserTel(rs.getString("userTel")); 
				order.setProdID(rs.getInt("prodID"));
				order.setProdName(rs.getString("prodName"));
				order.setProdPrice(rs.getInt("prodPrice")); 
				order.setProdQuantity(rs.getInt("prodQuantity"));
				order.setTotalPrice(rs.getInt("totalPrice"));
				order.setFarmID(rs.getString("farmID"));
				order.setFarmTel(rs.getString("farmTel"));
				order.setFarmCheck(rs.getString("farmCheck"));
				order.setTrackNum(rs.getInt("TrackNum"));
				order.setIs_status(rs.getString("is_status"));

				ordersList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return ordersList;
	}

	private void closeAll() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close(); // 실제로는 Connection Pool로 되돌아감
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
