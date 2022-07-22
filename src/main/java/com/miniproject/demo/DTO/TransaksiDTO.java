package com.miniproject.demo.DTO;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.OffsetDateTime;

@Data
public class TransaksiDTO {
        private Integer id;
        private Integer idPaket_Wisata;
        private Integer idTransportasi;
        private OffsetDateTime tanggal;

}
