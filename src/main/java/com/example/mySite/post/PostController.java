package com.example.mySite.post;

import com.example.mySite.DataNotFoundException;
import com.example.mySite.user.AppUser;
import com.example.mySite.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


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

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String postCreate(PostCreateForm postCreateForm) {
        return "post_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String postCreate(@Valid PostCreateForm postCreateForm, BindingResult bindingResult, Principal principal) throws DataNotFoundException {
        if (bindingResult.hasErrors()) {
            return "post_form";
        }
        AppUser appUser = this.userService.getUser(principal.getName());
        this.postService.create(postCreateForm.getTitle(), postCreateForm.getContent(), appUser);
        return "redirect:/post/list";
    }
}
