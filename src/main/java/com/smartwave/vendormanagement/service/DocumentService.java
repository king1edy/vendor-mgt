package com.smartwave.vendormanagement.service;

import com.smartwave.vendormanagement.entity.Document;
import com.smartwave.vendormanagement.entity.Vendor;
import com.smartwave.vendormanagement.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Optional<Document> getDocumentById(UUID id) {
        return documentRepository.findById(id);
    }

    public void deleteDocument(UUID id) {
        documentRepository.deleteById(id);
    }
}
