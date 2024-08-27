package org.example.photogram_re.domain.user;

//  JPA-Java persistence API (자바로 데이터를 영구적으로 저장(DB)할 수 있는 API를 제공

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 DB를 따라감
    private Long id;

    private String username;
    private String password;

    private String name;
    private String website;
    private String bio; // 자기 소개
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl; // 사진
    private String role; // 권한

    private LocalDateTime createdDate;

    @PrePersist
    public void createdDate() {
        this.createdDate = LocalDateTime.now();
    }

}
