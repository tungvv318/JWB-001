package com.uetcodecamp.jwb01.service;

import com.uetcodecamp.jwb01.model.Category;
import com.uetcodecamp.jwb01.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category getFirstCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()) {
            return null;
        }
        return categoryList.get(0);
    }
}
