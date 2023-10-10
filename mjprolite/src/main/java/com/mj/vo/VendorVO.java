package com.mj.vo;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorVO {
	
	private Integer vendorId;
	private String vendorName;
	private String phoneNumber;
	private String gst;
	private String email;
	private String pan;
	private Double turnover;
	private Integer isActive;
	private String createdBy;
	private LocalDate createdAt;
	private String modifiedBy;
	private LocalDate modifiedAt;
	private UserVO user;

}
