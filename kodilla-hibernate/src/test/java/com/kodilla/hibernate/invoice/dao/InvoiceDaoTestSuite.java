package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("phone");
        Product product2 = new Product("pencil");
        Product product3 = new Product("rubber");

        Item item1 = new Item(product1, new BigDecimal(12.30), 1, new BigDecimal(9.9));
        Item item2 = new Item(product2, new BigDecimal(11.30), 1, new BigDecimal(8.9));
        Item item3 = new Item(product3, new BigDecimal(10.30), 1, new BigDecimal(7.9));

        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        Invoice invoice1 = new Invoice("one", new ArrayList<>());
        Invoice invoice2 = new Invoice("two", new ArrayList<>());
        Invoice invoice3 = new Invoice("three", new ArrayList<>());

        invoice1.getItems().add(item1);
        invoice2.getItems().add(item2);
        invoice3.getItems().add(item3);

        //When
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);

        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        invoiceDao.save(invoice3);
        //then
        int id1 = product1.getId();
        int id2 = product2.getId();
        int id3 = product3.getId();

        int ide1 = invoice1.getId();
        int ide2 = invoice2.getId();
        int ide3 = invoice3.getId();

        Assertions.assertEquals("phone", productDao.findProductByName("phone").get(0).getName());
        Assertions.assertEquals("one", invoiceDao.findInvoiceByNumber("one").get(0).getNumber());
        //Clean
        productDao.deleteById(id1);
        productDao.deleteById(id2);
        productDao.deleteById(id3);

        invoiceDao.deleteById(ide1);
        invoiceDao.deleteById(ide2);
        invoiceDao.deleteById(ide3);

    }
}