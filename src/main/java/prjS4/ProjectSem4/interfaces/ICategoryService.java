package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Categories;

public interface ICategoryService {
    
    List<Categories> getAllCategories();
    
    Categories getCategoryById(String id);
    
    Categories createCategory(Categories category);
    
    Categories updateCategory(String id, Categories category);
    
    boolean deleteCategory(String id);
    
}
