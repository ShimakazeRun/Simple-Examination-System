package web.mapper;

import web.po.StudentCustom;

public interface StudentCustomMapper {

    //查询学生的选课信息
    StudentCustom findStudentAndSelectedCourseListById(Integer id) throws Exception;
}
