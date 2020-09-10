package com.microservice.forex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * We are extending JpaRepository using two generics - ExchangeValue & Long. 
 * ExchangeValue is the entity that is being managed and the primary key of ExchangeValue is Long.
 * 
 * @author kanja
 *
 */
@Repository
public interface ExchangeValueRepository extends 
    JpaRepository<ExchangeValue, Long>{
  ExchangeValue findByFromAndTo(String from, String to);
}