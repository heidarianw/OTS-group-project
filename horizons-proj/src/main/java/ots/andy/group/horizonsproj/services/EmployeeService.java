package ots.andy.group.horizonsproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    EncryptionService e = new EncryptionService();

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

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
        List<Employee> myList = employeeRepository.findByEmail(employee.getEmail());
        if (myList.isEmpty()) {
            return false;
        }
        String encryptedPass = myList.get(0).getPassword();
        if (e.encryptionService().matches(employee.getPassword(), encryptedPass)) {
            return true;
        }
        return false;
    }

    public boolean updateInfo(Employee employee) {
        List<Employee> myList = employeeRepository.findByEmail(employee.getEmail());
        if (myList.isEmpty()) return false;
        int id = myList.get(0).getId();
        employee.setId(id);
        saveNewInfo(employee);
        return true;
    }
}
