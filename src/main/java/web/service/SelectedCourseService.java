package web.service;

import web.po.SelectedCourseCustom;

public interface SelectedCourseService {

    //查询指定学生成绩
    SelectedCourseCustom findOne(SelectedCourseCustom selectedCourseCustom) throws Exception;

    //选课
    void save(SelectedCourseCustom selectedCourseCustom) throws Exception;

    //退课
    void remove(SelectedCourseCustom selectedCourseCustom) throws Exception;
}
