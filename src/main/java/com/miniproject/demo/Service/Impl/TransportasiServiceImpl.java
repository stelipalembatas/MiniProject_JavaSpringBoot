package com.miniproject.demo.Service.Impl;

import com.miniproject.demo.Repository.TransportasiRepository;
import com.miniproject.demo.model.Transportasi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransportasiServiceImpl {
    @Autowired
    private TransportasiRepository transportasiRepository;

    @Autowired
    private Transportasi createTransportasi(Transportasi transportasi){
        return transportasiRepository.save(transportasi);
    }

    @Override
    public List<Transportasi> findAllTransportasi(){
        return (List<Transportasi>) transportasiRepository.findAll();
    }

    @Override
    public Transportasi findByIdTransportasi(Integer id){
        Optional<Transportasi> optionalTransportasi = transportasiRepository.findById(id);
        if (optionalTransportasi.isEmpty()){
            log.warn("Cannot find transportasi with {}", id);
            return null;
        }
        return optionalTransportasi.get();
    }

    @Override
    public Transportasi updateTransportasi(Integer id, Transportasi transportasi){
        Optional<Transportasi> optionalTransportasi = transportasiRepository.findById(id);
        if (optionalTransportasi.isEmpty()){
            log.warn("Cannot update transportasi with {}", id);
            return null;
        }
        Transportasi transportasiById = optionalTransportasi.get();
        transportasiById.setNama(transportasi.getNama());
        return transportasiRepository.save(transportasiById);
    }

    @Override
    public void deleteTransportasi(Integer id){
        transportasiRepository.deleteById(id);
    }
}
