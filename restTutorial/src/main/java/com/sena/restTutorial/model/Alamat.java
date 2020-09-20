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
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "alamat")
@EntityListeners(AuditingEntityListener.class)
public class Alamat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "jalan", nullable = false)
    private String jalan;

    @Column(name = "kota", nullable = false)
    private String kota;

    @Column(name = "provinsi", nullable = false)
    private String provinsi;

    @Column(name = "kode_pos", nullable = false)
    private int kodePos;

    @JsonIgnore
    @OneToOne(mappedBy = "alamat")
    private CoffeShop coffeShop;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;


}
