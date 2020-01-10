package com.psl.crud.Service;

import com.psl.crud.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao dao;


//    public List<Employee> getAll()
//    {
//        return dao.findAll();
//    }



//    public Employee getById(int id)
//    {
//        return dao.findById(id).get();
//    }

    public Employee insert(Employee e)
    {
        return dao.save(e);
    }

//    public void update(Employee e,int id)
//    {
//        dao.save(e);
//
//    }
//    public void delete(int id)
//    {
//        dao.deleteById(id);
//    }


}


