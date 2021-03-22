package com.dev.warehouse.bus.vo;

import java.util.List;

import com.dev.warehouse.bus.entity.Exercise;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExerciseVo extends Exercise {
	/**
	 * 分页参数，当前是第一页，每页10条数据
	 */
	private Integer page = 1;
	private Integer limit = 10;

	/**
	 * 削除用問題複数ID
	 */
	private Integer[] ids;
	
	/**
	 * 生成填空题的位置
	 */
	private List<Integer> positions;
	
	private int exerciseNum;
	
	private String correctFlg;
	
	private Integer studentId;
}