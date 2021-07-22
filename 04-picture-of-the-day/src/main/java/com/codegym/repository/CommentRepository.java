package com.codegym.repository;

import com.codegym.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    @Query("select c from Comment c where c.date = CURRENT_DATE ")
    Page<Comment> showAllCommentByDate(Pageable pageable);


}
