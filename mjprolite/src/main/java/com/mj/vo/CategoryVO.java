package com.mj.vo;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVO {	

	private Integer categoryId;	 
	private String categoryName;	 
	private String categoryCode;	 
	private Integer isActive;	
	private String createdBy;	 
	private LocalDate createdAt;	 
	private String modifiedBy;	 
	private LocalDate modifiedAt;
	
}
