package com.neko.seed.labelquestion.controller;


import com.neko.seed.base.entity.Result;
import com.neko.seed.labelquestion.entity.Labelquestion;
import com.neko.seed.labelquestion.mapper.LabelquestionMapper;
import com.neko.seed.labelquestion.service.ILabelquestionService;
import com.neko.seed.savequestion.entity.Savequestion;
import com.neko.seed.savequestion.service.ISavequestionService;
import com.neko.seed.util.ExportExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DY
 * @since 2024-03-12
 */
@RestController
@RequestMapping("/labelquestion")
public class LabelquestionController {
    @Autowired
    ILabelquestionService iLabelquestionService;
    @Autowired
    LabelquestionMapper labelquestionMapper;
    @PostMapping("/labelQuestions")
    public Result saveQuestions(@RequestBody Labelquestion[] questions) {
        System.out.println("Received questions: " + Arrays.toString(questions));
        iLabelquestionService.saveQuestions(questions);
        return new Result().success();
    }
    @GetMapping("/get_link")
    public String getLink(){
        String uniqueIdentifier = labelquestionMapper.getlink();
        return uniqueIdentifier;
    }

    @GetMapping("/get_excel/{uniqueIdentifier}")
    public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request, @PathVariable String uniqueIdentifier){
        //得到所有要导出的数据
        List<Labelquestion> orderlist = iLabelquestionService.list();
        //定义导出的excel名字
        String excelName = "订单详情表";

        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("userId","用户ID");
        fieldMap.put("id","id");
        fieldMap.put("question","问题");
        fieldMap.put("feedback","反馈");
        fieldMap.put("selectedOptions","敏感词");
        fieldMap.put("time","答题时间");
        fieldMap.put("updatetime","更新时间");
        if (labelquestionMapper.getlink().equals(uniqueIdentifier)) {
            uniqueIdentifier = UUID.randomUUID().toString().substring(0, 8);
            labelquestionMapper.updateLink(uniqueIdentifier);
            //导出用户相关信息
            new ExportExcelUtils().export(excelName, orderlist, fieldMap, response);
        } else {
            // 如果没有找到匹配的数据，则返回适当的响应，比如一个错误消息或者一个空白页面
            // 这里您可以根据实际需求自行调整
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 设置响应状态码为 404 Not Found
            // 可以返回一个错误消息页面或者空白页面
        }
    }
}
