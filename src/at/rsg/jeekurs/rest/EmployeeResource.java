package at.rsg.jeekurs.rest;

import at.rsg.jeekurs.domain.Employee;
import at.rsg.jeekurs.service.EmployeeService;
import at.rsg.jeekurs.service.EmployeeServiceLocal;
import at.rsg.jeekurs.service.EmployeeServiceLocalFactory;
import at.rsg.jeekurs.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

// Effektiv: 
//     http://localhost:8080/  <-- von JBoss Configuration
//       /RESTTest             <-- Web Context Root 
//       /api                  <-- RESTApplication.java
//       /employees            <-- @Path hier in EmployeeResource.java
@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class EmployeeResource {
	
	//@Inject
	@EJB(beanName = "EmployeeServiceLocal")
	private EmployeeService empService;
	
	@GET
	public Response getAll() {
		List<Employee> list = null;
		try {
			list = empService.getAll();
			
			GenericEntity<List<Employee>> genericList =
					new GenericEntity<List<Employee>>(list) {};	
			
			return Response.ok(genericList).build();
			
		} catch (ServiceException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response getEmployeeById(@PathParam("id") int id) {
		Employee employee = null;
		try {
			employee = empService.getById(id);
			
			if (employee != null) {
				return Response.ok(employee).build();
			} else {
				return Response.status(Status.NOT_FOUND).build();
			}
		} catch (ServiceException se) {
			se.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteById(@PathParam("id") int id) {
		try {
			empService.removeById(id);
			return Response.noContent().build();
		} catch (ServiceException se) {
			se.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	public Response create(@Valid Employee e) {
		try {
			Employee createdEmployee = empService.add(e);
			return Response.ok(createdEmployee).build();
		} catch (ServiceException se) {
			se.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Path("/{id}")
	public Response updateEmployee(@PathParam("id") int id, @Valid Employee e) {
		try {
			e.setId(id);
			empService.update(e);
			return Response.ok(e).build();
		} catch (ServiceException se) {
			se.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();	
		}
	}
	
}

