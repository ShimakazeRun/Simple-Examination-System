package web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import web.po.College;
import web.po.CollegeExample;

public interface CollegeMapper {
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(Integer collegeid);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    College selectByPrimaryKey(Integer collegeid);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}