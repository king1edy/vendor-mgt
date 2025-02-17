package com.smartwave.vendormanagement.repository;

import com.smartwave.vendormanagement.entity.VendorCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendorCategoryRepository extends JpaRepository<VendorCategory, UUID> {
}
