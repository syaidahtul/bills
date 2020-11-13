package com.bps.ebill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bps.ebill.models.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, String> {

	@Query("UPDATE Categories SET name = :name, active = :active WHERE code= :code ")
	public void updateByCode(@Param("name") String name, @Param("active") boolean active, @Param("code") String code);

}
