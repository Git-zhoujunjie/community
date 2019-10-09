package life.jiema.community.dto;

import lombok.Data;

/**
 * @author Zhoujunjie
 * @create 2019/10/7 19:13
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
