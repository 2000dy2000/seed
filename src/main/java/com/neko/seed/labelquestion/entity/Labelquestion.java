package com.neko.seed.labelquestion.entity;

import java.time.LocalTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.ArrayTypeHandler;

/**
 * <p>
 *
 * </p>
 *
 * @author DY
 * @since 2024-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Labelquestion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;

    private String question;

    private String feedback;

    @TableField("selectedOptions")
    private String selectedOptions;

    private LocalTime time;

    private LocalDateTime updatetime;

    private Integer batch;
}
