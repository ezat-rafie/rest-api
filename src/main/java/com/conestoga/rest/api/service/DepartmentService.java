package com.conestoga.rest.api.service;

import com.conestoga.rest.api.persistence.Department;
import com.conestoga.rest.api.persistence.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAll(){
        return this.departmentRepository.findAll();
    }

    public Department add(Department department){
        return this.departmentRepository.save(department);
    }

    public Department getById(Long id){
        return this.departmentRepository.findById(id).get();
    }

    public boolean update(Long id, Department department){
        Optional<Department> department1 = this.departmentRepository.findById(id);
        if (department1.isPresent()){
            department1.get().setName(department.getName());
            this.departmentRepository.save(department1.get());
            return true;
        }
        else {
            return false;
        }
    }

    public void delete(Long id){
        this.departmentRepository.deleteById(id);
    }
}
