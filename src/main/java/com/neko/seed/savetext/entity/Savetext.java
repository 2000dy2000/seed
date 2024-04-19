package com.neko.seed.savetext.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author DY
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Savetext implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String question;


}
