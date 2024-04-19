package com.neko.seed.savetext.mapper;

import com.neko.seed.labeltext.entity.Labeltext;
import com.neko.seed.savetext.entity.Savetext;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neko.seed.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DY
 * @since 2024-03-14
 */
@Mapper
public interface SavetextMapper extends BaseMapper<Savetext> {
    @Select("SELECT * FROM savetext WHERE id > #{num} ORDER BY id LIMIT 10")
    List<Savetext> getQuestionsNotStatus1(@Param("num") int num);

    @Select("SELECT * FROM user WHERE id = #{Id}")
    User getUserById(@Param("Id") int Id);

    @Select("SELECT MAX(id) FROM savetext")
    Integer getMaxLabeltextId();
}
