package com.miniproject.demo.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetailTransaksiDTO {
    private Integer idTransaksi;
    private Integer jumlahPenumpang;
    private Integer jumlahHari;
    private BigDecimal harga;
}
