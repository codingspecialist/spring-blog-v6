package com.example.blog.board;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        boardService.게시글삭제(id);
        return "redirect:/";
    }

    @GetMapping("/save-form")
    public String saveForm() {
        return "save-form";
    }

    @PostMapping("/board/save")
    public void save(BoardRequest.SaveDTO saveDTO, HttpServletResponse response) throws IOException { // x-www는 클래스로 받을 수 있다.
        System.out.println(saveDTO); // @Data는 내부에 toString을 재정의해서 구현해준다.
        boardService.게시글쓰기(saveDTO);
        response.setStatus(302); // header 302
        response.setHeader("Location", "/");
        // return "redirect:/";
    }

    /**
     * 쿼리스트링(where절) : /board?title=바다
     * 패스변수(where절) :  /board/1
     */
    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        BoardResponse.DetailDTO boardDetail = boardService.게시글상세보기(id);
        model.addAttribute("model", boardDetail);
        return "detail";
    }

    @GetMapping("/")
    public String list(Model model) { // DS(request객체를 model이라는 객체로 랩핑해서 전달해준다)
        List<BoardResponse.DTO> boardList = boardService.게시글목록보기();
        model.addAttribute("models", boardList);
        return "list";
    }
}












