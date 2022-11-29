package be.pxl.service.service;

import be.pxl.service.client.NotificationClient;
import be.pxl.service.model.Employee;
import be.pxl.service.model.NotificationRequest;
import be.pxl.service.model.dto.EmployeeRequest;
import be.pxl.service.model.dto.EmployeeResponse;
import be.pxl.service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final NotificationClient notificationClient;

    @Override
    public List<EmployeeResponse> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employee -> mapToEmployeeResponse(employee))
                .collect(Collectors.toList());
    }

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .age(employeeRequest.getAge())
                .name(employeeRequest.getName())
                .position(employeeRequest.getPosition())
                .build();
        employeeRepository.save(employee);

//        NotificationRequest notificationRequest =
//                NotificationRequest.builder()
//                        .message("Employee Created")
//                        .sender("tom.schuyten@pxl.be")
//                        .build();
//        notificationClient.sendNotification(notificationRequest);
    }

    @Override
    public List<Employee> findByDepartment(Long id) {

        return employeeRepository.findByDepartmentId(id);
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .age(employee.getAge())
                .name(employee.getName())
                .position(employee.getPosition())
                .build();
    }
}
