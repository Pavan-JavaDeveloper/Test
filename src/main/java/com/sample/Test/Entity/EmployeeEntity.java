package com.sample.Test.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "emptable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "empid")
    private Integer empId;
    @Column(name = "empname")
    private String empName;
    @Column(name = "empaddr")
    private String empAddr;
    @Column(name = "empsal")
    private Double empSal;
    @Column(name = "empage")
    private Long empAge;
}
