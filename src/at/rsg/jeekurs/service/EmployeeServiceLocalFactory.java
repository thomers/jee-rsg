package at.rsg.jeekurs.service;

public class EmployeeServiceLocalFactory {
	
	private static EmployeeServiceLocal instance = null;
	
	private EmployeeServiceLocalFactory() {
		super();
	}
	
	public static EmployeeServiceLocal getInstance() {
		if (instance == null) {
			instance = new EmployeeServiceLocal();
		}
		return instance;
	}
}
