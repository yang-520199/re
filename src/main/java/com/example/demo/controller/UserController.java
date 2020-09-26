package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/test")
    @ResponseBody
    public String userControllerTest() {
        return "凉凉-(电视剧《三生三世十里桃花》片尾曲) - 张碧晨&杨宗纬\n" +
                "作词：刘畅\n" +
                "作曲：谭旋\n" +
                "编曲：韦国赟\n" +
                "入夜渐微凉 繁花落地成霜\n" +
                "你在远方眺望 耗尽所有暮光\n" +
                "不思量 自难相忘\n" +
                "夭夭桃花凉 前世你怎舍下\n" +
                "这一海心茫茫 还故作不痛不痒不牵强\n" +
                "都是假象\n" +
                "凉凉夜色 为你思念成河\n" +
                "化作春泥 呵护着我\n" +
                "浅浅岁月 拂满爱人袖\n" +
                "片片芳菲 入水流\n" +
                "凉凉天意 潋滟一身花色\n" +
                "落入凡尘 伤情着我";
    }

}