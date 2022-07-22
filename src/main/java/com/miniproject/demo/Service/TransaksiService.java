package com.miniproject.demo.Service;

import com.miniproject.demo.DTO.TransaksiDTO;
import com.miniproject.demo.model.Transaksi;
import io.swagger.models.auth.In;

import java.util.List;

public interface TransaksiService {
    Transaksi create(TransaksiDTO transaksiDTO);
    List<Transaksi> findAll();
    Transaksi findById(Integer id);
    Transaksi update(Integer id, Transaksi transaksi);
    void delete(Integer id);
}
