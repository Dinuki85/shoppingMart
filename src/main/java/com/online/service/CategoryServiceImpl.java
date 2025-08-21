package com.online.service;

import com.online.model.Category;
import com.online.model.Shop;
import com.online.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ShopService shopService;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {

        Shop shop = shopService.getShopByUserId(userId);
        Category category = new Category();

        category.setName(name);
        category.setShop(shop);



        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByShopId(Long id) throws Exception {
        Shop shop = shopService.getShopByUserId(id);

        return categoryRepository.findByShopId(shop.getId());
    }

    @Override
    public Category findCategoryById(Long id) throws Exception {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isEmpty()){
            throw new Exception("ThisCategory Not found");
        }
        return optionalCategory.get();
    }
}
