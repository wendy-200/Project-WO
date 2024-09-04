package com.ups.oop.Service;

import com.ups.oop.DTO.InvoiceDTO;
import com.ups.oop.Entity.Invoice;
import com.ups.oop.Repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService{
    private  final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceDTO> getInvoice(){
        Iterable<Invoice> invoiceIterable = invoiceRepository.findAll();
        List<InvoiceDTO>invoiceDTOList = new ArrayList<>();

        for (Invoice id : invoiceIterable) {
            InvoiceDTO invoiceDTO = new InvoiceDTO(
                    id.getId(),
                    id.getName(),
                    id.getDate(),
                    id.getTotalAmount(),
                    id.getSubtotal());
            invoiceDTOList.add(invoiceDTO);
        }
        return invoiceDTOList;
    }

}

