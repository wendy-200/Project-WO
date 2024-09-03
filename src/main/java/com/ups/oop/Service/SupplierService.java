package com.ups.oop.Service;


import com.ups.oop.DTO.SupplierDTO;
import com.ups.oop.Entity.Supplier;
import com.ups.oop.Repository.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class SupplierService {
        private final SupplierRepository supplierRepository;

        private List<SupplierDTO> supplierDTOList = new ArrayList<>();

        public SupplierService(SupplierRepository supplierRepository) {
            this.supplierRepository = supplierRepository;
        }

        public ResponseEntity createSupplier(SupplierDTO supplierDTO) {
            boolean wasFound = findSupplier(String.valueOf(supplierDTO.getId()));
            if (wasFound) {
                String errorMessage = "supplier with id" + supplierDTO.getId() + "already exists";
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
            } else {
                supplierDTOList.add(supplierDTO);
                return ResponseEntity.status(HttpStatus.OK).body(supplierDTO);
            }
        }

        private boolean findSupplier(String id) {
            for (SupplierDTO supplierDTO : supplierDTOList) {
                if (id.equalsIgnoreCase(String.valueOf(supplierDTO.getId()))) {
                    return true;
                }
            }
            return false;
        }

        public ResponseEntity getAllSuppliers() {
            Iterable<Supplier> supplierIterable = supplierRepository.findAll();
            List<SupplierDTO> suppliers = new ArrayList<>();
            for (Supplier Su : supplierIterable) {
                SupplierDTO supplier = new SupplierDTO();
                supplier.setId(supplier.getId());
                supplier.setSupplierAddress(supplier.getSupplierAddress());
                supplier.setPhoneNumber(supplier.getPhoneNumber());
                supplier.setEmail(supplier.getEmail());
                suppliers.add(supplier);

            }
            if (suppliers.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier List not found");
            }
            return ResponseEntity.status(HttpStatus.OK).body(suppliers);
        }

        public ResponseEntity getSupplierById(String id) {
            Optional<Supplier> supplierOptional = supplierRepository.findById(Long.valueOf(id));
            if(supplierOptional.isPresent()){
                Supplier supplierFound = supplierOptional.get();
                SupplierDTO supplier = new SupplierDTO();
                supplier.setId(Long.valueOf(supplierFound.getId()));
                supplier.setSupplierAddress(supplierFound.getSupplierAdrress());
                supplier.setPhoneNumber(supplierFound.getPhoneNumber());
                supplier.setEmail(supplierFound.getEmail());


                return  ResponseEntity.status(HttpStatus.OK).body(supplier);

            }else{

                String errorMessage = "supplier with id" + id + " already exists";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        }

        private int findIndexById(String id) {
            int index = 0;
            for (SupplierDTO Su : supplierDTOList) {
                if (id.equalsIgnoreCase(String.valueOf(Su.getId()))) {
                    return index;
                }
                index++;
            }
            return -1;

        }

        public ResponseEntity updateSupplier(SupplierDTO supplierDTO) {
            int upadateIndex = findIndexById(String.valueOf(supplierDTO.getId()));
            if (upadateIndex != -1) {
                supplierDTOList.set(upadateIndex, supplierDTO);
                return ResponseEntity.status(HttpStatus.OK).body(supplierDTO);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invoice with id " + supplierDTO.getId() + " doesn't exits ");

        }

        public ResponseEntity deleteSupplierById(String id) {
            String message = "invoice with id " + id;
            for (SupplierDTO inv : supplierDTOList) {
                if (id.equalsIgnoreCase(String.valueOf(inv.getId()))) {
                    supplierDTOList.remove(inv);
                    return ResponseEntity.status(HttpStatus.OK).body(message + " removed successfully");
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
        }
    }

