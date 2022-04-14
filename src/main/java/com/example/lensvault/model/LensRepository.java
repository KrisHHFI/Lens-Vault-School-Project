package com.example.lensvault.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Hidden methods are imported and utilized from Crud
public interface LensRepository extends CrudRepository<Lens, Long> {
	List<Lens> largestAperture(int largestAperture);
	List<Lens> focalLength(Double focalLength);
}
