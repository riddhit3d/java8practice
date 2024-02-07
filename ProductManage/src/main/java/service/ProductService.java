package service;



import java.util.List;

import entity.Product;


public interface ProductService {

	public Product saveProduct(Product product);

	public List<Product> getAllProduct();

	public Product getProductById(Integer id);



	public Product editProduct(Product product,Integer id);

	Product getProductById1(Integer id);

	String deleteProduct(Integer id);
	
}