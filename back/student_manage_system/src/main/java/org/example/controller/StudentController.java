package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import org.example.mapper.StudentMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(tags = "学生信息接口")
@CrossOrigin("*")
@SuppressWarnings("all")
@RestController
public class StudentController {
    Gson gson = new Gson();
    @Autowired
    private StudentMapper studentMapper;

    // 分页查询学生
    @PostMapping("/students")
    public String getStudent(@RequestBody HashMap<String, Integer> data) {
        int page = data.get("page");
        int numberPerPage = data.get("number_per_page");
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.last(String.format("limit %s,%s", page * numberPerPage - numberPerPage, numberPerPage));
        List<Student> students = studentMapper.selectList(studentQueryWrapper);
        return gson.toJson(students);
    }

    // 获取学生总数
    @GetMapping("/get_students_count")
    public long getStudentCount() {
        Long count = studentMapper.selectCount(null);
        return count;
    }

    // 添加学生
    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentMapper.insert(student);
    }

    // 删除学生
    @PostMapping("/delete")
    public void deleteStudent(@RequestBody Student student) {
        studentMapper.deleteById(student);
    }

    // 修改学生信息
    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentMapper.updateById(student);
    }

    // 根据姓名模糊查询学生
    @PostMapping("/search")
    public String searchStudent(@RequestBody Student student) {
        String name = student.getName();
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.like("name", name);
        List<Student> students = studentMapper.selectList(studentQueryWrapper);
        return gson.toJson(students);
    }


}
