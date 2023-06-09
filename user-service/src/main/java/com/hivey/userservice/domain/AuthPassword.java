package com.hivey.userservice.domain;

import com.hivey.userservice.global.common.BaseTime;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 기본 로그인 비밀번호
 * - Entity 완료
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "auth_password")
@Entity
public class AuthPassword extends BaseTime {

    @Id
    @Column(name = "security_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "password")
    private String password;

    @Builder
    public AuthPassword(User user, String password) {
        this.user = user;
        this.password = password;
    }
}
