package cn.et.lesson03.resultMap.anno;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.et.lesson03.resultMap.xml.Grade;

public interface GradeMapper {
    public List<Grade> queryAllGrade();
    
    @Results({@Result(property="gname1",column="gname"),
    	    @Result(column="gid",javaType=ArrayList.class,property="studentList",many=@Many(select="cn.et.lesson03.resultMap.anno.StudentMapper.queryStudentByGId"))
    	})
    @Select("select * from grade where gid=#{0}")
    public Grade queryGrade(String gid);
    
    @Results(@Result(property="gname1",column="gname"))
    @Select("select * from grade where gid=#{0}")
    public Grade queryGradeBy(String gid);
}
