package com.lisq.atomikos.demo;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.lisq.atomikos.demo.order.OrderService;

@SpringBootApplication
@ImportResource("classpath:config-imac.xml")
public class AtomikosDemoApplication {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(AtomikosDemoApplication.class, args);
		OrderService orderService = context.getBean(OrderService.class);
		orderService.addOrder();
	}
}
