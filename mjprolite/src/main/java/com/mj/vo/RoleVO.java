package com.mj.vo;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO {
	
	private Integer roleId;
	private String roleName;
	private Integer isActive;
	private String createdBy;
	private LocalDate createdAt;
	private String modifiedBy;
	private LocalDate modifiedAt;

}
