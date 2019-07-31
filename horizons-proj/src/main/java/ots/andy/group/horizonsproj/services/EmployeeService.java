package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    EncryptionService e = new EncryptionService();

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean addEmployee(Employee employee) {
        if (!employeeRepository.findByEmail(employee.getEmail()).isEmpty()) {
            return false;
        }
        String enc = e.encryptionService().encode(employee.getPassword());
        employee.setPassword(enc);
        employeeRepository.save(employee);
        return true;
    }

    public int loginEmployee(Employee employee) {
        if (employeeRepository.findByEmail(employee.getEmail()).isEmpty()) {
            return 2;
        }
        String encryptedPass = employeeRepository.findByEmail(employee.getEmail()).get(0).getPassword();
        if (e.encryptionService().matches(employee.getPassword(), encryptedPass)) {
            return 0;
        }
        return 1;
    }
}
