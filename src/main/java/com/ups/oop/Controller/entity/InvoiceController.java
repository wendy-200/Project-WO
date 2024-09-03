package com.ups.oop.Controller.entity;

import com.ups.oop.Service.InvoiceService;
import com.ups.oop.DTO.InvoiceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;

    }

    @GetMapping("/get-all-invoices")
    public ResponseEntity getInvoice() {
        return this.invoiceService.getAllInvoice();

    }

    @GetMapping("/get-invoice")
    public ResponseEntity getInvoiceById(@RequestParam String id) {
        return this.invoiceService.getInvoiceById(id);
    }

    @PostMapping("/invoice")
    public ResponseEntity creteInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return this.invoiceService.createInvoice(invoiceDTO);
    }

    @PutMapping("/update-incoice")
    public ResponseEntity updateInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return this.invoiceService.updateInvoice(invoiceDTO);

    }

    @DeleteMapping("/remove-invoice")
    public ResponseEntity deleteInvoice(@RequestParam String id) {
        return this.invoiceService.deleteInvoiceById(id);
    }
}