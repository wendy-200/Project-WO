package com.ups.oop.Service;

import com.ups.oop.dto.SupplierDTO;
import com.ups.oop.entity.Supplier;
import com.ups.oop.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTO> getAllSuppliers() {
        Iterable<Supplier> supplierIterable = supplierRepository.findAll();
        List<SupplierDTO> supplierList = new ArrayList<>();

        for (Supplier supplier : supplierIterable) {
            SupplierDTO supplierDTO = new SupplierDTO();
            supplierDTO.setId(supplier.getId());
            supplierDTO.setSupplierAddress(supplier.getSupplierAddress());
            supplierDTO.setPhoneNumber(supplier.getPhoneNumber());
            supplierDTO.setEmail(supplier.getEmail());

            supplierList.add(supplierDTO);
        }

        return supplierList;
    }
}
