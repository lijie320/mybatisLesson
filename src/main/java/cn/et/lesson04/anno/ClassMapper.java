package cn.et.lesson04.anno;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

public interface ClassMapper {
	
	 static class classSql{
		public String classAnSql(Map map) {
			Class cla = (Class) map.get("cla");
			String sql = "select * from class where 1=1";
			if (cla.getCname() != null && !"".equals(cla.getCname())) {
				cla.setCname("%" + cla.getCname() + "%");
				sql += " and cname like #{cla.cname}";
			}
			return sql;
		}

		public String classAnSql1(Map map) {
			Class cla = (Class) map.get("cla");
			SQL sql = new SQL();
			sql.SELECT("*").FROM("class");
			if (cla.getCname() != null && !"".equals(cla.getCname())) {
				cla.setCname("%" + cla.getCname() + "%");
				sql.WHERE("cname like #{cla.cname}");
			}
			if (cla.getCaddress() != null && !"".equals(cla.getCaddress())) {
				cla.setCaddress("%" + cla.getCaddress() + "%");
				sql.AND();
				sql.WHERE("caddress like #{cla.caddress}");
			}
			return sql.toString();
		}
	 }
	
	@SelectProvider(type=classSql.class, method = "classAnSql1")
    public List<Class> queryClass(@Param("cla")Class cla);
    
    public List<Class> queryClass1(Class cla);
      
    public List<Class> querySex(@Param("sex")Integer sex);
    
    public List<Class> queryClassGid(@Param("classList") List<String> classList);
    
    public void updateClass(Class cla);
    
}
