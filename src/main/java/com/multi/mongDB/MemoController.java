package com.multi.mongDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//컨트롤러 관련 어노테이션
@Controller
public class MemoController {
	@Autowired
	MemoServiceImpl memoservice;
	@RequestMapping("insert.memo")
	public String insert(MemoVO vo) {
		memoservice.insert(vo);
		return "redirect:mongo_memo.jsp";
	}
	@RequestMapping("update.memo")
	public String update(String _id, String content) {
		MemoVO vo = new MemoVO();
		vo.set_id(_id);
		vo.setContent(content);
		memoservice.update(vo);
		return "redirect:mongo_memo.jsp";
	}
	
	@RequestMapping("delete.memo")
	public String delete(String _id) {
		memoservice.delete(_id);
		return "redirect:mongo_memo.jsp";
	}
	@RequestMapping("one.memo")
	public void one(String _id,Model model) {
		MemoVO vo=memoservice.one(_id);
		System.out.println("하나의 document검색 결과>> "+vo);
		model.addAttribute("vo",vo);
		//ModelAnd View 5버전 이전에 사용하던 것 요새는 return 값으로 view 자동지정
		//model ==> 처리결과를 넣음.
		//view ==> views아래에 어떤 파일에 넣을지를 결정.
	}
	@RequestMapping("list.memo")
	public void list(Model model) {
		List<MemoVO> list=memoservice.list();
		model.addAttribute("list",list);
	}
}