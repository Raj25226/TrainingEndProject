package com.mj.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ManufacturerVO {

	private Integer manufacturerId;
	private String manufacturerName;
	private Integer isActive;
	private String createdBy;
	private LocalDate createdAt;
	private String modifiedBy;
	private LocalDate modifiedAt;
	
}
