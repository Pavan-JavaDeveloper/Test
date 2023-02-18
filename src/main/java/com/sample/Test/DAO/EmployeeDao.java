package com.sample.Test.DAO;

import com.sample.Test.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {
}
