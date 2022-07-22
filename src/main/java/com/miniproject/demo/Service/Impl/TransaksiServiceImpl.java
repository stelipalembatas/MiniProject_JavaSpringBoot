package com.miniproject.demo.Service.Impl;

import com.miniproject.demo.DTO.TransaksiDTO;
import com.miniproject.demo.Repository.TransaksiRepository;
import com.miniproject.demo.Service.TransaksiService;
import com.miniproject.demo.model.Transaksi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransaksiServiceImpl implements TransaksiService {
    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private PaketWisataServiceImpl paketWisataService;

    @Autowired
    private TransportasiServiceImpl transportasiService;

    @Autowired
    private DetailTransaksiServiceImpl detailTransaksiService;

    @Override
    public Transaksi create(TransaksiDTO transaksiDTO) {
        Transaksi transaksi = new Transaksi();
        transaksi.setTanggal(transaksiDTO.getTanggal());
        return transaksiRepository.save(transaksi);
    }

    @Override
    public List<Transaksi> findAll() {
        return (List<Transaksi>) transaksiRepository.findAll();
    }

    @Override
    public Transaksi findById(Integer id) {
        return transaksiRepository.findById(id).orElse(null);
    }

    public Transaksi update(Integer id, Transaksi transaksi) {
        Optional<Transaksi> optionalTransaksi = transaksiRepository.findById(id);
        if (optionalTransaksi.isEmpty()) {
            log.warn("Cannot update Transaksi with {} because not found", id);
            return null;
        }
        Transaksi transaksiById = optionalTransaksi.get();
        transaksiById.setTanggal(transaksi.getTanggal());
        return transaksiRepository.save(transaksiById);
    }

        @Override
        public void delete (Integer id){
            transaksiRepository.deleteById(id);
        }

    }
