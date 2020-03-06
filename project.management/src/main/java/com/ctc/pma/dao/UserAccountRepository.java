package com.ctc.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ctc.pma.entities.Employee;
import com.ctc.pma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

}
