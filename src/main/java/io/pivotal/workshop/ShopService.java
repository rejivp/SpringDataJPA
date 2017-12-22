package io.pivotal.workshop;

import java.util.List;

import io.pivotal.workshop.exception.ShopNotFound;
import io.pivotal.workshop.model.Shop;

public interface ShopService {
    
    public Shop create(Shop shop);
    public Shop delete(int id) throws ShopNotFound;
    public List<Shop> findAll();
    public Shop update(Shop shop) throws ShopNotFound;
    public Shop findById(int id);
 
}
