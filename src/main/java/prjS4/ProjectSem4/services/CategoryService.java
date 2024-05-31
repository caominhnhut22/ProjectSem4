package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Categories;
import prjS4.ProjectSem4.interfaces.ICategoryService;
import prjS4.ProjectSem4.repositories.CategoryRepository;

@Service
public class CategoryService implements ICategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Categories getCategoryById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Categories createCategory(Categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public Categories updateCategory(String id, Categories categoryDetails) {
        return categoryRepository.findById(id).map((var categories) -> {
            categoryDetails.setCateName(categoryDetails.getCateName());
            categoryDetails.setCateStatus(categoryDetails.getCateStatus());
            return categoryRepository.save(categoryDetails);
        }).orElse(null);
    }

    @Override
    public boolean deleteCategory(String id) {
        return categoryRepository.findById(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
    }
    
    
    
}
