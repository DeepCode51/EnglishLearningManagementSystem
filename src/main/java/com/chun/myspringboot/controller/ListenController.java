package com.chun.myspringboot.controller;

import com.chun.myspringboot.pojo.Listen;
import com.chun.myspringboot.service.Impl.ListenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ListenController {
    @Autowired
    ListenServiceImpl listenService;
    //查看所有书籍
    @RequestMapping("/viewListen")
    public String ViewListen(Model model){
        List<Listen> listen = listenService.queryAllListen();
        model.addAttribute("listen",listen);
        return "user/listen/select-listen";
    }
    //具体进入某一书籍
    @RequestMapping("/watchListen/{listenId}")
    public String watchListen(@PathVariable("listenId")Integer listenId, Model model){
        Listen listen = listenService.queryListenById(listenId);

        model.addAttribute("listen",listen);
        return "user/listen/watch-listen";
    }

}
