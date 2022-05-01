package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SearchingFacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private SearchingFacade searchFacade;

    @Test
    public void testEmployeeSearch() throws ResultNotFoundException {
        //Given
        Employee employee = new Employee("John", "Smith");
        employeeDao.save(employee);

        //When
        List<Employee> result = searchFacade.employeeNameContains("mit");

        //Then
        assertEquals(16, result.size());

        //Cleanup
        employeeDao.delete(employee);
    }

    @Test
    public void testCompanySearch() throws ResultNotFoundException {
        //Given
        Company company = new Company("Grey Matter");
        companyDao.save(company);

        //When
        List<Company> result = searchFacade.companyNameContains("att");

        //Then
        assertEquals(16, result.size());

        //Cleanup
        companyDao.delete(company);
    }
}
