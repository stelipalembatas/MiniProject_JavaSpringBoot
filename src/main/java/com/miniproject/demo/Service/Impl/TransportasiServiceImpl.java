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

    public Transportasi createTransportasi(Transportasi transportasi) {
        return transportasiRepository.save(transportasi);
    }

    public List<Transportasi> findAllTransportasi() {
        return (List<Transportasi>) transportasiRepository.findAll();
    }

    public Transportasi findByIdTransportasi(Integer id) {
        Optional<Transportasi> optionalTransportasi = transportasiRepository.findById(id);
        if (optionalTransportasi.isEmpty()) {
            log.warn("Cannot find Transportasi with {} because not found", id);
            return null;
        }
        return optionalTransportasi.get();
    }

    public Transportasi updateTransportasi(Integer id, Transportasi transportasi) {
        Optional<Transportasi> optionalTransportasi = transportasiRepository.findById(id);
        if (optionalTransportasi.isEmpty()){
            log.warn("Cannot update Transportasi with {} because not found", id);
            return null;
        }
        Transportasi transportasiById = optionalTransportasi.get();
        transportasiById.setNamaTransportasi(transportasi.getNamaTransportasi());
        transportasiById.setTipeTransportasi(transportasi.getTipeTransportasi());
        return transportasiRepository.save(transportasiById);
    }

    public void deleteTransportasi(Integer id) {
        transportasiRepository.deleteById(id);
    }
}
