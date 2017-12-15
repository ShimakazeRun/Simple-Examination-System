package web.service;

import web.po.StudentCustom;

public interface StudentService {

    //查询学生的选课信息
    StudentCustom findStudentAndSelectedCourseListByName(String name) throws Exception;
}
