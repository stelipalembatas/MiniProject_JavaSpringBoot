package com.miniproject.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "paket_wisata")
public class PaketWisata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nama", length = 50)
    private String namaPaketWisata;

    @Column(name = "Lokasi", length = 50)
    private String lokasiPaketWisata;

}