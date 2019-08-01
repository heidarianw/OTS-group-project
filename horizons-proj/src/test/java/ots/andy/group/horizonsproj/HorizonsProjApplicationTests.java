package ots.andy.group.horizonsproj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;
import ots.andy.group.horizonsproj.services.EmployeeService;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HorizonsProjApplicationTests {

	@Autowired
	EmployeeService employeeService;
	Employee e = new Employee("First", "Last", "Email", "password");

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	@Transactional
	public void addAndRemoveEmployee() {
		if (!employeeRepository.findByEmail(e.getEmail()).isEmpty()){
			employeeRepository.deleteByEmail(e.getEmail());
		}
		assertTrue(employeeService.addEmployee(e));
		assertFalse(employeeService.addEmployee(e));
		assertTrue(!employeeRepository.findByEmail(e.getEmail()).isEmpty());
		employeeRepository.deleteByEmail(e.getEmail());
		assertTrue(employeeRepository.findByEmail(e.getEmail()).isEmpty());
	}

	@Test
	@Transactional
	public void loginEmployee() {
		Employee temp = new Employee(e.getFirst(), e.getLast(), e.getEmail(), e.getPassword());
		if (employeeRepository.findByEmail(e.getEmail()).isEmpty()){
			employeeService.addEmployee(e);
		}
		System.out.println(temp);
		assertEquals(employeeService.loginEmployee(temp), 0);
		temp.setPassword("notmypass");
		assertEquals(employeeService.loginEmployee(temp), 1);
		temp.setEmail("notarealemail");
		assertEquals(employeeService.loginEmployee(temp), 2);
		employeeRepository.deleteByEmail(e.getEmail());
		assertTrue(employeeRepository.findByEmail(e.getEmail()).isEmpty());
	}

}
