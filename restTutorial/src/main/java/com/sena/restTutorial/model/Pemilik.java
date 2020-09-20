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
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "pemilik")
@EntityListeners(AuditingEntityListener.class)
public class Pemilik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama_depan", nullable = false)
    private String namaDepan;

    @Column(name = "nama_belakang", nullable = false)
    private String namaBelakang;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "npwp", nullable = false)
    private String npwp;

    @JsonIgnore
    @OneToMany(mappedBy = "pemilik")
    private List<CoffeShop> daftarCoffeShop;

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
