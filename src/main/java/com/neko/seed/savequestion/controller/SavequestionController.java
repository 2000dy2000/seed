package com.neko.seed.savequestion.controller;


import com.neko.seed.savequestion.entity.Savequestion;
import com.neko.seed.savequestion.mapper.SavequestionMapper;
import com.neko.seed.savequestion.service.ISavequestionService;
import com.neko.seed.util.ExportExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neko.seed.base.entity.Result;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DY
 * @since 2024-03-12
 */
@RestController
@RequestMapping("/savequestion")
public class SavequestionController {

    @Autowired
    ISavequestionService iSavequestionService;
    @Autowired
    SavequestionMapper savequestionMapper;
    @PostMapping("/saveQuestions")
    public Result saveQuestions(@RequestBody Savequestion[] questions) {
        System.out.println("Received questions: " + Arrays.toString(questions));
        iSavequestionService.saveQuestions(questions);
        return new Result().success();
    }
    @GetMapping("/get_link")
    public String getLink(){
        // 生成 8 位 UUID 作为下载链接的一部分
        String uniqueIdentifier = savequestionMapper.getlink();
        return uniqueIdentifier;
    }

    @GetMapping("/get_excel/{uniqueIdentifier}")
    public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request,@PathVariable String uniqueIdentifier){
        //得到所有要导出的数据
        List<Savequestion> orderlist =iSavequestionService.list();
        //定义导出的excel名字
        String excelName = "订单详情表";

        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("userId","用户ID");
        fieldMap.put("id","id");
        fieldMap.put("question","问题");
        fieldMap.put("feedback","反馈");
        fieldMap.put("isSave","安全状态");
        fieldMap.put("updatetime","更新时间");
        fieldMap.put("time","答题时间");
        fieldMap.put("markingchar","标注情况");
        if (savequestionMapper.getlink().equals(uniqueIdentifier)) {
            uniqueIdentifier = UUID.randomUUID().toString().substring(0, 8);
            savequestionMapper.updateLink(uniqueIdentifier);
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
