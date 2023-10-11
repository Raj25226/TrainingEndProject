package com.mj.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UOMVO {
	
	private Integer uomId;
	private String unit;
	private Integer isActive;
	private String createdBy;
	private LocalDate createdAt;
	private String modifiedBy;
	private LocalDate modifiedAt;	
	private List<CategoryVO> category;
	
}
