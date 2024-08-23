package com.example.mySite.post;

import com.example.mySite.DataNotFoundException;
import com.example.mySite.user.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page,
                       @RequestParam(value = "pg", defaultValue = "") String pg) {
        Page<Post> paging = this.postService.getList(page, pg);
        model.addAttribute("paging", paging);
        model.addAttribute("pg", pg);
        return "post_list";
    }
}
