package com.neko.seed.savequestion.service.impl;

import com.neko.seed.base.entity.Result;
import com.neko.seed.savequestion.entity.Savequestion;
import com.neko.seed.savequestion.mapper.SavequestionMapper;
import com.neko.seed.savequestion.service.ISavequestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neko.seed.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DY
 * @since 2024-03-12
 */
@Service
public class SavequestionServiceImpl extends ServiceImpl<SavequestionMapper, Savequestion> implements ISavequestionService {
    @Autowired
    private SavequestionMapper savequestionMapper;
    @Override
    public Result saveQuestions(Savequestion[] questions){
        // 获取最新的 batch 值
        Integer latestBatch = savequestionMapper.getLatestBatch();
        int batch_max = (latestBatch != null) ? latestBatch + 1 : 1;
        for (Savequestion question : questions) {
            saveQuestionToDatabase(question, batch_max);
        }

        return new Result().success();
    }
    private void saveQuestionToDatabase(Savequestion question,int batch_max) {
        question.setBatch(batch_max);
        question.setUpdatetime(LocalDateTime.now()); // 设置当前时间
        int userid = question.getUserId();
        User user = savequestionMapper.getUserById(userid);
        System.out.println("dafaf"+user);
        user.setSavequesnum(question.getId());
        savequestionMapper.updateUser(user);
        this.baseMapper.insert(question);
    }
}
