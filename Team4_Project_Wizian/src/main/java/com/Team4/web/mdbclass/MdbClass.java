package com.Team4.web.mdbclass;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "team4") // 실제 몽고 DB 컬렉션 이름 
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MdbClass{

    @Id
    private String id;
    private String name;
    private Long age;
}
