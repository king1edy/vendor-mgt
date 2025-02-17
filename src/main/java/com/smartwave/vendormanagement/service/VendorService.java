package com.smartwave.vendormanagement.service;

import com.smartwave.vendormanagement.entity.Vendor;
import com.smartwave.vendormanagement.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;

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
