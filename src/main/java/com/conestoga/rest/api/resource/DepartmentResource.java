package com.conestoga.rest.api.resource;

import com.conestoga.rest.api.persistence.Department;
import com.conestoga.rest.api.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentResource {
    private DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(value = "/departments")
    public List<Department> getAll(){
        return this.departmentService.getAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getById(@PathVariable Long id){
        return this.departmentService.getById(id);
    }

    @PostMapping(value = "/departments")
    public Department add(@RequestBody Department department){
        return this.departmentService.add(department);
    }

    @PutMapping(value = "/departments/{id}")
    public boolean update(@PathVariable Long id, @RequestBody Department department) throws Exception{
        return this.departmentService.update(id,department);
    }

    @DeleteMapping(value = "/departments/{id}")
    public void delete(@PathVariable Long id){
        this.departmentService.delete(id);
    }
}
