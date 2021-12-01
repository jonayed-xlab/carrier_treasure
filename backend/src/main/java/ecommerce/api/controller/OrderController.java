package ecommerce.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ecommerce.api.model.Order;
import ecommerce.api.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	

		
	
	@PostMapping("")
	public Order submitUserOrder(@RequestBody Order orders) {
		return orderService.submitOrderToDB(orders);
	}
	
	@GetMapping("")
	public ArrayList<Order> getAllOrder(){
		return orderService.retriveOrderFromDB();
	}
	
	@GetMapping("/{id}")
	public Optional<Order> detailsOrderFromDB(@PathVariable int id){
		return orderService.detailsOrderFromDB(id);
	}
	@GetMapping("/total")
	public long getTotalOrder() {
		return orderService.totalOrder();
	}
	
	@GetMapping("/amount")
	public Long getTotalTaka() {
	
		return orderService.totalTaka();
	}
}

