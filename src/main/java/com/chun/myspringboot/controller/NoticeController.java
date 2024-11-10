package com.chun.myspringboot.controller;

import com.chun.myspringboot.pojo.Notice;
import com.chun.myspringboot.service.Impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    NoticeServiceImpl noticeService;
    //去历史公告页面
    @RequestMapping("/toViewNotice")
    public String toViewNotice(Model model){
        List<Notice> notice = noticeService.queryAllNotice();
        model.addAttribute("notice",notice);
        return "user/notice/select-notice";
    }
    //具体查看公告
    @RequestMapping("/viewNotice/{noticeId}")
    public String ViewNotice(@PathVariable("noticeId")Integer noticeId, Model model){

        Notice notice = noticeService.queryNoticeById(noticeId);
        model.addAttribute("notice",notice);
        return "user/notice/watch-notice";
    }
}
