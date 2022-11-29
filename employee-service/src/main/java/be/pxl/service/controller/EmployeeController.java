package be.pxl.service.controller;

import be.pxl.service.model.Employee;
import be.pxl.service.model.dto.EmployeeRequest;
import be.pxl.service.model.dto.EmployeeResponse;
import be.pxl.service.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.createEmployee(employeeRequest);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<Employee>> findByDepartment(@PathVariable Long id) {

        return new ResponseEntity(employeeService.findByDepartment(id), HttpStatus.OK);
    }
}
