package web.service;

import web.po.CourseCustom;

import java.util.List;

public interface CourseService {

    //根据名字查询课程
    List<CourseCustom> findByName(String name) throws Exception;

    //获取课程总数
    int getCountCourse() throws Exception;

    //根据分页查询课程信息
    List<CourseCustom> findByPaging(Integer toPageNo) throws Exception;
}
