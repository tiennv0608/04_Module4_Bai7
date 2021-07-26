package com.codegym.service.impl;

import com.codegym.exception.BadWordException;
import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private static final List<String> BAD_WORD_LIST;

    static {
        BAD_WORD_LIST = new ArrayList<>();
        BAD_WORD_LIST.add("stupid");
        BAD_WORD_LIST.add("idiot");
        BAD_WORD_LIST.add("fuck");
        BAD_WORD_LIST.add("damn");
    }


    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Iterable<Comment> showAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Page<Comment> showCommentByDate(Pageable pageable) {
        return commentRepository.showAllCommentByDate(pageable);
    }

    @Override
    public void save(Comment comment) throws BadWordException {
        for (String str : BAD_WORD_LIST) {
            if (comment.getFeedback().contains(str)) {
                throw new BadWordException(" Feedback contains badword: " + str + ", author: " + comment.getAuthor() + ", at: " + LocalDateTime.now());
            }
        }
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }


    @Override
    public Optional<Comment> findOne(Long id) {
        return commentRepository.findById(id);
    }
}
