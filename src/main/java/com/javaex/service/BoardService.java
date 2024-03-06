package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public List<BoardVo> exeList() {
		System.out.println("BoardService.exeList()");
		
		List<BoardVo> boardList = boardDao.list();
		
		return boardList;
	}

	public void exeWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeWrite()");
		
		boardDao.write(boardVo);
	}

	public BoardVo exeRead(int no) {
		System.out.println("BoardService.exeRead()");
		
		BoardVo boardVo=boardDao.read(no);
		
		return boardVo;
	}

	public void exeUpdate(BoardVo boardVo) {
		System.out.println("BoardService.exeUpdate()");
		
		boardDao.update(boardVo);
	}
	
	public void exeDelete(int no) {
		System.out.println("GuestbookService.exeDelete()");
		
		boardDao.delete(no);
	}
}
