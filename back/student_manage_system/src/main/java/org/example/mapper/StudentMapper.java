package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    @Select("select avg(chi) chi,avg(math) math,avg(eng) eng from student;")
    public HashMap<String,Long> getAvg();
    @Select("select place name,count(place) value from student group by place;")
    public List<HashMap<String,Integer>> getPlaceCount();
}
