package com.psl.crud.Service;


import com.psl.crud.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {



    //Retrieve all employees
    @Query(" select id,fname,lname,empno,mgrid FROM Employee e where e.isdeleted = 0")
    public Optional<List<Employee>> findByall();

    //Retrieve employee with specific id
    @Query(" select id,fname,lname,empno,mgrid FROM Employee e where e.id = ?1 AND e.isdeleted = 0")
    public Optional<Employee> findByIdAndDelete(int id);

    //Retrieve all the employees reports to same manager
    @Query("select id,fname,lname,empno,mgrid FROM Employee e where e.mgrid = ?1 AND e.isdeleted = 0")
    public Optional<List<Employee>> findByManagerAndDelete(int mgrid);

    //Update employee information
    @Query("update Employee e set e.fname =?2,e.lname=?3,e.empno=?4,e.mgrid=?5 where e.id=?1 And e.isdeleted=0")
    public Optional<Employee> findByIdupdate(Employee e);

    //Soft delete employee information
    @Query("update Employee e set e.isdeleted=1 where e.id=?1")
    public String findBydelete(int id);


}
