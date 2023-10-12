package com.mj.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class ProductEntity {

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_code")
	private String productCode;
	private String description;
	private String specification;
	@Column(name="is_active")
	private Integer isActive;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_at")
	private LocalDate createdAt;
	@Column(name="modified_by")
	private String modifiedBy;
	@Column(name="modified_at")
	private LocalDate modifiedAt;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoryEntity category;
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//			  name = "product_manufacturer",
//			  joinColumns = @JoinColumn(name = "product_id"),
//			  inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
//	private List<ManufacturerEntity> manufacturer;
	
}
