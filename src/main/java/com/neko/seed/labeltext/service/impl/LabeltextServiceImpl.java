package com.neko.seed.labeltext.service.impl;

import com.neko.seed.base.entity.Result;
import com.neko.seed.labelquestion.mapper.LabelquestionMapper;
import com.neko.seed.labeltext.entity.Labeltext;
import com.neko.seed.labeltext.mapper.LabeltextMapper;
import com.neko.seed.labeltext.service.ILabeltextService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neko.seed.user.entity.User;
import com.neko.seed.user.service.UserService;
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
public class LabeltextServiceImpl extends ServiceImpl<LabeltextMapper, Labeltext> implements ILabeltextService {

    @Autowired
    private LabeltextMapper labeltextMapper;
    @Override
    public Result Question_tb_Label(Labeltext questions) {
        try {
            Integer id = labeltextMapper.getMaxLabeltextId();
            int id_max = (id != null) ? id+1 : 1;
            questions.setId(id_max);
            System.out.println("asdfads"+questions);
            labeltextMapper.insert(questions);
            return new Result().success(); // 返回成功的结果
        } catch (Exception e) {
            e.printStackTrace();
            return new Result().fail(questions, "error"); // 返回错误的结果
        }
    }

    @Override
    public List<Labeltext> getQuestions10(int userid) {
        User user = labeltextMapper.getUserById(userid);
        System.out.println(user.toString());
        int num = user.getLabelquesnum();
        List<Labeltext> questions = labeltextMapper.getQuestionsNotStatus1(num);
        return questions;
    }
}
