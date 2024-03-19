package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	// 필드
	@Autowired
	private GalleryDao galleryDao;

	// 리스트
	public List<GalleryVo> exeList() {
		System.out.println("GalleryService.exeList()");

		List<GalleryVo> galleryList = galleryDao.gallerySelect();

		return galleryList;
	}

	// 수정폼
	public GalleryVo exeDeleteForm(int no) {
		System.out.println("GalleryService.exeDeleteForm()");

		// 비지니스로직X

		GalleryVo galleryVo = galleryDao.gallerySelectOne(no);

		return galleryVo;

	}

	// 수정폼2
	public Map<String, Object> exeModifyForm2(int bno) {
		System.out.println("GalleryService.exeModifyForm2()");

		Map<String, Object> pMap = galleryDao.gallerySelectOne2(bno);

		return pMap;

	}

	// 게스트북 등록
	public int exeWrite(GalleryVo galleryVo) {
		System.out.println("GalleryService.exeWrite()");

		int count = galleryDao.galleryInsert(galleryVo);

		return count;
	}

	// 1명 읽기폼
	public GalleryVo exeReadForm(int no) {
		System.out.println("GalleryService.exeReadForm()");

		GalleryVo galleryVo = galleryDao.gallerySelectOne(no);

		return galleryVo;

	}

	// ajax 삭제
	public int exeDeleteGallery(GalleryVo galleryVo) {
		System.out.println("GalleryService.exeDeleteGuest()");

		// 저장
		System.out.println("전" + galleryVo);
		int count = galleryDao.deleteSelectKey(galleryVo);
		System.out.println("후" + galleryVo);

		// 1명데이터 가져오기
		// GuestbookVo gVo = guestbookDao.guestbookSelectOne(guestbookVo.getNo());

		return count;
	}

	// file 업로드 / 등록
	public String exeUpload(MultipartFile file, int user_no, String content) {
		System.out.println("GalleryService.exeUpload()");

		// 파일저장폴더
		String saveDir = "D:\\javaStudy\\upload";

		// (0)파일관련 정보수직
		// 오리지날 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("orgName: " + orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("exName: " + exName);
		// System.out.println( orgName.substring(4));
		// System.out.println( orgName.lastIndexOf("."));

		// 저장 파일명(겹치지 않아야 한다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName: " + saveName);

		// 파일 사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize: " + fileSize);

		// 파일 전체 경로(저장파일명 포함)
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath: " + filePath);

		// (1)파일정보를 DB에 저장
		// *Vo묶어주고
		GalleryVo galleryVo = new GalleryVo(user_no, content, filePath, orgName, saveName, fileSize);
		System.out.println(galleryVo);

		// *DB에 저장
		// dao의 메소드 호출해서 저장 ==> 만들어볼것

		System.out.println("GalleryService.exeUpload()_DB");

		galleryDao.galleryInsert(galleryVo);

		System.out.println("......DB저장완료");

		// (2)파일을 하드디스크에 저장
		// 파일저장
		try {

			byte[] fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return saveName;
	}

}
