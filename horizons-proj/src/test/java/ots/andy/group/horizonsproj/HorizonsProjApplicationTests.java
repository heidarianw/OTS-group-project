package ots.andy.group.horizonsproj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ots.andy.group.horizonsproj.entities.Child;
import ots.andy.group.horizonsproj.entities.Employee;
import ots.andy.group.horizonsproj.entities.Parent;
import ots.andy.group.horizonsproj.repositories.ChildRepository;
import ots.andy.group.horizonsproj.repositories.EmployeeRepository;
import ots.andy.group.horizonsproj.repositories.ParentRepository;
import ots.andy.group.horizonsproj.services.ChildService;
import ots.andy.group.horizonsproj.services.EmployeeService;
import ots.andy.group.horizonsproj.services.ParentService;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HorizonsProjApplicationTests {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	ParentService parentService;
	@Autowired
	ChildService childService;

	Employee e = new Employee("First", "Last", "Email", "password");
	Parent p = new Parent("Parent", "PLast", "Email", "password", "1234");
	Child c = new Child("ChildTester", "CLast", 5, false, false, false, false, false, false, false, "URL");

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ParentRepository parentRepository;
	@Autowired
	private ChildRepository childRepository;

	@Test
	@Transactional
	public void addAndRemoveEmployee() {
		if (!employeeRepository.findByEmail(e.getEmail()).isEmpty()){
			employeeRepository.deleteByEmail(e.getEmail());
		}
		// Ensure only one copy of an employee is added
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
		// Ensure employee can log in, and incorrect passwords and emails do not work
		assertEquals(employeeService.loginEmployee(temp), 0);
		temp.setPassword("notmypass");
		assertEquals(employeeService.loginEmployee(temp), 1);
		temp.setEmail("notarealemail");
		assertEquals(employeeService.loginEmployee(temp), 2);
		employeeRepository.deleteByEmail(e.getEmail());
		assertTrue(employeeRepository.findByEmail(e.getEmail()).isEmpty());
	}

	@Test
	@Transactional
	public void updateEmployeeAndLogin() {
		Employee temp = new Employee("SampleTestName", e.getLast(), e.getEmail(), "password");
		Employee temp2 = new Employee("f", "l", "e", "p");
		// Ensure non existent account cannot log in
		assertTrue(employeeService.updateInfo(temp2) == false);
		if (employeeRepository.findByEmail(e.getEmail()).isEmpty()){
			employeeService.addEmployee(e);
		}
		employeeService.updateInfo(temp);
		// Ensure updated account exists and can log in
		assertTrue(!employeeRepository.findByFirst("SampleTestName").isEmpty());
		temp.setPassword("password");
		assertEquals(employeeService.loginEmployee(temp), 0);
		temp.setPassword("notmypass");
		assertEquals(employeeService.loginEmployee(temp), 1);
		temp.setEmail("notarealemail");
		assertEquals(employeeService.loginEmployee(temp), 2);
		employeeRepository.deleteByEmail(e.getEmail());
		assertTrue(employeeRepository.findByEmail(e.getEmail()).isEmpty());
	}

	@Test
	@Transactional
	public void addAndRemoveParent() {
		if (!parentRepository.findByEmail(p.getEmail()).isEmpty()){
			parentRepository.deleteByEmail(p.getEmail());
		}
		// Ensure parent can only be added once
		assertTrue(parentService.addParent(p));
		assertFalse(parentService.addParent(p));
		assertTrue(!parentRepository.findByEmail(p.getEmail()).isEmpty());
		parentRepository.deleteByEmail(p.getEmail());
		assertTrue(parentRepository.findByEmail(p.getEmail()).isEmpty());
	}

	@Test
	@Transactional
	public void loginParent() {
		Parent temp = new Parent(p.getFirst(), p.getLast(), p.getEmail(), p.getPassword(), p.getPhone());
		if (parentRepository.findByEmail(p.getEmail()).isEmpty()){
			parentService.addParent(p);
		}
		// Ensure log in works
		assertEquals(parentService.loginParent(temp), 0);
		temp.setPassword("notmypass");
		// Ensure incorrect pass does not work
		assertEquals(parentService.loginParent(temp), 1);
		temp.setEmail("notarealemail");
		// Ensure incorrect email does not work
		assertEquals(parentService.loginParent(temp), 2);
		parentRepository.deleteByEmail(p.getEmail());
		assertTrue(parentRepository.findByEmail(p.getEmail()).isEmpty());
	}

	@Test
	@Transactional
	public void updateParentAndLogin() {
		Parent temp = new Parent("SampleTestName1", p.getLast(), p.getEmail(), p.getPassword(), p.getPhone());
		Parent temp2 = new Parent("f", "l", "e", "p", "1");
		// Ensure that non existent accounts cannot be updated
		assertTrue(parentService.updateInfo(temp2) == false);
		if (parentRepository.findByEmail(p.getEmail()).isEmpty()){
			parentService.addParent(p);
		}
		parentService.updateInfo(temp);
		// Ensure update works
		assertTrue(!parentRepository.findByFirst("SampleTestName1").isEmpty());
		// Ensure updated account can log in
		temp.setPassword("password");
		assertEquals(parentService.loginParent(temp), 0);
		temp.setPassword("notmypass");
		assertEquals(parentService.loginParent(temp), 1);
		temp.setEmail("notarealemail");
		assertEquals(parentService.loginParent(temp), 2);
		parentRepository.deleteByEmail(p.getEmail());
		assertTrue(parentRepository.findByEmail(p.getEmail()).isEmpty());
	}

	@Test
	@Transactional
	public void addChild() {
		if (childRepository.findByFirst(c.getFirst()).isEmpty()) {
			childService.addChild(c);
		}
		//Ensure children can be added
		assertTrue(!childRepository.findByFirst(c.getFirst()).isEmpty());
		// Ensure that negative age does not go through
		Child temp = new Child("TempTester", "last", -15);
		childService.addChild(temp);
		assertTrue(childRepository.findByFirst("TempTester").isEmpty());
		childRepository.deleteByFirst(c.getFirst());
		assertTrue(childRepository.findByFirst(c.getFirst()).isEmpty());
	}

	@Test
	@Transactional
	public void updateChildInfo() {
		if (childRepository.findByFirst(c.getFirst()).isEmpty()) {
			childService.addChild(c);
		}
		int id = childRepository.findByFirst(c.getFirst()).get(0).getId();
		// Ensure children exists
		assertTrue(!childRepository.findByFirst(c.getFirst()).isEmpty());
		Child toUpdate = new Child (id, "NewNameTest", "last", 2);
		childService.updateInfo(toUpdate);
		// Ensure update works
		assertTrue(childRepository.findByFirst("ChildTester").isEmpty());
		assertTrue(childRepository.findById(id).get(0).getFirst().equals("NewNameTest"));
		assertTrue(childRepository.findById(id).get(0).getAge() == 2);
		childRepository.deleteByFirst(toUpdate.getFirst());
		assertTrue(childRepository.findByFirst(toUpdate.getFirst()).isEmpty());
	}

}
