package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	public List<BoardVo> list() {
		System.out.println("BoardDao.list()");

		List<BoardVo> boardList = sqlSession.selectList("board.list");
		
		return boardList;
	}

	public void write(BoardVo boardVo) {
		System.out.println("BoardDao.write()");
		
		 sqlSession.insert("board.insert", boardVo);
	}

	public BoardVo read(int no) {
		System.out.println("BoardDao.read()");
		
		BoardVo boardVo=sqlSession.selectOne("board.selectOne", no);
		
		return boardVo;
	}

	public void update(BoardVo boardVo) {
		System.out.println("BoardDao.update()");
		
		sqlSession.update("board.update", boardVo);
	}

	public void delete(int no) {
		System.out.println("BoardDao.boardDelete()");
		
		sqlSession.delete("board.delete", no);
	}

}
