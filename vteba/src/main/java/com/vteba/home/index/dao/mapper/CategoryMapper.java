package com.vteba.home.index.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vteba.home.index.model.Category;

/**
 * 商品分类Mapper
 * @author yinlei
 * @date 2013-12-28 17:26:25
 */
public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
    	category.setState(rs.getInt("state"));
    	category.setCategoryName(rs.getString("category_name"));
    	category.setParentCategory(rs.getInt("parent_category"));
    	category.setCategoryType(rs.getInt("category_type"));
    	category.setCategoryId(rs.getInt("category_id"));
    	category.setParentName(rs.getString("parent_name"));
    	return category;
	}

}
