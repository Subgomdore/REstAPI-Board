package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.RequestBoardDto;
import com.project.restapiboard.dto.response.ResBoardeListDto;
import com.project.restapiboard.dto.response.ResponseBoardDto;
import com.project.restapiboard.entity.Type;
import com.project.restapiboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 황인성

@RestController
@RequestMapping("/board")
@Slf4j
public class Board1002 {

    @Autowired
    BoardService boardService;

    /*특정게시판안의 리스트 불러오기*/
    @PostMapping("/{typeNo}/list")
    public List<ResBoardeListDto> getBoardList(@RequestBody Type type) {
        List<ResBoardeListDto> res = boardService.getBoardList(type);
        return res;
    }

    /*게시글 조회수 상승*/
    @PutMapping("/{typeNo}/{boardNo}/count")
    public void contentCount(@PathVariable long typeNo, @PathVariable long boardNo){
        boardService.updateCount(boardNo);
    }


    /*게시판의 상세내용 불러오기*/
    @PostMapping("/{typeNo}/{boardNo}")
    public ResponseBoardDto getBoardContent(@PathVariable long typeNo, @PathVariable long boardNo){
        return boardService.getBoardContent(boardNo);
    }

    /*게시판에 글작성하기*/
    @PostMapping("/{typeNo}/write-add")
    public void addContent(@RequestBody RequestBoardDto boardDto, @PathVariable long typeNo) {
        boardService.addContent(boardDto);
    }

}
