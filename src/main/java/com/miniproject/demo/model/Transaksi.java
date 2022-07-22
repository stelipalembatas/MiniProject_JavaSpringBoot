package com.miniproject.demo.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "transaksi")
public class Transaksi {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_User", nullable = false)
    private User idUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Paket_Wisata", nullable = false)
    private PaketWisata idPaketWisata;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Transportasi", nullable = false)
    private Transportasi idTransportasi;

    @Column(name = "Tanggal")
    private Instant tanggal;

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

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public PaketWisata getIdPaketWisata() {
        return idPaketWisata;
    }

    public void setIdPaketWisata(PaketWisata idPaketWisata) {
        this.idPaketWisata = idPaketWisata;
    }

    public Transportasi getIdTransportasi() {
        return idTransportasi;
    }

    public void setIdTransportasi(Transportasi idTransportasi) {
        this.idTransportasi = idTransportasi;
    }

    public Instant getTanggal() {
        return tanggal;
    }

    public void setTanggal(Instant tanggal) {
        this.tanggal = tanggal;
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