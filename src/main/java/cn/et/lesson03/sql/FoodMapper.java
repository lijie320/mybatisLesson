package cn.et.lesson03.sql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.et.lesson02.annotion.Food;

public interface FoodMapper {
    
	public List queryFoodName(@Param("foodname") String foodname);
}
