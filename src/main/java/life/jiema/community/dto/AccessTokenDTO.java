package life.jiema.community.dto;

import lombok.Data;

/**
 * @author Zhoujunjie
 * @create 2019/9/24 16:28
 *
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
