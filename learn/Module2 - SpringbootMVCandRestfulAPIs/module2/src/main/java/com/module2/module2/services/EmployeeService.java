package com.module2.module2.services;

import com.module2.module2.dto.EmployeeDTO;
import com.module2.module2.entities.EmployeeEntity;
import com.module2.module2.exceptions.ResourceNotFoundException;
import com.module2.module2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public void searchEmployeeById(Long id) {
        if(!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("employee not found with id " + id);
        }
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        searchEmployeeById(id);
        return employeeRepository.findById(id).map(employeeEntity -> entityToDTO(employeeEntity));
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(dtoToEntity(employeeDTO));
        return entityToDTO(savedEmployeeEntity);
    }

    public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        searchEmployeeById(id);
        EmployeeEntity employeeEntity = dtoToEntity(employeeDTO);
        employeeEntity.setId(id);
        return entityToDTO(employeeRepository.save(employeeEntity));
    }

    public EmployeeDTO updatePartialEmployeeById(Long id, Map<String, Object> updates) {
        searchEmployeeById(id);
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        updates.forEach((key, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(EmployeeEntity.class, key);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        employeeRepository.save(employeeEntity);
        return entityToDTO(employeeEntity);
    }

    public Boolean deleteEmployeeById(Long id) {
        searchEmployeeById(id);
        employeeRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private EmployeeDTO entityToDTO(EmployeeEntity employeeEntity) {
//        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getEmail(),
//                employeeEntity.getAge(), employeeEntity.getDateOfJoining(),
//                employeeEntity.getIsActive(), employeeEntity.getRole(),
//                employeeEntity.getSalary());
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    private EmployeeEntity dtoToEntity(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, EmployeeEntity.class);
    }
}
