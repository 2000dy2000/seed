package com.neko.seed.excellink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neko.seed.base.entity.Result;
import com.neko.seed.excellink.mapper.ExcellinkMapper;
import com.neko.seed.excellink.service.IExcellinkService;
import com.neko.seed.labelquestion.entity.Excellink;
import com.neko.seed.labelquestion.entity.Labelquestion;
import com.neko.seed.labelquestion.mapper.LabelquestionMapper;
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
public class ExcellinkServiceImpl extends ServiceImpl<ExcellinkMapper, Excellink> implements IExcellinkService {

}
