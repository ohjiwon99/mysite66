package com.javaex.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 게시글 리스트
	@RequestMapping(value = "/board/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("BoardController.list()");

		List<BoardVo> boardList = boardService.exeList();

		model.addAttribute("boardList", boardList);

		return "board/list";
	}

	// 글쓰기 폼
	@RequestMapping(value = "/board/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeform() {
		System.out.println("BoardController.writeform()");

		return "board/writeForm";
	}

	// 글쓰기
	@RequestMapping(value = "/board/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo, HttpSession session) {
		System.out.println("BoardController.write()");

		UserVo userVo = (UserVo) session.getAttribute("authUser");

		boardVo.setUserNo(userVo.getNo());

		boardService.exeWrite(boardVo);

		return "redirect:/board/list";
	}

	// 게시글 열람
	@RequestMapping(value = "/board/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@RequestParam(value = "no") int no, Model model) {
		System.out.println("BoardController.read()");

		BoardVo boardVo = boardService.exeRead(no);

		model.addAttribute(boardVo);

		return "board/read";
	}

	// 수정 폼
	@RequestMapping(value = "/board/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String mform(@RequestParam(value = "no") int no, Model model) {
		System.out.println("BoardController.modifyform()");

		BoardVo boardVo = boardService.exeRead(no);

		model.addAttribute(boardVo);

		return "board/modifyForm";
	}

	// 수정
	@RequestMapping(value = "/board/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.modify()");

		boardService.exeUpdate(boardVo);

		return "redirect:/board/list";
	}

	// 삭제
	@RequestMapping(value = "/board/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {

		boardService.exeDelete(no);

		return "redirect:/board/list";
	}

}
