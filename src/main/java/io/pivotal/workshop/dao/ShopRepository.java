package io.pivotal.workshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pivotal.workshop.model.Shop;


public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
