package com.neko.seed.labeltext.service;

import com.neko.seed.base.entity.Result;
import com.neko.seed.labeltext.entity.Labeltext;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neko.seed.savetext.entity.Savetext;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DY
 * @since 2024-03-14
 */
public interface ILabeltextService extends IService<Labeltext> {
    Result Question_tb_Label(Labeltext questions);
    List<Labeltext> getQuestions10(int userid);
}
