package com.smartwave.vendormanagement.service;

import com.smartwave.vendormanagement.entity.Vendor;
import com.smartwave.vendormanagement.repository.VendorCategoryRepository;
import com.smartwave.vendormanagement.repository.VendorRepository;
import com.smartwave.vendormanagement.repository.VendorStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;
    private final VendorCategoryRepository categoryRepository;
    private final VendorStatusRepository statusRepository;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(UUID id) {
        return vendorRepository.findById(id);
    }

    public void deleteVendor(UUID id) {
        vendorRepository.deleteById(id);
    }
}
