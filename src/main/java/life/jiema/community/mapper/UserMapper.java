package life.jiema.community.mapper;

import life.jiema.community.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Zhoujunjie
 * @create 2019/10/7 21:02
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
