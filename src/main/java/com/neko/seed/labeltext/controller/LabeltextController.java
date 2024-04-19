package com.neko.seed.labeltext.controller;


import com.neko.seed.base.entity.Result;
import com.neko.seed.labeltext.entity.Labeltext;
import com.neko.seed.labeltext.service.ILabeltextService;
import com.neko.seed.savetext.entity.Savetext;
import com.neko.seed.savetext.service.ISavetextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DY
 * @since 2024-03-14
 */
@RestController
@RequestMapping("/labeltext")
public class LabeltextController {
    @Autowired
    ILabeltextService iLabeltextService;
    @PostMapping("/tb")
    public Result saveQuestions(@RequestBody Labeltext questions) {
        System.out.println("Received questions: " + questions);
        iLabeltextService.Question_tb_Label(questions);
        return new Result().success();
    }
    @GetMapping("/get")
    public List<Labeltext> getQuestion(@RequestParam("userid") int userid) {
        List<Labeltext> questions = iLabeltextService.getQuestions10(userid);
        return questions;
    }
}
