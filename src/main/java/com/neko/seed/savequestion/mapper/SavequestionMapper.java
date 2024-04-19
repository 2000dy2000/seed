package com.neko.seed.savequestion.mapper;

import com.neko.seed.savequestion.entity.Savequestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neko.seed.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DY
 * @since 2024-03-12
 */
@Mapper
public interface SavequestionMapper extends BaseMapper<Savequestion> {
    @Select("SELECT MAX(batch) FROM savequestion")
    Integer getLatestBatch();
    @Select("SELECT * FROM user WHERE id = #{Id}")
    User getUserById(@Param("Id") int Id);
    @Update("UPDATE user SET username = #{user.username}, nickname = #{user.nickname}, password = #{user.password}, savequesnum = #{user.savequesnum}, labelquesnum = #{user.labelquesnum} WHERE id = #{user.id}")
    void updateUser(@Param("user") User user);
    @Update("UPDATE excellink SET link = #{link} WHERE id = 1")
    void updateLink(@Param("link") String link);
    @Select("Select link FROM excellink WHERE id = 1")
    String getlink();
}
