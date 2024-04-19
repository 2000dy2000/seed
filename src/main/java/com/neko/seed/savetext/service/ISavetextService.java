package com.neko.seed.savetext.service;

import com.neko.seed.base.entity.Result;
import com.neko.seed.labeltext.entity.Labeltext;
import com.neko.seed.savequestion.entity.Savequestion;
import com.neko.seed.savetext.entity.Savetext;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DY
 * @since 2024-03-14
 */
public interface ISavetextService extends IService<Savetext> {
    Result Question_tb(Savetext questions);
    List<Savetext> getQuestions10(int userid);
}
