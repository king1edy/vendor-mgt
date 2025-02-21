package com.smartwave.vendormanagement.service;

import com.smartwave.vendormanagement.dto.StatusRequestDTO;
import com.smartwave.vendormanagement.dto.StatusResponseDTO;
import com.smartwave.vendormanagement.entity.VendorStatus;
import com.smartwave.vendormanagement.repository.VendorStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final VendorStatusRepository statusRepository;

    public StatusResponseDTO createStatus(StatusRequestDTO dto) {
        VendorStatus status = new VendorStatus();
        status.setStatusName(dto.getStatusName());
        status.setDescription(dto.getDescription());
        VendorStatus saved = statusRepository.save(status);
        return new StatusResponseDTO(saved.getId(), saved.getStatusName(), saved.getDescription());
    }

    public List<StatusResponseDTO> getAllStatuses() {
        return statusRepository.findAll().stream()
                .map(st -> new StatusResponseDTO(st.getId(), st.getStatusName(), st.getDescription()))
                .toList();
    }
}
