package com.miniproject.demo.Service;

import com.miniproject.demo.model.DetailTransaksi;

import java.util.List;

public interface DetailTransaksiService {
    DetailTransaksi create(DetailTransaksi detailTransaksi);
    List<DetailTransaksi> findAll();
    DetailTransaksi findByIdDetTransaksi(Integer id);
    DetailTransaksi update(Integer id, DetailTransaksi detailTransaksi);
    void delete(Integer id);
    DetailTransaksi updateDetTransaksi(Integer id, DetailTransaksi detail);

    void deleteDetTransaksi(Integer id);
}
