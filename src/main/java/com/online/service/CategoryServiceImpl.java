package com.online.service;

import com.online.model.Category;
import com.online.model.Shop;
import com.online.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ShopService shopService;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {

        Shop shop = shopService.findShopBYId(userId);
        Category category = new Category();

        category.setName(name);
        category.setShop(shop);



        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByShopId(Long id) throws Exception {
        return List.of();
    }

    @Override
    public Category findCategoryById(Long id) throws Exception {
        return null;
    }
}
