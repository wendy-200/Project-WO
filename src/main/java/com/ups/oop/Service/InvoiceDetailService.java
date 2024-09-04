package com.ups.oop.Service;

import com.ups.oop.DTO.InvoiceDetailDTO;
import com.ups.oop.Entity.InvoiceDetail;
import com.ups.oop.Repository.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceDetailService {
    private  final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService (InvoiceDetailRepository invoiceDetailRepository){
        this.invoiceDetailRepository = invoiceDetailRepository;

    }

    public List<InvoiceDetailDTO>getInvoiceDetail(){
        Iterable<InvoiceDetail>invoiceDetailIterable = invoiceDetailRepository.findAll();
        List<InvoiceDetailDTO>invoiceDetailDTOList = new ArrayList<>();

        for (InvoiceDetail ID: invoiceDetailIterable){
            InvoiceDetailDTO invoiceDetailDTO = new InvoiceDetailDTO
                    (ID.getId(), ID.getInvoice(),ID.getProductId(),ID.getQuantity(),ID.getPrice());
            invoiceDetailDTOList.add(invoiceDetailDTO);
        }
        return invoiceDetailDTOList;
    }
}