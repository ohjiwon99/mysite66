package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryContoller {
	
   //갤러리 리스트
   @RequestMapping(value="/gallery/list" , method = { RequestMethod.GET, RequestMethod.POST })
   public String list() {
      System.out.println("GalleryContoller.list()");
      
      
      return "gallery/list";
   }

}
