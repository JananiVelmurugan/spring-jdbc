package com.fis.springjdbc.product;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProduct {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("daoexample.xml");
		ProductDAOImpl bean = context.getBean("productDao", ProductDAOImpl.class);

		System.out.println("===============================");
		System.out.println("Insert a Product");
		Product newProduct = new Product();
		newProduct.setId(30);
		newProduct.setName("eraser");
		bean.insertProduct(newProduct);
		System.out.println("===============================");
		System.out.println("Delete Product");
		int id = 10;
		bean.deleteProduct(id);
		System.out.println("===============================");
		System.out.println("Get Product Based on Id");
		id = 20;
		Product productById = bean.getProductById(id);
		System.out.println(productById);
		System.out.println("===============================");
		System.out.println("Update Product");
		newProduct = new Product();
		newProduct.setId(30);
		newProduct.setName("browneraser");
		bean.updateProduct(newProduct);
		System.out.println("===============================");
		System.out.println("Get All Products");
		System.out.println(bean.getAllProducts());
		System.out.println("===============================");

		context.close();
	}

}
