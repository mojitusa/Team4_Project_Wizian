package com.Team4.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Team4.web.entity.Department;
import com.Team4.web.entity.Employee;

public interface JoinExamRepo extends JpaRepository<Employee, Long> {

	//JPQL 사용
	@Query("SELECT e, d FROM Employee e JOIN e.department d")
	List<Employee> joinTest();
	
	//단순 조인. 사용할 일이 없다.
	//엔티티에서 관계 설정하면 하나를 불러오면 알아서 조인해서 불러온다.
	//Employee만 불러와도 알아서 위 코드처럼 조인을 해 준다.  
	
	
	//JPQL 사용
	@Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName")
	List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);
	
	//이 쿼리는 Employee 엔티티와 Department 엔티티를 조인하고,
	//Department 엔티티의 이름이 특정 부서 이름과 일치하는 Employee 엔티티들을 반환합니다.
	//이것도 쓸 필요 없다. 서비스에서 직원을 findByDepartmentName() 메소드로 가져 오면
	//알아서 가져 온다.
	
	//JPQL 사용
	@Query("SELECT e, d FROM Employee e JOIN e.department d")
	List<Object[]> findAllEmployeesAndDepartments();
	
	//이 쿼리는 Employee 엔티티와 Department 엔티티를 조인하고,
	//각각의 조인된 결과를 배열로 반환합니다.
	//각 배열의 첫 번째 요소는 Employee 객체이고, 두 번째 요소는 Department 객체입니다.
	
	
	@Query("SELECT e FROM Department e")
    List<Department> findAllDepartments();
	
	//리포지토리 따로 파기 싫으면 이렇게 직접 쿼리를 입력해도 된다.
	
}


