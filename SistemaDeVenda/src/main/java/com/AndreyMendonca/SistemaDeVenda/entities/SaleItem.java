package com.AndreyMendonca.SistemaDeVenda.entities;

import java.io.Serializable;
import java.util.Objects;

import com.AndreyMendonca.SistemaDeVenda.entities.pk.SaleItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_sale_item")
public class SaleItem implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SaleItemPK id = new SaleItemPK();
	
	private Integer quantity;
	private Double price;
	
	public SaleItem() {
		
	}

	public SaleItem(Sale sale, Product product, Integer quantity, Double price) {
		super();
		id.setSale(sale);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore
	public Sale getSale() {
		return id.getSale();
	}
	public void setSale(Sale sale) {
		id.setSale(sale);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleItem other = (SaleItem) obj;
		return Objects.equals(id, other.id);
	}
	
}

