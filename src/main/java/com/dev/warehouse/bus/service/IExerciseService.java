package com.dev.warehouse.bus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dev.warehouse.bus.entity.Exercise;

public interface IExerciseService extends IService<Exercise> {

	void delExercisesByStudyScheduleId(Integer studyScheduleId);

}
