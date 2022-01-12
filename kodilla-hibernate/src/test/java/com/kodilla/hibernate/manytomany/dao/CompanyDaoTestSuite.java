package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        //try {
        //    companyDao.deleteById(softwareMachineId);
        //    companyDao.deleteById(dataMaestersId);
        //    companyDao.deleteById(greyMatterId);
        //} catch (Exception e) {
        //    //do nothing
        //}
    }

    @Test
    void testSearchByLastname() {
        //Given
        Employee employee1 = new Employee("Linda", "Kovalsky");
        Employee employee2 = new Employee("John", "Mostowski");
        Employee employee3 = new Employee("Klara", "Blaze");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);


        int id1 = employee1.getId();
        int id2 = employee2.getId();
        int id3 = employee3.getId();

        //When
        List<Employee> employeeList = employeeDao.retrieveLastnameEmployee("Kovalsky");

        //Than
        try {
            assertEquals("Kovalsky", employeeList.get(0).getLastname());
        } finally {
            //CleanUp
            employeeDao.deleteById(id1);
            employeeDao.deleteById(id2);
            employeeDao.deleteById(id3);
        }
    }

    @Test
    void testSearchByThreeCharackters() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        int id1 = softwareMachine.getId();
        int id2 = dataMaesters.getId();
        int id3 = greyMatter.getId();

        //When
        List<Company> resultCompanies = companyDao.retrieveCompanyName("Sof");

        //Than
        try {
            assertEquals("Software Machine", resultCompanies.get(0).getName());
        } finally {
            //CleanUp
            companyDao.deleteById(id1);
            companyDao.deleteById(id2);
            companyDao.deleteById(id3);
        }

    }
}

