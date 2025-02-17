package com.smartwave.vendormanagement.controller;


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

//    @Autowired
//    public VendorController(VendorService vendorService, DocumentService documentService) {
//        this.vendorService = vendorService;
//        this.documentService = documentService;
//    }

    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody @Valid Vendor vendor) {
        Vendor savedVendor = vendorService.createVendor(vendor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendor);
    }

    @PostMapping("upload-document")
    public ResponseEntity<Document> createDocument(@RequestBody @Valid Document document) {
        Document saveddocument = documentService.createDocument(document);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveddocument);
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable UUID id) {
        return vendorService.getVendorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
