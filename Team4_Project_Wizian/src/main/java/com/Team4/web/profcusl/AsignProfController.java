package com.Team4.web.profcusl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsignProfController {
	
	@GetMapping("/profcusl")
	public String profCusl() {
		return "professerConsultation";
	}
}
