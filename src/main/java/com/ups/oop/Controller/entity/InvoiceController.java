package com.ups.oop.Controller.entity;


import com.ups.oop.Service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoice")
    public String getInvoice(Model model){
        model.addAttribute("invoice", invoiceService.getInvoice());
        return "invoice/list";
    }

}