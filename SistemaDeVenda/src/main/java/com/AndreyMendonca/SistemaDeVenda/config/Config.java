package com.AndreyMendonca.SistemaDeVenda.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.AndreyMendonca.SistemaDeVenda.entities.Category;
import com.AndreyMendonca.SistemaDeVenda.entities.Client;
import com.AndreyMendonca.SistemaDeVenda.entities.Payment;
import com.AndreyMendonca.SistemaDeVenda.entities.Product;
import com.AndreyMendonca.SistemaDeVenda.entities.Sale;
import com.AndreyMendonca.SistemaDeVenda.entities.SaleItem;
import com.AndreyMendonca.SistemaDeVenda.repositories.CategoryRepository;
import com.AndreyMendonca.SistemaDeVenda.repositories.ClientRepository;
import com.AndreyMendonca.SistemaDeVenda.repositories.ProductRepository;
import com.AndreyMendonca.SistemaDeVenda.repositories.SaleItemRepository;
import com.AndreyMendonca.SistemaDeVenda.repositories.SaleRepository;

@Configuration
public class Config implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics","Electronics");
		Category cat2 = new Category(null, "Books","Books");
		Category cat3 = new Category(null, "Computers","Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Client u1 = new Client(null,"Maria Brown","5251515","18996698229","maria@gmail.com", Instant.now());
		Client u2 = new Client(null, "Alex Green","51161515","189926514", "alex@gmail.com", Instant.now()); 
		
		Sale o1 = new Sale(null, Instant.parse("2019-06-20T19:53:07Z"),u1);
		Sale o2 = new Sale(null, Instant.parse("2019-07-21T03:42:10Z"),u2);
		Sale o3 = new Sale(null, Instant.parse("2019-07-22T15:21:22Z"),u1);
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, 1,cat2);
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, 2,cat1);
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0,3,cat3);
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, 4,cat3);
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99,5,cat1);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		clientRepository.saveAll(Arrays.asList(u1,u2));
		saleRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		SaleItem oi1 = new SaleItem(o1, p1, 2, p1.getPrice());
		SaleItem oi2 = new SaleItem(o1, p3, 1, p3.getPrice());
		SaleItem oi3 = new SaleItem(o2, p3, 2, p3.getPrice());
		SaleItem oi4 = new SaleItem(o3, p5, 2, p5.getPrice());
		
		saleItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay = new Payment(null, "Credito");
		o1.setPayment(pay);
		
		saleRepository.save(o1);
		
	}

}
