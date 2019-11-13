package at.rsg.jeekurs.service;

import java.util.List;

import javax.ejb.Stateless;

import at.rsg.jeekurs.domain.Employee;

@Stateless
public class EmployeeServiceJPA implements EmployeeService {

	@Override
	public List<Employee> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee add(Employee e) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(int id) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Employee e) throws ServiceException {
		// TODO Auto-generated method stub

	}

}
