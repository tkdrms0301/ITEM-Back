package kit.item.domain.post;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import kit.item.dto.entity.community.CommentDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COMMENT")
@ToString(callSuper = true)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long id;

    private String content;
    private LocalDateTime date;
    private Long report;

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

    public CommentDto toDto() {
        return CommentDto.builder()
                .id(this.id)
                .content(this.content)
                .date(this.date)
                .report(this.report)
                .memberId(this.member.getId())
                .memberName(this.member.getName())
                .build();
    }

    public void setContent(String content) {
        this.content = content;
    }
}
