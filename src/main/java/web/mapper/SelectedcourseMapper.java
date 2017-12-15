package web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import web.po.Selectedcourse;
import web.po.SelectedcourseExample;

public interface SelectedcourseMapper {
    int countByExample(SelectedcourseExample example);

    int deleteByExample(SelectedcourseExample example);

    int insert(Selectedcourse record);

    int insertSelective(Selectedcourse record);

    List<Selectedcourse> selectByExample(SelectedcourseExample example);

    int updateByExampleSelective(@Param("record") Selectedcourse record, @Param("example") SelectedcourseExample example);

    int updateByExample(@Param("record") Selectedcourse record, @Param("example") SelectedcourseExample example);
}