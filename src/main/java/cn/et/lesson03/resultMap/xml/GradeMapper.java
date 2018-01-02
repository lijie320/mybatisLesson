package cn.et.lesson03.resultMap.xml;

import java.util.List;

public interface GradeMapper {
    public List<Grade> queryAllGrade();
    
    public Grade queryGrade(String gid);
}
