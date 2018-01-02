package cn.et.lesson03.resultMap.anno;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import cn.et.lesson03.resultMap.xml.Student;

public interface StudentMapper {
	
    public List<Student> queryAllStudent();
    
    @Results({
    	@Result(property="grade",column="gid",one=@One(select="cn.et.lesson03.resultMap.anno.GradeMapper.queryGradeBy"))
    })
    @Select("select * from student where sid=#{0}")
    public Student queryStudent(String sid);
    
    @Select("select * from student where sid=#{0}")
    public Student queryStudentBy(String sid);
    
    @Select("select * from student where gid=#{0}")
    public List<Student> queryStudentByGId(String gid);
}
