package com.neko.seed.savequestion.service;

import com.neko.seed.base.entity.Result;
import com.neko.seed.savequestion.entity.Savequestion;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DY
 * @since 2024-03-12
 */
public interface ISavequestionService extends IService<Savequestion> {
    Result saveQuestions(Savequestion[] questions);
}
