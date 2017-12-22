package io.pivotal.workshop.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import io.pivotal.workshop.ShopService;
import io.pivotal.workshop.exception.ShopNotFound;
import io.pivotal.workshop.model.Shop;
 
@Service
public class ShopServiceImpl implements ShopService {
     
    @Resource
    private io.pivotal.workshop.dao.ShopRepository shopRepository;
    
    @Autowired
    JpaTransactionManager txnManager;
 
    @Override
    @Transactional(isolation=Isolation.READ_COMMITTED)
    public Shop create(Shop shop) {
    	/**** A sample code for writing sql queries*****/
    	EntityManager entityManager = txnManager.getEntityManagerFactory().createEntityManager();
    	List<Object> list = entityManager.createQuery("from Employee").getResultList();
    	entityManager.getCriteriaBuilder().createQuery().getRestriction().isNotNull().alias("");
    	/*****Not a valid query, need to comment this code while execution**************/
        Shop createdShop = shop;//RestTemplate
        return shopRepository.save(createdShop);
    }
     
    @Override
    @Transactional
    public Shop findById(int id) {
        return shopRepository.findOne(id);
    }
 
    @Override
    @Transactional(rollbackFor=ShopNotFound.class,isolation=Isolation.SERIALIZABLE)
    public Shop delete(int id) throws ShopNotFound {
        Shop deletedShop = shopRepository.findOne(id);
        
        if (deletedShop == null)
            throw new ShopNotFound();
         
        shopRepository.delete(deletedShop);
        return deletedShop;
    }
 
    @Override
    @Transactional
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
 
    @Override
    @Transactional(rollbackFor=ShopNotFound.class)
    public Shop update(Shop shop) throws ShopNotFound {
        Shop updatedShop = shopRepository.findOne(shop.getId());
        //JpaTransactionObject txObject = new JpaTransactionObject(); 
        if (updatedShop == null)
            throw new ShopNotFound();
         
        updatedShop.setName(shop.getName());
        updatedShop.setEmplNumber(shop.getEmplNumber());
        return updatedShop;
    }
 
}
