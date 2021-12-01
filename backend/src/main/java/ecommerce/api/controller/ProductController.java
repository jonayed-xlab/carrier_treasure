package ecommerce.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.api.model.Product;
import ecommerce.api.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public Product submitProdut(@RequestBody Product product) {
		return productService.sumitToDB(product);
	}
	
	@GetMapping
	public ArrayList<Product> retriveProduct(){
		return productService.retriveProductFromDB();
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteProduct(@PathVariable int id) {
		 productService.deleteProductFromDB(id);
	}
	
	@GetMapping("/total")
	public long getTotalProduct() {
		return productService.totalProduct();
	}
}
