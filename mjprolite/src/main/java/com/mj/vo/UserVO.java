package com.mj.vo;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	
	private Integer userId;
	private String userName;
	private String password;
	private Integer isActive;
	private String createdBy;
	private LocalDate createdAt;
	private String modifiedBy;
	private LocalDate modifiedAt;
	private RoleVO role;

}
