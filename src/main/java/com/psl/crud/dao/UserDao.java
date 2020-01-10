package com.psl.crud.dao;

import com.psl.crud.Model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

  DAOUser findByUsername(String username);
}
