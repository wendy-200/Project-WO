package com.ups.oop.Service;

import com.ups.oop.dto.InvoiceDTO;
import com.ups.oop.entity.Invoice;
import com.ups.oop.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceDTO> getAllInvoices() {
        Iterable<Invoice> invoiceIterable = invoiceRepository.findAll();
        List<InvoiceDTO> invoiceList = new ArrayList<>();

        for (Invoice invoice : invoiceIterable) {
            InvoiceDTO invoiceDTO = new InvoiceDTO();
            invoiceDTO.setId(invoice.getId());
            invoiceDTO.setCustomerName(invoice.getCustomername());
            invoiceDTO.setDate(invoice.getDate());
            invoiceDTO.setTotalAmount(invoice.getTotal());

            invoiceList.add(invoiceDTO);
        }

        return invoiceList;
    }
}