package com.smartwave.vendormanagement.service;

import com.smartwave.vendormanagement.dto.*;
import com.smartwave.vendormanagement.entity.Vendor;
import com.smartwave.vendormanagement.entity.VendorCategory;
import com.smartwave.vendormanagement.entity.VendorStatus;
import com.smartwave.vendormanagement.exception.ResourceNotFoundException;
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

    public VendorResponseDTO createVendor(VendorRequestDTO dto) {
        VendorCategory category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        VendorStatus status = statusRepository.findById(dto.getStatusId())
                .orElseThrow(() -> new ResourceNotFoundException("Status not found"));

        Vendor vendor = new Vendor();
        vendor.setName(dto.getName());
        vendor.setEmail(dto.getEmail());
        vendor.setPhoneNumber(dto.getPhoneNumber());
        vendor.setCategory(category);
        vendor.setStatus(status);

        Vendor savedVendor = vendorRepository.save(vendor);
        return mapToResponseDTO(savedVendor);
    }

    public List<VendorResponseDTO> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return vendors.stream().map(this::mapToResponseDTO).toList();
    }

    public VendorResponseDTO getVendorById(UUID id) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        return mapToResponseDTO(vendor);
    }

    public VendorResponseDTO updateVendor(UUID id, VendorRequestDTO dto) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        if (dto.getName() != null) vendor.setName(dto.getName());
        if (dto.getEmail() != null) vendor.setEmail(dto.getEmail());
        if (dto.getPhoneNumber() != null) vendor.setPhoneNumber(dto.getPhoneNumber());

        if (dto.getCategoryId() != null) {
            VendorCategory category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
            vendor.setCategory(category);
        }

        if (dto.getStatusId() != null) {
            VendorStatus status = statusRepository.findById(dto.getStatusId())
                    .orElseThrow(() -> new ResourceNotFoundException("Status not found"));
            vendor.setStatus(status);
        }

        Vendor updatedVendor = vendorRepository.save(vendor);
        return mapToResponseDTO(updatedVendor);
    }

    public void deleteVendor(UUID id) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        vendorRepository.delete(vendor);
    }

    private VendorResponseDTO mapToResponseDTO(Vendor vendor) {
        return new VendorResponseDTO(
                vendor.getId(),
                vendor.getName(),
                vendor.getEmail(),
                vendor.getPhoneNumber(),
                vendor.getCategory().getName(),
                vendor.getStatus().getStatusName(),
                vendor.getCreatedAt(),
                vendor.getUpdatedAt()
        );
    }
}
