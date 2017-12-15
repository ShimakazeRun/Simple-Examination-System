package web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.exception.CustomException;
import web.po.*;
import web.service.CourseService;
import web.service.SelectedCourseService;
import web.service.StudentService;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SelectedCourseService selectedCourseService;

    //显示所有课程
    @RequestMapping(value = "/showCourse")
    public String showCourse(Model model, Integer page) throws Exception {

        List<CourseCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCourse());

        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectedCourseListByName((String) subject.getPrincipal());
        Amount amount = new Amount();
        amount.setCourseAmount(courseService.getCountCourse());
        amount.setSelectedCourseAmount(studentCustom.getSelectedCourseAmount());
        amount.setOverCourseAmount(studentCustom.getOverCourseAmount());

        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }

        model.addAttribute("courseList", list);
        model.addAttribute("amount", amount);
        model.addAttribute("pagingVO", pagingVO);

        return "student/showCourse";
    }

    //搜索课程
    @RequestMapping(value = "/searchCourse", method = RequestMethod.POST)
    public String searchCourse(String findByName, Model model) throws Exception {

        List<CourseCustom> list = courseService.findByName(findByName);

        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectedCourseListByName((String) subject.getPrincipal());
        Amount amount = new Amount();
        amount.setCourseAmount(courseService.getCountCourse());
        amount.setSelectedCourseAmount(studentCustom.getSelectedCourseAmount());
        amount.setOverCourseAmount(studentCustom.getOverCourseAmount());

        model.addAttribute("courseList", list);
        model.addAttribute("amount", amount);

        return "student/showCourse";
    }

    //已选课程
    @RequestMapping(value = "/selectedCourse")
    public String selectedCourse(Model model) throws Exception {

        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectedCourseListByName((String) subject.getPrincipal());

        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        Amount amount = new Amount();
        amount.setCourseAmount(courseService.getCountCourse());
        amount.setSelectedCourseAmount(studentCustom.getSelectedCourseAmount());
        amount.setOverCourseAmount(studentCustom.getOverCourseAmount());

        model.addAttribute("selectedCourseList", list);
        model.addAttribute("amount", amount);

        return "student/selectedCourse";
    }

    //已修课程
    @RequestMapping(value = "/overCourse")
    public String overCourse(Model model) throws Exception {

        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectedCourseListByName((String) subject.getPrincipal());

        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        Amount amount = new Amount();
        amount.setCourseAmount(courseService.getCountCourse());
        amount.setSelectedCourseAmount(studentCustom.getSelectedCourseAmount());
        amount.setOverCourseAmount(studentCustom.getOverCourseAmount());

        model.addAttribute("selectedCourseList", list);
        model.addAttribute("amount", amount);

        return "student/overCourse";
    }

    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest(Model model) throws Exception {

        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectedCourseListByName((String) subject.getPrincipal());
        Amount amount = new Amount();
        amount.setCourseAmount(courseService.getCountCourse());
        amount.setSelectedCourseAmount(studentCustom.getSelectedCourseAmount());
        amount.setOverCourseAmount(studentCustom.getOverCourseAmount());

        model.addAttribute("amount", amount);

        return "student/passwordRest";
    }

    //选课
    @RequestMapping(value = "/selectCourse")
    public String selectCourse(int id) throws Exception {

        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        SelectedCourseCustom scc = selectedCourseService.findOne(selectedCourseCustom);

        if (scc == null) {
            selectedCourseService.save(selectedCourseCustom);
        } else {
            throw new CustomException("你已选择该课程");
        }

        return "redirect:/student/selectedCourse";
    }

    //退课
    @RequestMapping(value = "/outCourse")
    public String outCourse(int id) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        selectedCourseService.remove(selectedCourseCustom);

        return "redirect:/student/selectedCourse";
    }

}
