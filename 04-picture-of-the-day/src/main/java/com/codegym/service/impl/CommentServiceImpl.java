package com.codegym.service.impl;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

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
    public void save(Comment comment) {
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
