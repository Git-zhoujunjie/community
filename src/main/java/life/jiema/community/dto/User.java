package life.jiema.community.dto;

import lombok.Data;

/**
 * @author Zhoujunjie
 * @create 2019/10/7 21:04
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
