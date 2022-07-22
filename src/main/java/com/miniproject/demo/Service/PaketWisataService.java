package com.miniproject.demo.Service;

import com.miniproject.demo.model.PaketWisata;

import java.util.List;

public interface PaketWisataService {

    PaketWisata create(PaketWisata paketWisata);
    List<PaketWisata> findAll();
    PaketWisata findById(Integer id);
    PaketWisata update(Integer id, PaketWisata paketWisata);
    void delete(Integer id);
}
