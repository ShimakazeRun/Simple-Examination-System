package web.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mapper.CollegeMapper;
import web.mapper.CourseCustomMapper;
import web.mapper.CourseMapper;
import web.po.*;
import web.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private CourseCustomMapper courseCustomMapper;

    @Override
    public List<CourseCustom> findByName(String name) throws Exception {
        CourseExample courseExample = new CourseExample();

        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoursenameLike("%" + name + "%");

        List<Course> list = courseMapper.selectByExample(courseExample);

        List<CourseCustom> courseCustomList = null;

        if (list != null) {
            courseCustomList = new ArrayList<CourseCustom>();
            for (Course c : list) {
                CourseCustom courseCustom = new CourseCustom();
                //类拷贝
                BeanUtils.copyProperties(c, courseCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(c.getCollegeid());
                courseCustom.setCollegeName(college.getCollegename());

                courseCustomList.add(courseCustom);
            }
        }

        return courseCustomList;
    }

    @Override
    public int getCountCourse() throws Exception {
        CourseExample courseExample = new CourseExample();

        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoursenameIsNotNull();

        return courseMapper.countByExample(courseExample);
    }

    @Override
    public List<CourseCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        return courseCustomMapper.findByPaging(pagingVO);
    }
}
