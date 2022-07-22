package com.miniproject.demo.Service.Impl;

import com.miniproject.demo.DTO.DetailTransaksiDTO;
import com.miniproject.demo.Repository.DetailTransaksiRepository;
import com.miniproject.demo.Service.DetailTransaksiService;
import com.miniproject.demo.model.DetailTransaksi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DetailTransaksiServiceImpl implements DetailTransaksiService {
    @Autowired
    private DetailTransaksiRepository detailTransaksiRepository;

    @Autowired
    private TransaksiServiceImpl transaksiService;

    @Override
    public DetailTransaksi create(DetailTransaksiDTO detailTransaksiDTO){
        DetailTransaksi detailTransaksi = new DetailTransaksi();
        detailTransaksi.setJumlahPenumpang(detailTransaksiDTO.getJumlahPenumpang());
        detailTransaksi.setJumlahHari(detailTransaksiDTO.getJumlahHari());
        detailTransaksi.setHarga(detailTransaksiDTO.getHarga());
        return detailTransaksiRepository.save(detailTransaksi);
    }

    @Override
    public List<DetailTransaksi> findAll(){
        return (List<DetailTransaksi>) detailTransaksiRepository.findAll();
    }

    @Override
    public DetailTransaksi findByIdDetTransaksi(Integer id){
        return detailTransaksiRepository.findById(id).orElse(null);
    }

    @Override
    public DetailTransaksi update(Integer id, DetailTransaksi detailTransaksi) {
        Optional<DetailTransaksi> optionalDetailTransaksi = detailTransaksiRepository.findById(id);
        if (optionalDetailTransaksi.isEmpty()){
            log.warn("Cannot update with {} because not found", id);
            return null;
        }
        DetailTransaksi detailTransaksiById = optionalDetailTransaksi.get();
        detailTransaksiById.setJumlahPenumpang(detailTransaksi.getJumlahPenumpang());
        detailTransaksiById.setJumlahHari(detailTransaksi.getJumlahHari());
        detailTransaksiById.setHarga(detailTransaksi.getHarga());
        return detailTransaksiRepository.save(detailTransaksiById);
    }

    @Override
    public void delete(Integer id) {
        detailTransaksiRepository.deleteById(id);
    }

}
