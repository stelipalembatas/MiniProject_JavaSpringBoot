package com.miniproject.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "detail_transaksi")
public class DetailTransaksi {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Transaksi", nullable = false)
    private Transaksi idTransaksi;

    @Column(name = "Jumlah_Penumpang")
    private Integer jumlahPenumpang;

    @Column(name = "Jumlah_Hari")
    private Integer jumlahHari;

    @Column(name = "Harga", precision = 25, scale = 2)
    private BigDecimal harga;

    @Column(name = "Created_at")
    private Instant createdAt;

    @Column(name = "Updated_at")
    private Instant updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transaksi getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Transaksi idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Integer getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public void setJumlahPenumpang(Integer jumlahPenumpang) {
        this.jumlahPenumpang = jumlahPenumpang;
    }

    public Integer getJumlahHari() {
        return jumlahHari;
    }

    public void setJumlahHari(Integer jumlahHari) {
        this.jumlahHari = jumlahHari;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}