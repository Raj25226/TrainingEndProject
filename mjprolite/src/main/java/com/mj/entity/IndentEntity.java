package com.mj.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="indent")
public class IndentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="indent_id")
	private Integer indentId;
	@Column(name="indent_code")
	private String indentCode;
	@Column(name="unit_price",length=11,precision=2)
	private Double unitPrice;
	@Column(name="total_price",length=11,precision=2)
	private Double totalPrice;
	private Integer quantity;
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
	@OneToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;
	@ManyToOne
	@JoinColumn(name="indent_header_id")
	private IndentHeaderEntity indentHeaderEntity;
}
