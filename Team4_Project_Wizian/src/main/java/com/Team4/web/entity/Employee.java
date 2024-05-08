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
    // 다른 필드 및 메소드 생략	

}
