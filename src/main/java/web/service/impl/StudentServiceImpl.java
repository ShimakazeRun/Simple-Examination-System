package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mapper.StudentCustomMapper;
import web.po.SelectedCourseCustom;
import web.po.StudentCustom;
import web.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentCustomMapper studentCustomMapper;

    @Override
    public StudentCustom findStudentAndSelectedCourseListByName(String name) throws Exception {

        StudentCustom studentCustom = studentCustomMapper.findStudentAndSelectedCourseListById(Integer.parseInt(name));

        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        int selectedCourseAmount;
        int overCourseAmount = 0;

        //判断课程是否修完
        for (SelectedCourseCustom s : list) {
            if (s.getMark() != null) {
                s.setOver(true);
                overCourseAmount++;
            }
        }

        selectedCourseAmount = list.size() - overCourseAmount;

        studentCustom.setSelectedCourseAmount(selectedCourseAmount);
        studentCustom.setOverCourseAmount(overCourseAmount);

        return studentCustom;
    }
}
