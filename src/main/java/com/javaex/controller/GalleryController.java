package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	// 겔러리 리스트폼 이동
	@RequestMapping(value = "/gallery/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GalleryController.list()");

		// 자동연결
		List<GalleryVo> galleryList = galleryService.exeList();
		// System.out.println(galleryList);
		model.addAttribute("gList", galleryList);

		return "gallery/list";
	}

	// gallery등록
	@RequestMapping(value = "/gallery/upload", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "user_no") int user_no,
			@RequestParam(value = "content") String content, Model model) {
		System.out.println("GalleryController.upload()");
		String saveName = galleryService.exeUpload(file, user_no, content);
		model.addAttribute("saveName", saveName);

		return "redirect:/gallery/list";
	}

}
