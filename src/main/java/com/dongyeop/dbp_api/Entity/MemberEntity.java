package com.dongyeop.dbp_api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String userNickname;

    @Column
    private String userEmail;

    @Column
    private String userPassword;

    @Column
    private String userGender;

    @OneToMany
    @JoinColumn(name = "userCheckbox", nullable = true)
    private List<MemberCheckboxValueEntity> memberCheckboxValueEntityList;
}
