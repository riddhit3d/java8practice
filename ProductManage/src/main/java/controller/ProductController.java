package controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Product;
import service.ProductService;



//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct1(@RequestBody Product product) {
	    return Optional.ofNullable(productService.saveProduct(product))
	            .map(savedProduct -> ResponseEntity.status(HttpStatus.CREATED).body(savedProduct))
	            .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
	}


	@GetMapping("/")
	public ResponseEntity<?> getAllProduct() {
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById1(@PathVariable Integer id) {
	    return Optional.ofNullable(productService.getProductById(id))
	            .map(product -> ResponseEntity.ok(product))
	            .orElse(ResponseEntity.notFound().build());
	}


	@GetMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}
	///java 8 featuress
	@GetMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct1(@PathVariable Integer id) {
	    return Optional.ofNullable(productService.deleteProduct(id))
	            .map(product -> ResponseEntity.ok().build())
	            .orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/editProduct/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Integer id) {
		return new ResponseEntity<>(productService.editProduct(product, id), HttpStatus.CREATED);
	}

}