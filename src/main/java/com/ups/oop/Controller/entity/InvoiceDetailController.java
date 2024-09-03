package com.ups.oop.Controller.entity;


import com.ups.oop.Service.InvoiceDetailService;
import com.ups.oop.DTO.InvoiceDetailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceDetailController {
    private final InvoiceDetailService invoiceDetailService;

    public InvoiceDetailController(InvoiceDetailService invoiceDetailService){
       this.invoiceDetailService = invoiceDetailService;
    }

    @GetMapping("/get-all-invoice-details")
     public ResponseEntity getInvoiceDetail(){
    return this.invoiceDetailService.getAllInvoiceDetail();

    }

    @GetMapping("/get-invoice-detail")
     public ResponseEntity getInvoiceDetailById(@RequestParam String id){
    return this.invoiceDetailService.getInvoiceDetailById(id);

   }
    @PostMapping("/invoice-detail")
     public ResponseEntity createInvoiceDetail(@RequestBody InvoiceDetailDTO InvoiceDetailDTO){;
        return this.invoiceDetailService.createInvoiceDetail(InvoiceDetailDTO);
 }

   @PutMapping("/update-invoice-detail")
   public ResponseEntity updateInvoiceDetail(@RequestBody InvoiceDetailDTO invoiceDetailDTO){
     return this.invoiceDetailService.updateInvoiceDetail(invoiceDetailDTO);
    }

    @DeleteMapping("/remove-invoice-detail")
   public ResponseEntity deleteInvoiceDetail(@RequestParam String id){
    return this.invoiceDetailService.deleteInvoiceDetailById(id);
    }
}

