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

    public void saveNewInfo(Employee employee) {
        String enc = e.encryptionService().encode(employee.getPassword());
        employee.setPassword(enc);
        employeeRepository.save(employee);
    }

    public boolean addEmployee(Employee employee) {
        if (!employeeRepository.findByEmail(employee.getEmail()).isEmpty()) {
            return false;
        }
        saveNewInfo(employee);
        return true;
    }

    public boolean loginEmployee(Employee employee) {
        if (employeeRepository.findByEmail(employee.getEmail()).isEmpty()) {
            return false;
        }
        String encryptedPass = employeeRepository.findByEmail(employee.getEmail()).get(0).getPassword();
        if (e.encryptionService().matches(employee.getPassword(), encryptedPass)) {
            return true;
        }
        return false;
    }

    public boolean updateInfo(Employee employee) {
        if (employeeRepository.findByEmail(employee.getEmail()).isEmpty()) return false;
        int id = employeeRepository.findByEmail(employee.getEmail()).get(0).getId();
        employee.setId(id);
        saveNewInfo(employee);
        return true;
    }
}
