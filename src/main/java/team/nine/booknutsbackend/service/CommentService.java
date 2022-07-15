package team.nine.booknutsbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.nine.booknutsbackend.domain.Board;
import team.nine.booknutsbackend.domain.Comment;
import team.nine.booknutsbackend.domain.User;
import team.nine.booknutsbackend.dto.request.CommentCreateRequest;
import team.nine.booknutsbackend.dto.request.CommentRequest;
import team.nine.booknutsbackend.dto.response.CommentResponse;
import team.nine.booknutsbackend.exception.board.BoardNotFoundException;
import team.nine.booknutsbackend.exception.comment.CommentNotFoundException;
import team.nine.booknutsbackend.repository.BoardRepository;
import team.nine.booknutsbackend.repository.CommentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public Comment writeComment(Comment comment) {
        System.out.println(comment.getBoard().getBoardId());
        System.out.println(comment.getContent());
        System.out.println(comment.getCreatedDate());
        System.out.println(comment.getUser().getLoginId());
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment writeReComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
    }

//    @Transactional(readOnly = true)
//    public List<CommentRequest> findCommentsByBoardId(Long boardId) {
//        //존재하는 게시글인지 확인
//        return convertNestedStructure(commentRepository.findCommentByCommentIdWithParent(boardId));
//    }
//
}