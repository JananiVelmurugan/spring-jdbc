package com.fis.springjdbc.product;

import java.util.List;

public interface IProduct {

	public void insertProduct(Product product);

	public List<Product> getAllProducts();

	public void updateProduct(Product product);

	public void deleteProduct(int id);

	public Product getProductById(int id);

}
