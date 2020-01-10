package com.psl.crud.Controller;

import com.psl.crud.Exception.ResourceNotFound;
import com.psl.crud.Model.Employee;
import com.psl.crud.SecurityApplication;
import com.psl.crud.Service.EmployeeDao;
import com.psl.crud.Service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {

  @Autowired EmployeeService service;
  @Autowired EmployeeDao dao;



  Logger log= LoggerFactory.getLogger(EmployeeController.class);
  @GetMapping("/employees")
  public Optional<List<Employee>> employees() {

    log.info("Fetching all emplyoees");
    return dao.findByall();
  }

  @RequestMapping(path = "/employees", method = RequestMethod.POST)
  public String insertEmp(@RequestBody Employee e) {
    log.info("Inserting an emplyoee");
    service.insert(e);
    return "record inserted";
  }

  @RequestMapping(path = "/employees/{id}")
  public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
    log.info("Fetch a single  emplyoee");
    return dao.findByIdAndDelete(id);
  }

  @RequestMapping(path = "/manager/{mgrid}")
  public Optional<List<Employee>> getManager(@PathVariable("mgrid") int mgrid) {
    log.info("Fetch all  emplyoees to a manager");
    return dao.findByManagerAndDelete(mgrid);
  }

  @PutMapping("/employee")
  public String updateEmp(@RequestBody Employee e) throws ResourceNotFound {

    log.info("Update an emplyoee");
    Employee emp =
        dao.findById(e.getId()).orElseThrow(() -> new ResourceNotFound("employee not found"));
    emp.setEmpno(e.getEmpno());
    emp.setFname(e.getFname());
    emp.setLname(e.getLname());
    emp.setMgrid(e.getMgrid());
    dao.save(emp);
    return "employee with id " + e.getId() + " is updated successfully";
  }

  @PutMapping("/employees/{id}")
  public String deleteEmp(@PathVariable("id") int id) throws ResourceNotFound {

    log.info("Delete an  emplyoee");
    Employee emp = dao.findById(id).orElseThrow(() -> new ResourceNotFound("employee not found"));
    emp.setIsdeleted(1);
    dao.save(emp);
    return "record deleted";
  }
}
