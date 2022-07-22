package com.miniproject.demo.Repository;

import com.miniproject.demo.model.PaketWisata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaketWisataRepository extends JpaRepository<PaketWisata, Integer> {
}
