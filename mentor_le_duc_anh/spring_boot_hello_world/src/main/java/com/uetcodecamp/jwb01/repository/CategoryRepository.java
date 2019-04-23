package com.uetcodecamp.jwb01.repository;

import com.uetcodecamp.jwb01.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();

        categoryList.add(new Category("Thời gian", "Mô tả về thời trang"));
        categoryList.add(new Category("Điện tử", "Mô tả về điện tử"));
        categoryList.add(new Category("Đồ gia dụng", "Mô tả về đồ gia dụng"));

        return categoryList;
    }
}
