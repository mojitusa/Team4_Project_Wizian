package com.Team4.web.restFullController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.web.entity.ProfSchedule;
import com.Team4.web.service.ProfesserService;

@RestController
public class RestProfController {
	
	@Autowired
	private ProfesserService professerService;

	@PostMapping("/calendarData")
	@ResponseBody
	public List<ProfSchedule> calendarData(@RequestParam("pfNo") String pfNo) {
		return professerService.getProfSchedules(pfNo);
	}
	
}
