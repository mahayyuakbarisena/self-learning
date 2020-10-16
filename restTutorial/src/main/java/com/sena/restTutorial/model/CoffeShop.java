package com.sena.restTutorial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "coffeshop")
@EntityListeners(AuditingEntityListener.class)
public class CoffeShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @OneToOne
    @JoinColumn(name = "alamat_id")
    private Alamat alamat;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pemilik_id")
    private Pemilik pemilik;

    @Column(name = "tgl_terbentuk", nullable = false)
    private LocalDate tglTerbentuk;

    @Column(name = "jum_produk", nullable = false)
    private Integer jumProduk;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;
}
