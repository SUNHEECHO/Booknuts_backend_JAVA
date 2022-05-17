package team.nine.booknutsbackend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    @Column(nullable = false)
    private Boolean deleteCheck = false; //true : 삭제됨

    @Column(length = 100, nullable = false)
    private String bookTitle;

    @Column(length = 300, nullable = false)
    private String bookImgUrl;

    @Column(length = 100, nullable = false)
    private String bookGenre;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name ="writer")
    private User user;
}