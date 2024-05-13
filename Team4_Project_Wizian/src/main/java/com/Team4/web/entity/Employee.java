package com.Team4.web.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private Long id;
    
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "department_id")  //FK를 써 준다.
    private Department department;
    
//    @ManyToOne
//    @JoinColumn(name = "department_id2")  //FK를 써 준다.
//    private Department department2;
    //하나의 엔티티(테이블)을 두 번 조인할 수도 있다. 
}
