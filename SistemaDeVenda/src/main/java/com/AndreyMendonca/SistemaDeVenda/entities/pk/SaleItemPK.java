package com.AndreyMendonca.SistemaDeVenda.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.AndreyMendonca.SistemaDeVenda.entities.Product;
import com.AndreyMendonca.SistemaDeVenda.entities.Sale;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SaleItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="sale_id")
	private Sale sale;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(product, sale);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleItemPK other = (SaleItemPK) obj;
		return Objects.equals(product, other.product) && Objects.equals(sale, other.sale);
	}
}
