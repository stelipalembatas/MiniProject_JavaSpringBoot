package com.miniproject.demo.DTO;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NotNull
public class TransaksiDTO implements Serializable {

        private Integer id;
        private Integer idUser;
        private Integer idPaket_Wisata;
        private Integer idTransportasi;
        private OffsetDateTime tanggal;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;


}
