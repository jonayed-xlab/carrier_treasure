package ecommerce.api.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ecommerce.api.model.Order;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Integer>{
	ArrayList<Order> findAll();
	
	@Query(value="select sum(amount) from orders",nativeQuery=true)
	Long totalAmount();
	
}
