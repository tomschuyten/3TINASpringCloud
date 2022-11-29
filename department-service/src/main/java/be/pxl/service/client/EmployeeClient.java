package be.pxl.service.client;

import be.pxl.service.domain.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/api/employee/department/{id}")
    ResponseEntity<List<Employee>> findByDepartment(@PathVariable Long id);
}
