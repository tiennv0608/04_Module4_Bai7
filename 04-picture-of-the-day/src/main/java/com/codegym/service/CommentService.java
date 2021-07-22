package com.codegym.service;

import com.codegym.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Iterable<Comment> showAllComment();

    Page<Comment> showCommentByDate(Pageable pageable);

    void save(Comment comment);

    void delete(Long id);

    Optional<Comment> findOne(Long id);
}
