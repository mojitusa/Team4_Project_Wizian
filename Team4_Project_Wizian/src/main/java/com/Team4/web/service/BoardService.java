package com.Team4.web.service;

import java.util.List;

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

}
