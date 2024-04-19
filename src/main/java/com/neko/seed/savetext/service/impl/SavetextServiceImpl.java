package com.neko.seed.savetext.service.impl;

import com.neko.seed.base.entity.Result;
import com.neko.seed.labeltext.entity.Labeltext;
import com.neko.seed.labeltext.mapper.LabeltextMapper;
import com.neko.seed.savetext.entity.Savetext;
import com.neko.seed.savetext.mapper.SavetextMapper;
import com.neko.seed.savetext.service.ISavetextService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neko.seed.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DY
 * @since 2024-03-14
 */
@Service
public class SavetextServiceImpl extends ServiceImpl<SavetextMapper, Savetext> implements ISavetextService {

    @Autowired
    private SavetextMapper savetextMapper;
    @Override
    public Result Question_tb(Savetext questions) {
        try {
            Integer id = savetextMapper.getMaxLabeltextId();
            int id_max = (id != null) ? id + 1 : 1;
            questions.setId(id_max);
            this.baseMapper.insert(questions);
            return new Result().success(); // 返回成功的结果
        } catch (Exception e) {
            e.printStackTrace();
            return new Result().fail(questions, "error"); // 返回错误的结果
        }
    }

    @Override
    public List<Savetext> getQuestions10(int userid) {
        User user = savetextMapper.getUserById(userid);
        System.out.println(user.toString());
        int num = user.getSavequesnum();
        List<Savetext> questions = savetextMapper.getQuestionsNotStatus1(num);
        System.out.println(questions.toString());
        return questions;
    }
}
