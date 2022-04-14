package com.example.lensvault.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Hidden methods are imported and utilised from Crud
public interface PrimeOrZoomRepository extends CrudRepository<PrimeOrZoom, Long> {
	 List<PrimeOrZoom> findByName(String name);
}