package com.miniproject.demo.Service.Impl;


import com.miniproject.demo.Repository.PaketWisataRepository;
import com.miniproject.demo.Service.PaketWisataService;
import com.miniproject.demo.model.PaketWisata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaketWisataServiceImpl implements PaketWisataService {
    @Autowired
    private PaketWisataRepository paketWisataRepository;

    @Override
    public PaketWisata create(PaketWisata paketWisata){
        return paketWisataRepository.save(paketWisata);
    }

    @Override
    public List<PaketWisata> findAll(){
        return (List<PaketWisata>) paketWisataRepository.findAll();
    }

    @Override
    public PaketWisata findById(Integer id){
        Optional<PaketWisata> optionalPaketWisata = paketWisataRepository.findById(id);
        if (optionalPaketWisata.isEmpty()){
            log.warn("Cannot find paket wisata with {} because not found", id);
            return null;
        }
        return optionalPaketWisata.get();
    }

    @Override
    public PaketWisata update(Integer id, PaketWisata paketWisata){
        Optional<PaketWisata> optionalPaketWisata = paketWisataRepository.findById(id);
        if (optionalPaketWisata.isEmpty()){
            log.warn("Cannot find paket wisata with {} because not found", id);
            return null;
        }
        PaketWisata paketById = optionalPaketWisata.get();
        paketById.setNamaPaketWisata(paketWisata.getNamaPaketWisata());
        paketById.setLokasiPaketWisata(paketWisata.getLokasiPaketWisata());
        return paketWisataRepository.save(paketById);
        }

        @Override
    public void delete(Integer id){
        paketWisataRepository.deleteById(id);
    }
}
