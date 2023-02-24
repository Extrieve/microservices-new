package com.extrieve.inventoryservice;

import com.extrieve.inventoryservice.model.Inventory;
import com.extrieve.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(InventoryRepository inventoryRepository) {
		return args -> {
			inventoryRepository.save(
					Inventory.builder()
							.skuCode("SKU-001")
							.quantity(10)
							.build()
			);
			inventoryRepository.save(
					Inventory.builder()
							.skuCode("SKU-002")
							.quantity(20)
							.build()
			);
			inventoryRepository.save(
					Inventory.builder()
							.skuCode("SKU-003")
							.quantity(30)
							.build()
			);
		};
	}
}
