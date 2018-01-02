package cn.et.lesson02.annotion;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface FoodMapper {
	
	@Select("select * from FOOD where foodname=#{foodname}")
    public List<Map> queryFood(@Param("foodname") String foodname);
	
	@Select("select * from FOOD where foodname like '%${foodname}%'")
	public List<Food> queryFoodName(@Param("foodname") String foodname);
    
	@Delete("delete from food where foodid=#{0}")
    public void deleteFood(String foodid);
	
	@SelectKey(before=true,keyProperty="foodid",resultType=int.class,statement="select FOOD_SEC.Nextval from dual")
	@Insert("insert into food values(#{foodid},#{foodname},#{price})")
	public void saveFood(Food food);
}
