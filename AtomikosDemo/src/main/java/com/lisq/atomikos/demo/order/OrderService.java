package com.lisq.atomikos.demo.order;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderService {
	@Autowired()
	@Qualifier("datasource1")
	private DataSource dataSource1;
	@Autowired
	@Qualifier("datasource2")
	private DataSource dataSource2;
	@Transactional
	public void addOrder() throws SQLException {
		Connection conn1 = dataSource1.getConnection();
		Connection conn2 = dataSource2.getConnection();
		Statement statement1 =conn1.createStatement();
		Statement statement2 =conn2.createStatement();
//		statement1.execute("insert into iorder(orderno)values('1')");
//		statement2.execute("insert into iorder(orderno)values('1')");
		statement1.executeUpdate("update iorder set orderno = '2'");
		statement2.executeUpdate("update iorder set orderno = '2'");
//		int i = 1/0;
		conn1.close();
		conn2.close();
	}
}
