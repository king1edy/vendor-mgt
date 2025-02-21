package com.smartwave.vendormanagement.service;

import com.smartwave.vendormanagement.dto.CategoryRequestDTO;
import com.smartwave.vendormanagement.dto.CategoryResponseDTO;
import com.smartwave.vendormanagement.entity.VendorCategory;
import com.smartwave.vendormanagement.repository.VendorCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final VendorCategoryRepository categoryRepository;

    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
        VendorCategory category = new VendorCategory();
        category.setName(dto.getName());
        VendorCategory saved = categoryRepository.save(category);
        return new CategoryResponseDTO(saved.getId(), saved.getName());
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(cat -> new CategoryResponseDTO(cat.getId(), cat.getName()))
                .toList();
    }
}
