package com.example.demo.controller;

import com.example.demo.mapper.ResumeMapper;
import com.example.demo.model.Resume;
//import com.example.demo.service.IResumeService;
import com.example.demo.service.IResumeService;
import com.example.demo.tools.AjaxResult;
import com.example.demo.tools.PDFUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;


@RestController
public class ResumeController {
    private static Logger logger=LoggerFactory.getLogger(ResumeController.class);
    @Autowired
    private ResumeMapper resumeMapper;
    private IResumeService resumeService;
    @CrossOrigin
    @PostMapping("add")
    public AjaxResult add(@RequestBody Resume resume){
        resumeMapper.add(resume);
        return new AjaxResult("Add Success");
    }
    @CrossOrigin
    @GetMapping("list")
    @ResponseBody
    public AjaxResult list(){
        List<Resume> list=resumeMapper.findAll();
        return new AjaxResult(list);

    }
    @CrossOrigin
    @PostMapping("update")
    public AjaxResult update(@RequestBody Resume resume) {
        resumeMapper.update(resume);
        return new AjaxResult("Update Success");
    }
    @CrossOrigin
    @PostMapping("delete")
    public AjaxResult delete(@RequestBody Map map){
        resumeMapper.delete((Integer) map.get("id"));
        return new AjaxResult("Delete Success");
    }
    @CrossOrigin
    @GetMapping("download")
    public void download(HttpServletResponse response,@RequestParam("id") int id) throws Exception{
        Resume resume=resumeMapper.findById(id);
        HashMap<String,Object> hashMap=new HashMap<String, Object>(16);
        hashMap.put("name", resume.getName());
        hashMap.put("gender", resume.getGender());
        hashMap.put("age", String.valueOf(resume.getAge()));
        hashMap.put("address", resume.getAddress());
        hashMap.put("email", resume.getEmail());
        hashMap.put("tel", resume.getTel());
        hashMap.put("introduce", resume.getIntroduce());
        hashMap.put("major", resume.getMajor());
        hashMap.put("education", resume.getEducation());
        hashMap.put("school", resume.getSchool());
        hashMap.put("graduation", resume.getGraduation());
        hashMap.put("company", resume.getCompany());
        hashMap.put("position", resume.getPosition());
        hashMap.put("duty", resume.getDuty());
        hashMap.put("departure", resume.getDeparture());
        String fileName=resume.getName()+"-"+resume.getSchool()+".pdf";
        ByteArrayOutputStream outputStream;
        ClassPathResource resource=new ClassPathResource("resume.pdf");
        InputStream inputStream=resource.getInputStream();
        outputStream= PDFUtil.generate(inputStream,hashMap);
        outputStream.writeTo(response.getOutputStream());
        response.setHeader("Content-Disposition", "attachment;filename=" +
                new String((fileName).getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Length", "" + outputStream.toByteArray().length);
        outputStream.close();
        response.getOutputStream().close();
    }
//    @ExceptionHandler
//    public AjaxResult exceptionHandler(Exception e) {
//        //打印异常，方便调试
//        if (logger.isDebugEnabled()) {
//            e.printStackTrace();
//        }
//        return new AjaxResult(500,"System Error");
//    }
    @RequestMapping("/as")
    @ResponseBody
    public Resume cs(){
//        Resume resume=resumeMapper.findById(1);
        Resume resume=resumeService.findById(1);
        return resume;
    }
    @RequestMapping("/sss")
    @ResponseBody
    public String test(){
        return "人生无望，太难了";
    }


    @RequestMapping("123")
    @ResponseBody
    public List<Resume> sh(){

        List<Resume> findAll=resumeMapper.findAll();
        return  findAll;
    }
}
