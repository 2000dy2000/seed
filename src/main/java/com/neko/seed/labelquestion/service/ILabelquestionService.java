package com.neko.seed.labelquestion.service;

import com.neko.seed.base.entity.Result;
import com.neko.seed.labelquestion.entity.Labelquestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neko.seed.savequestion.entity.Savequestion;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DY
 * @since 2024-03-12
 */
public interface ILabelquestionService extends IService<Labelquestion> {
    Result saveQuestions(Labelquestion[] questions);
}
