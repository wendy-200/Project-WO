package com.ups.oop.Service;

import com.ups.oop.DTO.InvoiceDTO;
import com.ups.oop.Entity.Invoice;
import com.ups.oop.Repository.InvoiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    private List<InvoiceDTO> invoiceDTOList = new ArrayList<>();

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public ResponseEntity createInvoice(InvoiceDTO invoiceDTO) {
        boolean wasFound = findInvoice(String.valueOf(invoiceDTO.getId()));
        if (wasFound) {
            String errorMessage = "invoice with id" + invoiceDTO.getId() + "already exists";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            invoiceDTOList.add(invoiceDTO);
            return ResponseEntity.status(HttpStatus.OK).body(invoiceDTO);
        }
    }

    private boolean findInvoice(String id) {
        for (InvoiceDTO invoiceDTO : invoiceDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(invoiceDTO.getId()))) {
                return true;
            }
        }
        return false;
    }

    public ResponseEntity getAllInvoice() {
        Iterable<Invoice> invoiceIterable = invoiceRepository.findAll();
        List<InvoiceDTO> invoices = new ArrayList<>();
        for (Invoice in : invoiceIterable) {
            InvoiceDTO invoice = new InvoiceDTO();
            invoice.setId(invoice.getId());
            invoice.setDate(invoice.getDate());
            invoice.setTotalAmount(invoice.getTotalAmount());
            invoices.add(invoice);

        }
        if (invoices.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoices);
    }

    public ResponseEntity getInvoiceById(String id) {
        Optional<Invoice>invoiceOptional = invoiceRepository.findById(Long.valueOf(id));
        if(invoiceOptional.isPresent()){
            Invoice invoiceFound = invoiceOptional.get();
            InvoiceDTO invoice = new InvoiceDTO();
            invoice.setId(Long.valueOf(invoiceFound.getId()));
            invoice.setDate(invoiceFound.getDate());
            invoice.setTotalAmount(Double.valueOf(invoiceFound.getTotalAmount()));
            invoice.setSubtotal(invoiceFound.getSubtotal());



            return  ResponseEntity.status(HttpStatus.OK).body(invoice);

        }else{

            String errorMessage = "invoice with id" + id + " already exists";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

    }

    private int findIndexById(String id) {
        int index = 0;
        for (InvoiceDTO in : invoiceDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(in.getId()))) {
                return index;
            }
            index++;
        }
        return -1;

    }

    public ResponseEntity updateInvoice(InvoiceDTO invoiceDTO) {
        int upadateIndex = findIndexById(String.valueOf(invoiceDTO.getId()));
        if (upadateIndex != -1) {
            invoiceDTOList.set(upadateIndex, invoiceDTO);
            return ResponseEntity.status(HttpStatus.OK).body(invoiceDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invoice with id " + invoiceDTO.getId() + " doesn't exits ");

    }

    public ResponseEntity deleteInvoiceById(String id) {
        String message = "invoice with id " + id;
        for (InvoiceDTO inv : invoiceDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(inv.getId()))) {
                invoiceDTOList.remove(inv);
                return ResponseEntity.status(HttpStatus.OK).body(message + " removed successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
    }
}