package be.pxl.service.service;

import be.pxl.service.domain.Department;

import java.util.List;

public interface IDepartmentService {

    List<Department> findByOrganization(Long organizationId);
}
