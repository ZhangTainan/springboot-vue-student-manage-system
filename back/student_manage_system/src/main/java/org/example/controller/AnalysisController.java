package org.example.controller;

import com.google.gson.Gson;
import io.swagger.annotations.Api;
import org.example.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(tags = "数据分析接口")
@SuppressWarnings("all")
@CrossOrigin("*")
@RestController
public class AnalysisController {
    Gson gson = new Gson();
    @Autowired
    private StudentMapper studentMapper;

    // 查询各科平均分
    @GetMapping("average_score")
    public String average() {
        HashMap<String, Long> avg = studentMapper.getAvg();
        return gson.toJson(avg);
    }

    // 分组查询各个生源地的人数
    @GetMapping("get_place_count")
    public String getPlaceCount() {
        List<HashMap<String, Integer>> placeCount = studentMapper.getPlaceCount();
        return gson.toJson(placeCount);
    }
}
