package com.miniproject.demo.Service.Impl;

import com.miniproject.demo.Repository.TransaksiRepository;
import com.miniproject.demo.Service.TransaksiService;
import com.miniproject.demo.model.DetailTransaksi;
import com.miniproject.demo.model.PaketWisata;
import com.miniproject.demo.model.Transaksi;
import com.miniproject.demo.model.Transportasi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransaksiServiceImpl implements TransaksiService {
    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private DetailTransaksiServiceImpl detailTransaksiService;

    @Autowired
    private PaketWisataServiceImpl paketWisataService;

    @Autowired
    private TransportasiServiceImpl transportasiService;

    @Override
    public Transaksi create(AddToTransaksiDto addToTransaksiDto){
        DetailTransaksi detailTransaksi = detailTransaksiService.findById(addToTransaksiDto.getIdDetailTransaksi());
        PaketWisata paketWisata = paketWisataService.findById(addToTransaksiDto.getIdDetailTransaksi());
        Transportasi transportasi = transportasiService.findByIdTransportasi(addToTransaksiDto.getIdDetailTransaksi());

        Transaksi transaksi = new Transaksi();
        transaksi.setDetailTransaksi(detailTransaksi);
        transaksi.setPaketWisata(paketWisata);
        transaksi.setTransportasi(transportasi);
        transaksi.setTanggal(addToTransaksiDto.getTanggal());
    }

}
