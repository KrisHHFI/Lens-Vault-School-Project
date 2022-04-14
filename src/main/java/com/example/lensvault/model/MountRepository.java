package com.example.lensvault.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Hidden methods are imported and utilised from Crud
public interface MountRepository extends CrudRepository<Mount, Long> {
	 List<Mount> findByName(String name);
}