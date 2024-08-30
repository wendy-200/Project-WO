package com.ups.oop.repository;

import com.ups.oop.entity.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
}
