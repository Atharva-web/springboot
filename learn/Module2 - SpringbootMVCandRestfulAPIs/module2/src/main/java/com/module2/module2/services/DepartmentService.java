package com.module2.module2.services;

import com.module2.module2.configs.MapperConfig;
import com.module2.module2.dto.DepartmentDTO;
import com.module2.module2.entities.DepartmentEntity;
import com.module2.module2.exceptions.ResourceNotFoundException;
import com.module2.module2.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final MapperConfig mapperConfig;

    public DepartmentService(DepartmentRepository departmentRepository, MapperConfig mapperConfig) {
        this.departmentRepository = departmentRepository;
        this.mapperConfig = mapperConfig;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository
                .findAll()
                .stream()
                .map(this::entityToDTO)
                .toList();
    }

    public DepartmentDTO getDepartmentById(Long id) {
        Optional<DepartmentEntity> optionalOfEntity = departmentRepository.findById(id);
        if(optionalOfEntity.isEmpty()) {
            throw new ResourceNotFoundException("department not found with id: " + id);
        }
        return entityToDTO(optionalOfEntity.get());
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        return entityToDTO(departmentRepository.save(dtoToEntity(departmentDTO)));
    }

    public DepartmentDTO updateDepartment(Long id, Map<String, Object> updatedDepartment) {
        Optional<DepartmentEntity> optionalOfEntity = departmentRepository.findById(id);
        if(optionalOfEntity.isEmpty()) {
            throw new ResourceNotFoundException("department not found with id: " + id);
        }
        DepartmentEntity departmentEntity = optionalOfEntity.get();
        for(Map.Entry<String, Object> entry : updatedDepartment.entrySet()) {
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(DepartmentEntity.class, entry.getKey());
            fieldToBeUpdated.setAccessible(true);
            if(fieldToBeUpdated.getType() == LocalDate.class) {
                ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, LocalDate.parse((CharSequence) entry.getValue()));
                continue;
            }
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, entry.getValue());
        }
        departmentRepository.save(departmentEntity);
        return entityToDTO(departmentEntity);
    } // apparently there is a better way to do this.
/* ------------------------------------------------------------------------------------------------------------------ */
    public DepartmentDTO entityToDTO(DepartmentEntity departmentEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return mapperConfig.getModelMapper().map(departmentEntity, DepartmentDTO.class);
    }

    public DepartmentEntity dtoToEntity(DepartmentDTO departmentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return mapperConfig.getModelMapper().map(departmentDTO, DepartmentEntity.class);
    }

    public Boolean deleteDepartmentById(Long id) {
        if(!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Failed to delete employee with id: " + id);
        }
        departmentRepository.deleteById(id);
        return true;
    }
}
