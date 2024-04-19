package com.neko.seed.excellink.mapper;

import com.neko.seed.labelquestion.entity.Excellink;
import com.neko.seed.labelquestion.entity.Labelquestion;
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
public interface ExcellinkMapper extends BaseMapper<Excellink> {
}
