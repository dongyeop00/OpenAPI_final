package com.dongyeop.dbp_api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "MemberCheckboxValueEntity")
public class MemberCheckboxValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private MemberEntity member;
}
