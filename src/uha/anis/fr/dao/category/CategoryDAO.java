package uha.anis.fr.dao.category;

import java.util.List;

import uha.anis.fr.entities.Category;

public interface CategoryDAO {
	void addCategory(Category category);

	List<Category> getCategories();

	Category getCategoryById(int id);

	void UpdateCategory(Category category);

	long getNumberCategory();

	void deteleCategory(Category category);

}
