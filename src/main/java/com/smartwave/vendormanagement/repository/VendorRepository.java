package com.smartwave.vendormanagement.repository;

import com.smartwave.vendormanagement.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendorRepository extends JpaRepository<Vendor, UUID> {
}
