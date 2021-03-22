package com.dev.warehouse.bus.exercise.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dev.warehouse.bus.entity.Exercise;
import com.dev.warehouse.bus.service.IExerciseService;
import com.dev.warehouse.bus.vo.ExerciseVo;
import com.dev.warehouse.response.ResponseBean;

@RestController
@RequestMapping("/student")
public class ExerciseApi {
	
    @Autowired
    private IExerciseService exerciseService;
    
    /**
     * 学習進捗IDを利用、解析情報を作成する
     * @param exerciseVo
     * @return
     */
    @RequestMapping("loadAnalyseByStudyScheduleIdForApp")
    public ResponseBean loadAnalyseByStudyScheduleIdForApp(@RequestBody ExerciseVo exerciseVo){
        QueryWrapper<Exercise> queryWrapper = new QueryWrapper<Exercise>();
        queryWrapper.eq("study_schedule_id", exerciseVo.getStudyScheduleId());
        queryWrapper.orderByAsc("exercise_type");
        List<Exercise> exercisesList = exerciseService.list(queryWrapper);
        //学生作答
        List<String> studentAnswers = new ArrayList<String>();
        return new ResponseBean(200, "检索成功", exercisesList, studentAnswers);
    }
}

