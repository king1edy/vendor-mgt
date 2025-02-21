package com.smartwave.vendormanagement.controller;

import com.smartwave.vendormanagement.dto.StatusRequestDTO;
import com.smartwave.vendormanagement.dto.StatusResponseDTO;
import com.smartwave.vendormanagement.service.StatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @PostMapping
    public ResponseEntity<StatusResponseDTO> createStatus(
            @Valid @RequestBody StatusRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(statusService.createStatus(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<StatusResponseDTO>> getAllStatuses() {
        return ResponseEntity.ok(statusService.getAllStatuses());
    }
}

