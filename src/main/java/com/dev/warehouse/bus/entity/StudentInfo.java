package com.dev.warehouse.bus.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 项目名称：shop-entity 
 * 类名称：StudentInfo 
 * 类描述：社員
 * 2020-05-24 修改备注：
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("student_info")
@ToString
public class StudentInfo implements Serializable {
	
	private static final long serialVersionUID=1L;
	/*学員ID			
	 * 			
	 */  
	@TableId(value = "student_id", type = IdType.AUTO)
	private Integer studentId;
	/*ユーザー名		
	 * 			
	 */
	private String username;
	/*パスワード			
	 * 			
	 */
	private String password;
	/*ビザ番号			
	 * 			
	 */
	@TableField(updateStrategy = FieldStrategy.IGNORED)
	private String visaNumber;
	/*学員_漢字_姓			
	 * 			
	 */
	private String kanjiFirstname;
	/*学員_漢字_名		
	 * 			
	 */
	private String kanjiLastname;
	/*ｶﾀｶﾅ_姓			
	 * 			
	 */
	private String katakanaFirstname;
	/*ｶﾀｶﾅ_名		
	 * 			
	 */
	private String katakanaLastname;
	/*学員_英語_姓			
	 * 			
	 */
	private String englishFirstname;
	/*学員_英語_名		
	 * 			
	 */
	private String englishLastname;
	/*性别		
	 * 		0:男、 1:女
	 */
	private Integer sex;
	/*生年月日			
	 * 			
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  birthday;
	/*国籍		
	 * 			
	 */
	private Integer nationality;
	/*ビザ種類			
	 * 		1:留学 2:技術・人文知識・国際業務 3:定住者 
            4:永住者 5:高度人材 6:家族滞在 7:経営・管理
	 */
	@TableField(updateStrategy = FieldStrategy.IGNORED)
	private Integer visaType;
	/*ビザ有効月数		
	 * 			
	 */
	@TableField(updateStrategy = FieldStrategy.IGNORED)
	private Integer visaMonths;
	/*ビザ有効期限			
	 * 			
	 */
	@TableField(updateStrategy = FieldStrategy.IGNORED)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  visaExpireDate;
	/*入学日		
	 * 			
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  entryStartDate;
	/*携帯番号			
	 * 			
	 */
	private String tel;
	/*最寄駅		
	 * 			
	 */
	private String closeStation;
	/*住所 			
	 * 			
	 */
	private String address;
	/*卒業学校	
	 * 			
	 */
	private String graduateSchool;
	/*専攻			
	 * 			
	 */
	private String major;
	/*卒業年月		
	 * 			
	 */
	private String graduateYearMonth;
	/*学歴
	 * 	1:日本大学 2:中国大学 3:日本大学院 4:中国専門学校 
        5:日本専門学校 6:中国大学院 7.日本短期大学		
	 */
	private Integer degree;
	/*個人番号		
	 * 			
	 */
	@TableField(updateStrategy = FieldStrategy.IGNORED)
	String myNumber;
	/*パスポート番号	
	 * 			
	 */
	private String passportNumber;
	/*パスポート有効期限		
	 * 			
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  passportExpireDate;
	/*日本語能力試験(1:N1,2:N2,3.N3,4:N4,5:N5,9:なし)
	 * 			
	 */
	private Integer japaneseLevel;
	/*学費(支払予定)	
	 * 			
	 */
	private Integer fee;
	/*学費(支払済)			
	 * 			
	 */
	private Integer paidFee;
	/*備考欄	
	 * 			
	 */
	@TableField(updateStrategy = FieldStrategy.IGNORED)
	private String memo;
	/*在学状況(1:在学中,2:卒業,3:退学)	
	 * 			
	 */
	private Integer studyCondition;
}
