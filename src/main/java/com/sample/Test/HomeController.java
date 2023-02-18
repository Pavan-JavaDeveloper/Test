package com.sample.Test;

import com.sample.Test.DAO.EmployeeDao;
import com.sample.Test.Entity.EmployeeEntity;
import com.sample.Test.model.EmployeeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private EmployeeDao service;

    @PostMapping("/saveEmp")
    public ResponseEntity createEmployee(@RequestBody EmployeeModel model) {
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(model, entity);
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping("/listEmp")
    public ResponseEntity listAllEmployees() {
        List<EmployeeEntity> employeeModels = service.findAll();
        List<EmployeeModel> entity = new ArrayList<>();
        if (!CollectionUtils.isEmpty(employeeModels)) {
            employeeModels.stream().forEach(employee -> {
                EmployeeModel model = new EmployeeModel();
                BeanUtils.copyProperties(employee, model);
                entity.add(model);
            });
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

}
