package com.miniproject.demo.Service.Impl;

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

    @Override
    public DetailTransaksi create(DetailTransaksi detailTransaksi){
        return detailTransaksiRepository.save(detailTransaksi);
    }

    @Override
    public List<DetailTransaksi> findAll(){
        return (List<DetailTransaksi>) detailTransaksiRepository.findAll();
    }

    @Override
    public DetailTransaksi findByIdDetTransaksi(Integer id){
        Optional<DetailTransaksi> optionalDetailTransaksi = detailTransaksiRepository.findById(id);
        if (optionalDetailTransaksi.isEmpty()){
            log.warn("Cannot find detail transaksi with {} because not found", id);
            return null;
        }
        return optionalDetailTransaksi.get();
    }

    @Override
    public DetailTransaksi update(Integer id, DetailTransaksi detailTransaksi) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        detailTransaksiRepository.deleteById(id);
    }

    @Override
    public DetailTransaksi updateDetTransaksi(Integer id, DetailTransaksi detail){
        Optional<DetailTransaksi> optionalDetailTransaksi = detailTransaksiRepository.findById(id);
        if (optionalDetailTransaksi.isEmpty()){
            log.warn("Cannot update Detail Transaksi with {} because not found", id);
            return null;
        }
        DetailTransaksi detailById = optionalDetailTransaksi.get();
        detailById.setId(detail.getId());
        detailById.setIdTransaksi(detail.getIdTransaksi());
        detailById.setJumlahPenumpang(detail.getJumlahPenumpang());
        detailById.setJumlahHari(detail.getJumlahHari());
        detailById.setHarga(detail.getHarga());
        detailById.setCreatedAt(detail.getCreatedAt());
        detailById.setUpdatedAt(detail.getUpdatedAt());
        return detailTransaksiRepository.save(detailById);
    }

    @Override
    public void deleteDetTransaksi(Integer id){
        detailTransaksiRepository.deleteById(id);
    }
}
