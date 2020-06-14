package kr.co.fastcampus.web.controller;

import kr.co.fastcampus.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("members");
        return mv;
    }

    @RequestMapping("/create")
    public String create(){
        memberService.insert("uusername","password");
        return "redirect:index";
    }


    // memberService.insert(String username, String password);
    // memberService.print();
}
