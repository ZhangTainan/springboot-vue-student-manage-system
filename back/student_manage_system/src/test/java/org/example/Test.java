package org.example;

import org.example.mapper.StudentMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.Student;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class Test {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @org.junit.jupiter.api.Test
    public void testUser(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::print);
    }
    public void testStudent(){
        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::print);
    }
}
