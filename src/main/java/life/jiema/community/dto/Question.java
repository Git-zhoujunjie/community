package life.jiema.community.dto;

import lombok.Data;

/**
 * @author Zhoujunjie
 * @create 2019/10/8 14:49
 */
@Data
public class Question {
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
}
