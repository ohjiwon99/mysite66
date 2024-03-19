package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체가져오기
	public List<GalleryVo> gallerySelect() {
		System.out.println("GalleryDao.galleySelect()");

		List<GalleryVo> galleryList = sqlSession.selectList("gallery.selectList");

		// System.out.println(personList);

		return galleryList;
	}

	// 1개 가져오기2
	public Map<String, Object> gallerySelectOne2(int no) {
		System.out.println("GalleryDao.gallerySelectOne()");

		Map<String, Object> pMap = sqlSession.selectOne("gallery.selectOne2", no);
		// System.out.println(pMap);
		// System.out.println(pMap.get("name"));

		return pMap;
	}

	// 수정
	public int galleryModify(GalleryVo galleryVo) {
		System.out.println("GalleryDao.galleryModify()");

		int count = sqlSession.update("gallery.galleryUpdate", galleryVo);

		return count;

	}

	// 삭제
	public int galleryDelete(Map<String, String> gMap) {

		int count = sqlSession.delete("gallery.galleryDelete", gMap);
		// System.out.println(count);

		return count;
	}

	// 데이터 1개 가져오기 no 1개 데이터 가져오기
	public GalleryVo gallerySelectOne(int no) {
		System.out.println("GalleryDao.guestbookSelectOne()");

		GalleryVo galleryVo = sqlSession.selectOne("gallery.selectOne", no);
		System.out.println(galleryVo);
		return galleryVo;
	}

	// ajax삭제
	public int deleteSelectKey(GalleryVo galleryVo) {
		System.out.println("GalleryDao.deleteSelectKey()");

		int count = sqlSession.delete("gallery.deleteSelectKey", galleryVo);

		return count;
	}

	// gallery파일등록
	public int galleryInsert(GalleryVo galleryVo) {
		System.out.println("GalleryDao.galleryInsert()");

		// System.out.println(attachVo);
		int count = sqlSession.insert("galleryInsert", galleryVo);

		return count;
	}

}
