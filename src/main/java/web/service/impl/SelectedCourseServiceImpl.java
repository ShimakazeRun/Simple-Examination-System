package web.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mapper.SelectedcourseMapper;
import web.mapper.StudentMapper;
import web.po.*;
import web.service.SelectedCourseService;

import java.util.List;

@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {

    @Autowired
    private SelectedcourseMapper selectedcourseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public SelectedCourseCustom findOne(SelectedCourseCustom selectedCourseCustom) throws Exception {

        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);

        if (list.size() > 0) {
            SelectedCourseCustom scc = new SelectedCourseCustom();
            BeanUtils.copyProperties(list.get(0), scc);

            Student student = studentMapper.selectByPrimaryKey(selectedCourseCustom.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            return scc;
        }

        return null;
    }

    @Override
    public void save(SelectedCourseCustom selectedCourseCustom) throws Exception {
       selectedcourseMapper.insert(selectedCourseCustom);
    }

    @Override
    public void remove(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        selectedcourseMapper.deleteByExample(example);
    }
}
