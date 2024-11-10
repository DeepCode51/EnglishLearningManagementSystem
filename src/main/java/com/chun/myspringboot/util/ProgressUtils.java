package com.chun.myspringboot.util;

import com.chun.myspringboot.pojo.Grade;
import com.chun.myspringboot.pojo.Word;
import com.chun.myspringboot.service.Impl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


/**
 * 调用DataUtils处理数据生成百分比，
 * 然后，往页面传值
 */
@Controller
public class ProgressUtils {
   @Autowired
    WordServiceImpl wordService;

   @Autowired
   DataUtils dataUtils;
    public void Progress(Model model,Integer grade){

        int Remember = wordService.queryRememberNumberByGrade(grade);
        int Number = wordService.queryAllWordNumberByGrade(grade);
        int study = wordService.queryStudyNumberByGrade(grade);
        String studypercent = dataUtils.percent(study, Number);
        String percent = dataUtils.percent(Remember, Number);
        String unpercent = dataUtils.unpercent(Remember, Number);

        model.addAttribute("remember",percent);
        model.addAttribute("unremembered",unpercent);
        model.addAttribute("study",studypercent);

        return;
    }
        //得到收藏信息
        public void getCollection(Model model,Word word){

            //查询是否收藏过单词
        Integer collection = word.getCollection();
        if (collection==0){
            model.addAttribute("msg","加入收藏");
        }else {
            model.addAttribute("msg","已经收藏");
        }
    }



}
