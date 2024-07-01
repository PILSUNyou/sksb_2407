package com.example.sksb.damain.member.entity;

import ch.qos.logback.classic.spi.ConfiguratorRank;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 생성자가 있는 것과 없는 것을 protected로 생성
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class) // import를 자동 생성
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    private String username;

    private String password;

    // 사용자의 권한을 간단하게 설정할 때
    public List<String> getAuthoritiesAsStringList() {
        return List.of("ROLE_MEMBER");
    }
}
