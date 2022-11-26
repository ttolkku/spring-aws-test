package com.jojoldu.book.springawstest.web;

import com.jojoldu.book.springawstest.config.auth.LoginMember;
import com.jojoldu.book.springawstest.config.auth.dto.SessionMember;
import com.jojoldu.book.springawstest.service.PostsService;
import com.jojoldu.book.springawstest.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginMember SessionMember member) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(member != null) {
            model.addAttribute("memberName", member.getName());
        }
        return "index";
    }

    @GetMapping("/post/save")
    public String postSave() {
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
