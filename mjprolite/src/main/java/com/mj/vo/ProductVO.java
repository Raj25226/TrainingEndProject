package com.mj.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	
	private Integer productId;
	private String productName;
	private String productCode;
	private String description;
	private String specification;
	private Integer isActive;
	private String createdBy;
	private LocalDate createdAt;
	private String modifiedBy;
	private LocalDate modifiedAt;
	private CategoryVO category;
//	private List<ManufacturerVO> manufacturer;
}
