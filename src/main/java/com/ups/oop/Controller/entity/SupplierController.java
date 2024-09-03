package com.ups.oop.Controller.entity;

import com.ups.oop.Service.SupplierService;
import com.ups.oop.DTO.SupplierDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;

    }
    @GetMapping("/get-all-supplier")
    public ResponseEntity getSupplier(){
        return this.supplierService.getAllSuppliers();

    }
    @GetMapping("/get-supplier")
    public ResponseEntity getSupplieraById(@RequestParam String id){
        return this.supplierService.getSupplierById(id);
    }
    @PostMapping("/supplier")
    public ResponseEntity createSupplier(@RequestBody SupplierDTO supplierDTO){
        return this.supplierService.createSupplier(supplierDTO);

    }

    @PutMapping("/update-supplier")
    public ResponseEntity updateSupplier(@RequestBody SupplierDTO supplierDTO){
        return this.supplierService.updateSupplier(supplierDTO);

    }

    @DeleteMapping("/remove-supplier")
    public ResponseEntity deleSupplier(@RequestParam String id) {
        return this.supplierService.deleteSupplierById(id);
    }

}
