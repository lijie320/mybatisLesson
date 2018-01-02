package cn.et.lesson03.resultMap.xml;

import java.util.List;

public interface StudentMapper {
    public List<Student> queryAllStudent();
    
    public Student queryStudent(String sid);
}
