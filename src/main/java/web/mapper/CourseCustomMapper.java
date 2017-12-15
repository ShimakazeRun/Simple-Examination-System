package web.mapper;

import web.po.CourseCustom;
import web.po.PagingVO;

import java.util.List;

public interface CourseCustomMapper {

    //分页查询学生信息
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;
}
