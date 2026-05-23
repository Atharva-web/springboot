package com.module2.module2.controllers;

import com.module2.module2.dto.EmployeeDTO;
import com.module2.module2.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDTO> optionalEmployeeDTO = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(optionalEmployeeDTO.get());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.createNewEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable Long id, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id, employeeDTO));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(id, updates);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        Boolean employeeDeleted = employeeService.deleteEmployeeById(id);
        if(employeeDeleted) return new ResponseEntity<>("successfully deleted employee with id " + id, HttpStatus.OK);
        return new ResponseEntity<>("error in deleting employee", HttpStatus.CONFLICT);
    }
}