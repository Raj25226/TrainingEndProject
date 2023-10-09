package com.mj.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="manufacturer")
public class ManufacturerEntity {
	
	@Id
	@Column(name="manufacturer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer manufacturerId;
	@Column(name = "manufacturer_name")
	private String manufacturerName;
	@Column(name="is_active")
	private Integer isActive;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name="created_at")
	private LocalDate createdAt;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_at")
	private LocalDate modifiedAt;
}
