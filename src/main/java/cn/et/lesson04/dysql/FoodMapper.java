package cn.et.lesson04.dysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.et.lesson02.annotion.Food;

public interface FoodMapper {
    public List queryFood(@Param("foodname") String foodname);
    
	public List queryFoodName(@Param("foodname") String foodname);
}
