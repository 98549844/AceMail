package com.ace.mail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname: MailController
 * @Date: 2022/10/28 下午 10:09
 * @Author: kalam_au
 * @Description:
 */

@Controller
public class MailController {
    private static final Logger log = LogManager.getLogger(MailController.class.getName());

    @RequestMapping(value = "/ace/mail/send", method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        String send = "ACE MAIL SENDER !!!";
        System.out.println(send);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(send);
        return modelAndView;
    }

}

