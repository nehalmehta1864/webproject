package com.niit.dao;

	import java.util.List;

import com.niit.model.Category;

	public interface categorydao {
		public void savecategory(Category category);
		public List<Category> getCategories();
		public boolean delete(Category category);
		public Category getcategorybyid(int id);
/*		public Category findById(int parseInt);
*/
}

	