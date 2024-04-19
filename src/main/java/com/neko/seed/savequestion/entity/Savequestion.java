package com.neko.seed.savequestion.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Savequestion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;

    private String question;

    private String feedback;

    @TableField("isSave")
    private Integer isSave;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updatetime;
    private LocalTime time;
    private Integer batch;
    private String markingchar;
}
