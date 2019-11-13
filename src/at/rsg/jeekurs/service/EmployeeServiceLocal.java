package at.rsg.jeekurs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import at.rsg.jeekurs.domain.Employee;

@Stateless
public class EmployeeServiceLocal implements EmployeeService {
	private static int nextId = 0;
	
	private Map<Integer, Employee> employeeMap = new HashMap<>();
	
	public EmployeeServiceLocal() {
		System.out.println("EmployeeServiceLocal constructor");
	}
	
	@Override
	public List<Employee> getAll() throws ServiceException {
		return new ArrayList<Employee>(employeeMap.values());
	}

	@Override
	public Employee getById(int id) throws ServiceException {
		return employeeMap.get(id);
	}

	@Override
	public Employee add(Employee e) throws ServiceException {
		// Check: Ist e.getId() == null? -> neue Id setzen
		if (e.getId() == null) {
			e.setId(++nextId);
		}
		
		employeeMap.put(e.getId(), e);
		return e;
	}

	@Override
	public void removeById(int id) throws ServiceException {
		employeeMap.remove(id);
	}

	@Override
	public void update(Employee e) throws ServiceException {
		employeeMap.put(e.getId(), e);
	}
}


