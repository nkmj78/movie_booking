package edu.spring.posco.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.posco.domain.FreeBoard;
import edu.spring.posco.service.BoardReplyService;
import edu.spring.posco.service.FreeBoardService;

@Controller
@RequestMapping(value = "/board")
public class FreeBoardController {
	
	@Autowired FreeBoardService freeBoardService;
	@Autowired BoardReplyService boardreplyService;
	
	
	@RequestMapping(value = "/freeBoard", method = RequestMethod.GET)
	public void freeBoardAll(Model model) {
		List<FreeBoard> fblist = freeBoardService.boardAll();
		model.addAttribute("fbList", fblist);
	} // end freeBoardAll()
	
	@RequestMapping(value = "/freewrite", method = RequestMethod.GET)
	public void freeWrite() {
		
	} // end revieWrite()
	
	@RequestMapping(value = "/freewrite", method = RequestMethod.POST)
	public String freewrite(FreeBoard freeBoard) {
		// BoardService의 메소드를 사용해서 사용자가 작성한 내용을 DB에 insert
		freeBoardService.insertBoard(freeBoard);
		// 서비스 처리가 끝난 후에 게시판 메인 페이지로 이동
		return "redirect:/board/freeBoard";
	}
	
	@RequestMapping(value = "/fboardetail", method = RequestMethod.GET)
	public void fboarDetail(int bno, Model model) {
		
		// bno로 검색
		FreeBoard freeboard = freeBoardService.searchBoard(bno);
		model.addAttribute("freeboard", freeboard);
		
	} // end fboardDetail()
	
	@RequestMapping(value= "/fboardupdate", method = RequestMethod.GET )
	public void fboardUpdate(int bno,  Model model) {
		FreeBoard freeboard = freeBoardService.searchBoard(bno);
		model.addAttribute("freeboard", freeboard);
		
	} // end fboardUpdate()
		
	@RequestMapping(value = "/fboardupdate", method = RequestMethod.POST)
	public String fboardUpdate(FreeBoard freeBoard) {
		// BoardService의 메소드를 사용해서 게시글을 수정(DB 테이블 수정)
		freeBoardService.updateBoard(freeBoard);
		// 게시글 수정 이후에 상세보기 페이지로 이동(redirect)
		return "redirect:/board/fboardetail?bno=" + freeBoard.getBno();
		}
	
	@RequestMapping(value = "/fboardelete", method = RequestMethod.GET)
	public String delete(int bno) {
		// BoardService의 메소드를 사용해서, 게시글 번호 bno인 글을 테이블에서 삭제
		freeBoardService.deleteBoard(bno);
		boardreplyService.deleteBoardReplyByBno(bno);
		// 삭제 후 게시판 메인 페이지로 이동
		return "redirect:/board/freeBoard";
	}
		
	

} // end class FreeBoardController
