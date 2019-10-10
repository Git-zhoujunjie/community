package life.jiema.community.dto;

import lombok.Data;

/**
 * @author Zhoujunjie
 * @create 2019/10/10 16:28
 */
@Data
public class QuestionDto {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private User user;
}
