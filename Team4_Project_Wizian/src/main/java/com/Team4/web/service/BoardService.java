package com.Team4.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.model.BoardModel;
import com.Team4.web.repository.BoardDAO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	public List<BoardModel> boardList(Object session) {
		return boardDAO.boardList(session);
	}
	public List<Map<String, Object>> getCounselDetail(int cslNo, String category, Object session) {
		return boardDAO.getCounselDetail(cslNo, category, session);
	}
	public int cancelReservation(String cslNo, String cslCate, Object session) {
		return boardDAO.cancelReservation(cslNo, cslCate, session);
	}

}
