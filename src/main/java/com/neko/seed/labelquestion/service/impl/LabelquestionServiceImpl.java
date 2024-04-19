package com.neko.seed.labelquestion.service.impl;

import com.neko.seed.base.entity.Result;
import com.neko.seed.labelquestion.entity.Labelquestion;
import com.neko.seed.labelquestion.mapper.LabelquestionMapper;
import com.neko.seed.labelquestion.service.ILabelquestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neko.seed.savequestion.entity.Savequestion;
import com.neko.seed.savequestion.mapper.SavequestionMapper;
import com.neko.seed.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DY
 * @since 2024-03-12
 */
@Service
public class LabelquestionServiceImpl extends ServiceImpl<LabelquestionMapper, Labelquestion> implements ILabelquestionService {

    @Autowired
    private LabelquestionMapper labelquestionMapper;

    @Override
    public Result saveQuestions(Labelquestion[] questions){
        // 获取最新的 batch 值
        Integer latestBatch = labelquestionMapper.getLatestBatch();
        int batch_max = (latestBatch != null) ? latestBatch + 1 : 1;

        for (Labelquestion question : questions) {
            saveQuestionToDatabase(question, batch_max);
        }

        return new Result().success();
    }



    private void saveQuestionToDatabase(Labelquestion question,int batch_max) {
        question.setBatch(batch_max);
        question.setUpdatetime(LocalDateTime.now()); // 设置当前时间
        int userid = question.getUserId();
        User user = labelquestionMapper.getUserById(userid);
        user.setLabelquesnum(question.getId());
        labelquestionMapper.updateUser(user);
        this.baseMapper.insert(question);
    }
}
