package cn.et.lesson04.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    public List<Class> queryClass(Class cla);
    
    public List<Class> queryClass1(Class cla);
      
    public List<Class> querySex(@Param("sex")Integer sex);
    
    public List<Class> queryClassGid(@Param("classList") List<String> classList);
    
    public void updateClass(Class cla);
}
