package com.miniproject.demo.Repository;

import com.miniproject.demo.model.Transportasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportasiRepository extends JpaRepository<Transportasi, Integer> {
}
