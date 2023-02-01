package com.anf2.mvc_sample.repository;

import com.anf2.mvc_sample.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
