package at.rsg.jeekurs.domain;

import javax.jms.JMSSessionMode;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Employee implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@Min(18)
	private int age;
	
	@NotNull
	@NotBlank
	@Size(max = 20, min = 3)
	private String name;
	
	@Positive
	private int salary;
	
	//@JsonTransient
	@XmlTransient
	private boolean grossverdiener = false;
	
	public Employee() {
		super();
	}
	
	public Employee(int age, String name, int salary) {
		super();
		setAge(age);
		setName(name);
		setSalary(salary);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isGrossverdiener() {
		return grossverdiener;
	}

	public void setGrossverdiener(boolean grossverdiener) {
		this.grossverdiener = grossverdiener;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [age=" + age +
				", name=" + name +
				", salary=" + salary + 	
				", grossverdiener=" + grossverdiener +
				"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	
	
}
