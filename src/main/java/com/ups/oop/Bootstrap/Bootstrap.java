package com.ups.oop.Bootstrap;


import com.ups.oop.Entity.*;
import com.ups.oop.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailRepository invoiceDetailRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;


    public Bootstrap(CustomerRepository customerRepository, InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository,
                     ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.customerRepository = customerRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        //customer
        Customer cu1 = new Customer();
        cu1.setId("000123");
        cu1.setCustomername("Daniel");
        cu1.setCustomerlastName("Sánchez");
        cu1.setAddress("florida");
        cu1.setPhoneNumber("0958478512");
        cu1.setEmail("DanielSánchez01@gmail.com");


        Customer cu2 = new Customer();
        cu2.setId("000456");
        cu2.setCustomername("Mateo");
        cu2.setCustomerlastName("Rodríguez");
        cu2.setAddress("Sergio");
        cu2.setPhoneNumber("0923654859");
        cu2.setEmail("MateoRodríguez02@gmail.com");

        Customer cu3 = new Customer();
        cu3.setId("000789");
        cu3.setCustomername("Javier");
        cu3.setCustomerlastName("Rojas");
        cu3.setAddress("Alborada");
        cu3.setPhoneNumber("0978945885");
        cu3.setEmail("JavierRojas03@gmail.com");

        Customer cu4 = new Customer();
        cu4.setId("000112");
        cu4.setCustomername("Camila");
        cu4.setCustomerlastName("Vera");
        cu4.setAddress("Guasmo");
        cu4.setPhoneNumber("0958475962");
        cu4.setEmail("CamilaVera04@gmail.com");

        customerRepository.save(cu1);
        customerRepository.save(cu2);
        customerRepository.save(cu3);
        customerRepository.save(cu4);


        //Product
        Product p1 = new Product();
        p1.setId("000654");
        p1.setName("Pan");
        p1.setProvider("Locales");
        p1.setDescription("Pan artesanales");
        p1.setPrice("1");

        Product p2 = new Product();
        p2.setId("000654");
        p2.setName("Pan");
        p2.setProvider("Locales");
        p2.setDescription("Pan artesanales");
        p2.setPrice("1");


        Product p3 = new Product();
        p3.setId("000654");
        p3.setName("Miel");
        p3.setProvider("Locales");
        p3.setDescription("Mil organica");
        p3.setPrice("2.50");


        Product p4 = new Product();
        p4.setId("000654");
        p4.setName("Queso");
        p4.setProvider("Locales");
        p4.setDescription("Queso de Cabra");
        p4.setPrice("2");


        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);

        // invoice

        Invoice in1 = new Invoice();
        in1.setId("000895");
        in1.setDate("01-09-2024");
        in1.setTotalAmount("60");
        in1.setSubtotal("43");
        in1.setCustomer(cu1);

        cu1.getInvoice().add(in1);
        invoiceRepository.save(in1);

        Invoice in2 = new Invoice();
        in2.setId("000745");
        in2.setDate("02-10-2024");
        in2.setTotalAmount("80");
        in2.setSubtotal("69");
        in2.setCustomer(cu1);

        cu2.getInvoice().add(in2);
        invoiceRepository.save(in2);

        Invoice in3 = new Invoice();
        in3.setId("000256");
        in3.setDate("03-11-2024");
        in3.setTotalAmount("120");
        in3.setSubtotal("90");
        in3.setCustomer(cu1);

        cu3.getInvoice().add(in3);
        invoiceRepository.save(in3);


        Invoice in4 = new Invoice();
        in4.setId("000695");
        in4.setDate("04-12-2024");
        in4.setTotalAmount("64");
        in4.setSubtotal("20");
        in4.setCustomer(cu1);

        cu4.getInvoice().add(in4);
        invoiceRepository.save(in4);

        invoiceRepository.save(in1);
        invoiceRepository.save(in2);
        invoiceRepository.save(in3);
        invoiceRepository.save(in4);

        //InvoiceDetail
        InvoiceDetail id1 = new InvoiceDetail();
        id1.setInvoice(in1);
        id1.setProductId(p1);
        id1.setQuantity(1);
        id1.setPrice(33.12);


        InvoiceDetail id2 = new InvoiceDetail();
        id2.setInvoice(in2);
        id2.setProductId(p2);
        id2.setQuantity(2);
        id2.setPrice(22.45);


        InvoiceDetail id3 = new InvoiceDetail();
        id3.setInvoice(in3);
        id3.setProductId(p3);
        id3.setQuantity(4);
        id3.setPrice(44.23);


        InvoiceDetail id4 = new InvoiceDetail();
        id4.setInvoice(in4);
        id4.setProductId(p4);
        id4.setQuantity(1);
        id4.setPrice(66.1);


        invoiceDetailRepository.save(id1);
        invoiceDetailRepository.save(id2);
        invoiceDetailRepository.save(id3);
        invoiceDetailRepository.save(id4);


        // Supplier
        Supplier s1 = new Supplier();
        s1.setId("000452");
        s1.setSupplierName("Alisson");
        s1.setSupplierAdrress("Machala");
        s1.setPhoneNumber("0957895486");
        s1.setEmail("Alisson@gmail.com");

        Supplier s2 = new Supplier();
        s2.setId("000784");
        s2.setSupplierName("Sofia");
        s2.setSupplierAdrress("Pascuales");
        s2.setPhoneNumber("09485475472");
        s2.setEmail("Alisson@gmail.com");

        Supplier s3 = new Supplier();
        s3.setId("000452");
        s3.setSupplierName("Regina");
        s3.setSupplierAdrress("Fertisa");
        s3.setPhoneNumber("0948571256");
        s3.setEmail("Alisson@gmail.com");

        Supplier s4 = new Supplier();
        s4.setId("000452");
        s4.setSupplierName("Valeria");
        s4.setSupplierAdrress("Posorja");
        s4.setPhoneNumber("0968597458");
        s4.setEmail("Alisson@gmail.com");


        Supplier s5 = new Supplier();
        s5.setId("000452");
        s5.setSupplierName("ximena");
        s5.setSupplierAdrress("Trinitaria");
        s5.setPhoneNumber("0978451236");
        s5.setEmail("Alisson@gmail.com");


            supplierRepository.save(s1);
            supplierRepository.save(s2);
            supplierRepository.save(s3);
            supplierRepository.save(s4);
            supplierRepository.save(s5);

            System.out.println("--------Started BootstrapData-------- ");
            System.out.println("Number of Customer: " + customerRepository.count());
            System.out.println("Number of Invoice: " + invoiceRepository.count());
            System.out.println("Number of InvoiceDetail: " + invoiceDetailRepository.count());
            System.out.println("Number of Product: " + productRepository.count());
            System.out.println("Number of supplier: " + supplierRepository.count());

        }

    }
