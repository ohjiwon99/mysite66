package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {

	@Autowired
	private SqlSession sqlSession;

	public List<GuestVo> list() {
		System.out.println("guestDao.list()");

		return sqlSession.selectList("guest.list");
	}

	public int write(GuestVo guestVo) {
		System.out.println("guestDao.write()");

		int count = sqlSession.insert("guest.insert", guestVo);

		System.out.println(guestVo);
		return count;
	}

	public int delete(GuestVo guestVo) {
		System.out.println("guestDao.delete()");

		int count = sqlSession.delete("guest.delete", guestVo);

		return count;
	}

	// ajax등록
	public int insertSelectKey(GuestVo guestVo) {
		System.out.println("guestDao.insertSelectKey()");

		// System.out.println(guestVo);// no비어있음
		int count = sqlSession.insert("insertSelectKey", guestVo);
		// System.out.println(guestVo);// no 생김
		// guestVo.getNo();

		// GuestVo gvo = sqlSession.selectOne("guest.selectOne", guestVo.getNo());
		// System.out.println(gvo);

		return count;
	}

	// 데이터 한개 가져오기
	public GuestVo guestselectOne(int no) {
		System.out.println("guestDao.guestselectOne()");

		 GuestVo guestVo = sqlSession.selectOne("guest.selectOne",no);
		 System.out.println(guestVo);

		return guestVo;
	}

}
