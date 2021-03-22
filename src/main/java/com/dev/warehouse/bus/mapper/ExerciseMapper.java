package com.dev.warehouse.bus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dev.warehouse.bus.entity.Exercise;

public interface ExerciseMapper extends BaseMapper<Exercise> {

	void delExercisesByStudyScheduleId(Integer studyScheduleId);
}
