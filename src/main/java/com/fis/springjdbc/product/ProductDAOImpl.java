package com.fis.springjdbc.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

public class ProductDAOImpl extends JdbcDaoSupport implements IProduct {

	public List<Product> getAllProducts() {
		String sql = "select * from product";
//		List<Product> products = getJdbcTemplate().query(sql, new RowMapper<Product>() {
//			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Product product = new Product();
//				product.setId(rs.getInt("id"));
//				product.setName(rs.getString("name"));
//				return product;
//			}
//		});
//		List<Product> products = getJdbcTemplate().query(sql, (rs, rowNum) -> {
//			Product product = new Product();
//			product.setId(rs.getInt("id"));
//			product.setName(rs.getString("name"));
//			return product;
//		});
		List<Product> products = getJdbcTemplate().query(sql, new ProductMapper());

		return products;
	}

	public void insertProduct(Product product) {

		String sql = "insert into product values(?,?)";
		Object[] args = { product.getId(), product.getName() };
		int insertedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Inserted: " + insertedRows);

	}

	@Override
	public void deleteProduct(int id) {

		String sql = "delete from product where id=?";
		Object[] args = { id };
		int deletedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Deleted: " + deletedRows);
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "update product set name=? where id=?";
		Object[] args = { product.getName(), product.getId() };
		int updatedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Updated: " + updatedRows);

	}

	@Override
	public Product getProductById(int id) {
		String sql = "select * from product where id=?";
		Object[] args = { id };
		ProductMapper mapper = new ProductMapper();
		Product productById = getJdbcTemplate().queryForObject(sql, args, mapper::mapRow);
		return productById;
	}

}
