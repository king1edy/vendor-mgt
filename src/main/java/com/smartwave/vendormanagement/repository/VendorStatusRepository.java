package com.smartwave.vendormanagement.repository;

import com.smartwave.vendormanagement.entity.VendorStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendorStatusRepository extends JpaRepository<VendorStatus, UUID> {}
