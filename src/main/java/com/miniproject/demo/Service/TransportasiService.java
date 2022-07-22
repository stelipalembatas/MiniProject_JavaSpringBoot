package com.miniproject.demo.Service;

import com.miniproject.demo.model.Transportasi;
import io.swagger.models.auth.In;

import java.util.List;

public interface TransportasiService {
    Transportasi createTransportasi(Transportasi transportasi);
    List<Transportasi> findAllTransportasi();
    Transportasi findByIdTransportasi(Integer id);
    Transportasi updateTransportasi(Integer id, Transportasi transportasi);
    void deleteTransportasi(Integer id);
}
