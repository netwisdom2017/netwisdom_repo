package com.dev.warehouse.bus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 项目名称：shop-entity 
 * 类名称：Exercise 
 * 类描述：問題
 * 2020-05-30 修改备注：
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exercise")
@ToString
public class Exercise implements Serializable {
	
	private static final long serialVersionUID=1L;
	/*問題ID	
	 * 			
	 */
	@TableId(value = "exercise_id", type = IdType.AUTO)
	private Integer exerciseId;
	/*問題类型
	 * 			
	 */
	private Integer exerciseType;
	/*学習進捗ID	
	 * 			
	 */  
	private Integer studyScheduleId;
	/*問題内容	
	 * 			
	 */  
	private String exerciseContent;
	/*選択肢A
	 * 			
	 */  
	private String answerA;
	/*選択肢B
	 * 			
	 */  
	private String answerB;
	/*選択肢C
	 * 			
	 */  
	private String answerC;
	/*選択肢D
	 * 			
	 */  
	private String answerD;
	/*正解
	 * 			
	 */  
	private String correctAnswer;
	/*解析
	 * 			
	 */  
	private String alalyze;

}
