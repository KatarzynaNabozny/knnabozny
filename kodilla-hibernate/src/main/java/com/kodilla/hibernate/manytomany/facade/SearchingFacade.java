package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchingFacade {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    List<Company> companyNameContains(final String nameFragment) throws ResultNotFoundException {
        List<Company> searchResult = companyDao.contains("%" + nameFragment + "%");
        if (searchResult.isEmpty())
            throw new ResultNotFoundException("No company was found");
        return searchResult;
    }

    List<Employee> employeeNameContains(final String nameFragment) throws  ResultNotFoundException {
        List<Employee> searchResult = employeeDao.lastNameContains("%" + nameFragment + "%");
        if (searchResult.isEmpty())
            throw new ResultNotFoundException("No company was found");
        return searchResult;
    }
}