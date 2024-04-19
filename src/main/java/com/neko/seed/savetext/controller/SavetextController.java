package com.neko.seed.savetext.controller;


import com.neko.seed.base.entity.Result;
import com.neko.seed.labeltext.entity.Labeltext;
import com.neko.seed.savequestion.entity.Savequestion;
import com.neko.seed.savequestion.service.ISavequestionService;
import com.neko.seed.savetext.entity.Savetext;
import com.neko.seed.savetext.service.ISavetextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
@RequestMapping("/savetext")
public class SavetextController {
    @Autowired
    ISavetextService iSavetextService;
    @PostMapping("/tb")
    public Result saveQuestions(@RequestBody Savetext questions) {
        System.out.println("Received questions: " + questions);
        iSavetextService.Question_tb(questions);
        return new Result().success();
    }

    @GetMapping("/get")
    public List<Savetext> getQuestion(@RequestParam("userid") int userid) {
        List<Savetext> questions = iSavetextService.getQuestions10(userid);
        return questions;
    }
}
