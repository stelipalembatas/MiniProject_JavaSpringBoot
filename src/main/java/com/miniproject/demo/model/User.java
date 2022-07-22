package com.miniproject.demo.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nama", length = 50)
    private String nama;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Password", length = 50)
    private String password;

    @Lob
    @Column(name = "Alamat")
    private String alamat;

    @Column(name = "Jenis_Kelamin", length = 1)
    private String jenisKelamin;

    @Column(name = "No_Telepon")
    private Integer noTelepon;

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Integer getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(Integer noTelepon) {
        this.noTelepon = noTelepon;
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