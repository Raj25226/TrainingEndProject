package com.mj.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndentVO {
	
	private Integer indentId;
	private String indentCode;
	private Double unitPrice;
	private Double totalPrice;
	private Integer quantity;
	private Integer isActive;
	private String createdBy;
	private LocalDate createdAt;
	private String modifiedBy;
	private LocalDate modifiedAt;
	private ProductVO product;
	private IndentHeaderVO indentHeaderVO;

}
