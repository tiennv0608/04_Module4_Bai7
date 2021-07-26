package com.codegym.controller;

import com.codegym.exception.BadWordException;
import com.codegym.model.Comment;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/home")
    public ModelAndView showHomePage(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/index");
        Page<Comment> comments = commentService.showCommentByDate(pageable);
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @GetMapping("/saveComment")
    public String addComment(Comment comment) throws BadWordException {
        comment.setDate();
        commentService.save(comment);
        return "redirect:/home";
    }

    @GetMapping("/likeComment/{id}")
    public String like(@PathVariable long id) throws BadWordException {
        Optional<Comment> comment = commentService.findOne(id);
        comment.get().setLikes(comment.get().getLikes() + 1);
        commentService.save(comment.get());
        return "redirect:/home";
    }

    @GetMapping("/dislikeComment/{id}")
    public String disLike(@PathVariable long id) throws BadWordException {
        Optional<Comment> comment = commentService.findOne(id);
        comment.get().setLikes(comment.get().getLikes() - 1);
        commentService.save(comment.get());
        return "redirect:/home";
    }

    @ExceptionHandler(BadWordException.class)
    public ModelAndView showBadWordException(){
        return new ModelAndView("/error");
    }
}
