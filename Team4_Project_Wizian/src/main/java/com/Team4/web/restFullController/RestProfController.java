package com.Team4.web.restFullController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.web.entity.ProfSchedule;
import com.Team4.web.entity.Professer;
import com.Team4.web.model.ProfCslInsertModel;
import com.Team4.web.service.ProfCslInsertService;
import com.Team4.web.service.ProfesserService;

@RestController
public class RestProfController {
	
	@Autowired
	private ProfesserService professerService;
	
	@Autowired
	private ProfCslInsertService cslInsertService;

	//jpa
	@PostMapping("/calendarData")
	@ResponseBody
	public List<ProfSchedule> calendarData(@RequestParam("pfNo") String pfNo) {
		return professerService.getProfSchedules(pfNo);
	}
	
	//jpa
	@PostMapping("/pfInfoData")
	@ResponseBody
	public List<Professer> pfInfoData(@RequestParam("pfNo") String pfNo){
		return professerService.getProfData(pfNo);
	}
	
	//ajax로 디비에 데이터 삽입
	@PostMapping("/insertProfCslData")
	@ResponseBody
    public void insertProfCslData(ProfCslInsertModel profCslInsertModel) {
		cslInsertService.insertProfCslData(profCslInsertModel);
    }
	
	//professer html에서 들어온 값으로 디비검색
	@PostMapping("/searchProfDepartment")
	@ResponseBody
	public List<Map<String, Object>> searchProfDepartment(@RequestParam("department") String department) {
		List<Map<String, Object>> list = cslInsertService.searchProfDepartment(department);
		System.err.println(list);
		return list;
	}
}
