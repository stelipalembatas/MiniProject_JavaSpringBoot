package com.miniproject.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "detail_transaksi")
public class DetailTransaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Transaksi")
    private Transaksi transaksi;

    @Column(name = "Jumlah_Penumpang")
    private Integer jumlahPenumpang;

    @Column(name = "Jumlah_Hari")
    private Integer jumlahHari;

    @Column(name = "Harga", precision = 25, scale = 2)
    private BigDecimal harga;
}