package com.Team4.web.restFullController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.entity.ProfSchedule;
import com.Team4.web.entity.Professer;
import com.Team4.web.model.ProfCslInsertModel;
import com.Team4.web.service.ProfCslInsertService;
import com.Team4.web.service.ProfesserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class RestProfController {
	
	@Autowired
	private ProfesserService professerService;
	
	@Autowired
	private ProfCslInsertService cslInsertService;
	

	@PostMapping("/calendarData")
	@ResponseBody
	public List<ProfSchedule> calendarData(@RequestParam("pfNo") String pfNo) {
		return professerService.getProfSchedules(pfNo);
	}
	
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
}
