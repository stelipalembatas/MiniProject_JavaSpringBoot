package com.miniproject.demo.Repository;

import com.miniproject.demo.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
}
