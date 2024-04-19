package com.neko.seed.labeltext.mapper;

import com.neko.seed.labeltext.entity.Labeltext;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neko.seed.user.entity.User;
import org.apache.ibatis.annotations.Insert;
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
public interface LabeltextMapper extends BaseMapper<Labeltext> {

    @Select("SELECT * FROM labeltext WHERE id > #{num} ORDER BY id LIMIT 10")
    List<Labeltext> getQuestionsNotStatus1(@Param("num") int num);

    @Select("SELECT * FROM user WHERE id = #{Id}")
    User getUserById(@Param("Id") int Id);
    @Insert("INSERT INTO labeltext (question) VALUES (#{question})")
    int insertquestions(@Param("question") String question);

    @Select("SELECT MAX(id) FROM labeltext")
    Integer getMaxLabeltextId();
}
