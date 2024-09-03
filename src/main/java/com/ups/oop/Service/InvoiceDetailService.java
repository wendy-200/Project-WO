package com.ups.oop.Service;

import com.ups.oop.DTO.InvoiceDetailDTO;
import com.ups.oop.Entity.InvoiceDetail;
import com.ups.oop.Repository.InvoiceDetailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {
    private final InvoiceDetailRepository invoiceDetailRepository;

    private List<InvoiceDetailDTO> invoiceDetailDTOList = new ArrayList<>();

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    public ResponseEntity createInvoiceDetail(InvoiceDetailDTO invoiceDetailDTO) {
        boolean wasFound = findInvoiceDetail(String.valueOf(invoiceDetailDTO.getId()));
        if (wasFound) {
            String errorMessage = "invoiceDetail with id" + invoiceDetailDTO.getId() + "already exists";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            invoiceDetailDTOList.add(invoiceDetailDTO);
            return ResponseEntity.status(HttpStatus.OK).body(invoiceDetailDTO);
        }
    }

    private boolean findInvoiceDetail(String id) {
        for (InvoiceDetailDTO invoiceDetailDTO : invoiceDetailDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(invoiceDetailDTO.getId()))) {
                return true;
            }
        }
        return false;
    }

    public ResponseEntity getAllInvoiceDetail() {
        Iterable<InvoiceDetail> invoiceDetailIterable = invoiceDetailRepository.findAll();
        List<InvoiceDetailDTO> invoiceDetails = new ArrayList<>();
        for (InvoiceDetail inD : invoiceDetailIterable) {
            InvoiceDetailDTO invoiceDetail = new InvoiceDetailDTO();
            invoiceDetail.setId(invoiceDetail.getId());
            invoiceDetail.setInvoice(invoiceDetail.getInvoice());
            invoiceDetail.setProductId(invoiceDetail.getProductId());
            invoiceDetail.setQuantity(invoiceDetail.getQuantity());
            invoiceDetail.setUnitPrice(invoiceDetail.getUnitPrice());
            invoiceDetail.setSubTotal(invoiceDetail.getSubTotal());
            invoiceDetails.add(invoiceDetail);

        }
        if (invoiceDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("InvoiceDetail List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoiceDetails);
    }

    public ResponseEntity getInvoiceDetailById(String id) {
        Optional<InvoiceDetail> invoiceDetailOptional = invoiceDetailRepository.findById(Long.valueOf(id));
        if (invoiceDetailOptional.isPresent()) {
            InvoiceDetail invoiceDetailFound = invoiceDetailOptional.get();
            InvoiceDetailDTO invoiceDetail = new InvoiceDetailDTO();
            invoiceDetail.setId(invoiceDetailFound.getId());
            invoiceDetail.setInvoice(String.valueOf(invoiceDetailFound.getInvoice()));
            invoiceDetail.setProductId(String.valueOf(invoiceDetailFound.getProductId()));
            invoiceDetail.setQuantity(String.valueOf(invoiceDetailFound.getQuantity()));
            invoiceDetail.setUnitPrice(invoiceDetail.getUnitPrice());

            return ResponseEntity.status(HttpStatus.OK).body(invoiceDetail);

        } else {

            String errorMessage = "invoiceDetail with id" + id + " already exists";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

    }


    private int findIndexById(String id) {
        int index = 0;
        for (InvoiceDetailDTO in : invoiceDetailDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(in.getId()))) {
                return index;
            }
            index++;
        }
        return -1;

    }

    public ResponseEntity updateInvoiceDetail(InvoiceDetailDTO invoiceDetailDTO) {
        int upadateIndex = findIndexById(String.valueOf(invoiceDetailDTO.getId()));
        if (upadateIndex != -1) {
            invoiceDetailDTOList.set(upadateIndex, invoiceDetailDTO);
            return ResponseEntity.status(HttpStatus.OK).body(invoiceDetailDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invoice with id " + invoiceDetailDTO.getId() + " doesn't exits ");

    }

    public ResponseEntity deleteInvoiceDetailById(String id) {
        String message = "invoiceDetail with id " + id;
        for (InvoiceDetailDTO inv : invoiceDetailDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(inv.getId()))) {
                invoiceDetailDTOList.remove(inv);
                return ResponseEntity.status(HttpStatus.OK).body(message + " removed successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
    }

}