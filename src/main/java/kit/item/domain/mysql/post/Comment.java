package kit.item.domain.mysql.post;

import jakarta.persistence.*;
import kit.item.domain.mysql.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "COMMENT")
@ToString(callSuper = true)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long id;

    private String content;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @ToString.Exclude
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    @ToString.Exclude
    private Comment parentComment;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentComment")
    @ToString.Exclude
    private List<Comment> childrenComment;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment")
    @ToString.Exclude
    private List<CommentReport> commentReports = new ArrayList<>();

    public void setChildrenComment(List<Comment> childrenComment) {
        this.childrenComment = childrenComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
