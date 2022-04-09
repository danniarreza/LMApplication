package nl.utwente.LMApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.utwente.LMApplication.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    
}
