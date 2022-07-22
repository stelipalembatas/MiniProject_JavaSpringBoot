package com.miniproject.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transportasi")
public class Transportasi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nama_Transportasi", length = 50)
    private String namaTransportasi;

    @Column(name = "Tipe_Transportasi", length = 25)
    private String tipeTransportasi;

    @Column(name = "Harga", precision = 25, scale = 2)
    private BigDecimal harga;

}