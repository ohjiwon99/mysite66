package com.javaex.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class ApiGuestbookController {

	@Autowired
	private GuestService guestService;
	
	//삭제
	@ResponseBody
	@RequestMapping(value = "/api/guestbooks/{no}", method = RequestMethod.DELETE)
	public int remove(@PathVariable("no") int no,  @ModelAttribute GuestVo guestVo ) {
		System.out.println("ApiGuestbookController.remove()");
		System.out.println(no);
		System.out.println(guestVo);
		
		int count = guestService.exeDelete(guestVo);
		System.out.println(count);
		return count;
		}
	

	// 게시글 리스트
	@ResponseBody // return의 데이터를 json으로 변경해서 응답문서(response)의 바디에 붙여서 보냄
	@RequestMapping(value = "/api/guestbooks", method = RequestMethod.GET)
	public List<GuestVo> list() {
		System.out.println("ApiGuestbookController.list()");

		List<GuestVo> guestbookList = guestService.exeList();
		System.out.println(guestbookList);

		return guestbookList;
	}
	
	//등록
	@ResponseBody
	@RequestMapping(value = "/api/guestbooks", method = RequestMethod.POST)
	public GuestVo add(@RequestBody GuestVo guestVo ) {
		System.out.println("ApiGuestbookController.add()");
		System.out.println(guestVo);
		
		GuestVo gvo = guestService.exeAddendGuest(guestVo);
		System.out.println(gvo);
		return gvo;
		}
	
	
	

}
