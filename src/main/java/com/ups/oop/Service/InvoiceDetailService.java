package com.ups.oop.Service;

import com.ups.oop.dto.InvoiceDetailDTO;
import com.ups.oop.entity.InvoiceDetail;
import com.ups.oop.repository.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceDetailService {
    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    public List<InvoiceDetailDTO> getAllInvoiceDetails(){
        Iterable<InvoiceDetail> invoiceDetailIterable = invoiceDetailRepository.findAll();
        List<InvoiceDetailDTO> invoiceDetailList = new ArrayList<>();

        for(InvoiceDetail invoiceDetail: invoiceDetailIterable){
            InvoiceDetailDTO invoiceDetailDTO = new InvoiceDetailDTO();
            invoiceDetailDTO.setId(invoiceDetail.getId());
            invoiceDetailDTO.setInvoice(invoiceDetail.getInvoice());
            invoiceDetailDTO.setProductId(invoiceDetail.getProductId());
            invoiceDetailDTO.setQuantity(invoiceDetail.getQuantity());
            invoiceDetailDTO.setUnitPrice(invoiceDetail.getUnitPrice());
            invoiceDetailDTO.setSubTotal(invoiceDetailDTO.getSubTotal());
            invoiceDetailList.add(invoiceDetailDTO);
        }
        return invoiceDetailList;
    }
}