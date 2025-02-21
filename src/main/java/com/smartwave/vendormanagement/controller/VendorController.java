package com.smartwave.vendormanagement.controller;


import com.smartwave.vendormanagement.dto.VendorRequestDTO;
import com.smartwave.vendormanagement.dto.VendorResponseDTO;
import com.smartwave.vendormanagement.entity.Document;
import com.smartwave.vendormanagement.entity.Vendor;
import com.smartwave.vendormanagement.service.DocumentService;
import com.smartwave.vendormanagement.service.VendorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;
    private final DocumentService documentService;


    @PostMapping
    public ResponseEntity<VendorResponseDTO> createVendor(
            @Valid @RequestBody VendorRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vendorService.createVendor(requestDTO));
    }

    @PostMapping("upload-document")
    public ResponseEntity<Document> createDocument(@RequestBody @Valid Document document) {
        Document saveddocument = documentService.createDocument(document);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveddocument);
    }

    @GetMapping
    public ResponseEntity<List<VendorResponseDTO>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorResponseDTO> getVendorById(@PathVariable UUID id) {
        return ResponseEntity.ok(vendorService.getVendorById(id));

    }

    @GetMapping("/get-vendor-documents")
    public ResponseEntity<List<Document>> getVendorDocuments() {
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

    @GetMapping("/get-vendor-document{id}")
    public ResponseEntity<Document> getVendorDocumentById(@PathVariable UUID id) {
        return documentService.getDocumentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorResponseDTO> updateVendor(
            @PathVariable UUID id,
            @Valid @RequestBody VendorRequestDTO requestDTO) {
        return ResponseEntity.ok(vendorService.updateVendor(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable UUID id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-document{id}")
    public ResponseEntity<Void> deleteVendorDocumentById(@PathVariable UUID id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

}
