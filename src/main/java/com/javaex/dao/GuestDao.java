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

}
