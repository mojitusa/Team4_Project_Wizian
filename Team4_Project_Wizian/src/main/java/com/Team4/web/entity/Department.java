package com.Team4.web.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Department {
    @Id
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "department") //mappedBy는 연관관계의 주인을 나타낸다.
    
    //주인이 아닌 곳에서 상대방이 주인이라고 알려주기 위해
    //mappedBy를 사용한다. 주인은 mappedBy속성을 사용하지 않는다.
    //주인은 외래키가 존재하는 곳이다. 
    
    private List<Employee> employees;

}
