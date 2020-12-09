package com.adp3.service.bridge.impl;

import com.adp3.entity.bridge.EmployeeRole;
import com.adp3.repository.bridge.EmployeeRoleRepository;
import com.adp3.service.bridge.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author: Sonwabo Kasi
 * Class: Part Time
 * Student number: 214293939
 * Class Description:
 */
@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {

   // private static EmployeeRoleService employeeRoleService = null;
    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Override
    public EmployeeRole create(EmployeeRole employeeRole) {
        return this.employeeRoleRepository.save(employeeRole);

    }

    @Override
    public EmployeeRole read(String s) {
       return this.employeeRoleRepository.findById(s).orElseGet(null);

    }

    @Override
    public EmployeeRole update(EmployeeRole employeeRole) {
        this.employeeRoleRepository.save(employeeRole);
        return employeeRole;
    }

    @Override
    public void delete(String empId) {
        if(employeeRoleRepository.existsById(empId)){
            employeeRoleRepository.deleteById(empId);
        }

    }

    @Override
    public Set<EmployeeRole> getAll() {
        return this.employeeRoleRepository.findAll().stream().collect(Collectors.toSet());
        //return null;
    }

    @Override
    public Set<EmployeeRole> getAllEmployeeRolesStartWith() {
        Set<EmployeeRole> employeeRoles= getAll();
        Set<EmployeeRole> employeeRoleStartWithA = new HashSet<>();
        for (EmployeeRole employeeRole :employeeRoles) {
            if (employeeRole.getRoleID().trim().toLowerCase().startsWith("a")) {
                employeeRoleStartWithA.add(employeeRole);
            }

        }
        return employeeRoleStartWithA;
    }
}
