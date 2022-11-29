package be.pxl.service.service;

import be.pxl.service.client.EmployeeClient;
import be.pxl.service.domain.Department;
import be.pxl.service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @Override
    public List<Department> findByOrganization(Long organizationId) {
        // In department-service gebruiken we employee client om employees op te halen
        // voor het departement
        List<Department> departments = departmentRepository.findByOrganizationId(organizationId);
        departments.forEach(d -> d.setEmployeesList(
                employeeClient.findByDepartment(d.getId()).getBody()));
        return departments;
    }
}
