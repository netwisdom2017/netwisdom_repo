package com.dev.warehouse.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dev.warehouse.bus.entity.Exercise;
import com.dev.warehouse.bus.mapper.ExerciseMapper;
import com.dev.warehouse.bus.service.IExerciseService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExerciseServiceImpl extends ServiceImpl<ExerciseMapper, Exercise> implements IExerciseService {

	@Override
	public void delExercisesByStudyScheduleId(Integer studyScheduleId) {
		this.getBaseMapper().delExercisesByStudyScheduleId(studyScheduleId);
	}

}
