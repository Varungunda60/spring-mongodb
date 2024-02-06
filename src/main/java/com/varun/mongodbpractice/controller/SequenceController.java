package com.varun.mongodbpractice.controller;

import com.varun.mongodbpractice.entity.UserSequence;
import com.varun.mongodbpractice.service.UserSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userSeq")
@RestController
public class SequenceController {
    @Autowired
    UserSequenceService userSequenceService;

    @GetMapping("/getNextSeq")
    public long getNextSeq() {
        return userSequenceService.getNextValue();
    }
}
