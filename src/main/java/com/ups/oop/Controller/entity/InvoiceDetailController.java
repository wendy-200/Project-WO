package com.ups.oop.Controller.entity;


import com.ups.oop.Service.InvoiceDetailService;
import com.ups.oop.Service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceDetailController {
    private InvoiceDetailService invoiceDetailService;

    public InvoiceDetailController(InvoiceService invoiceService) {
        this.invoiceDetailService = invoiceDetailService;
    }

    @GetMapping("/invoice-detail")
    public String getInvoiceDetail(Model model){
        model.addAttribute("invoicedetail", invoiceDetailService.getInvoiceDetail());
        return "invoice-detail/list";
    }

}