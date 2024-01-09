package com.example.restfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password","ssn"})
@Schema(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    @Schema(title="사용자 아이디", description = "사용자 ID는 자동 생성됩니다")
    private Integer id;

    @Schema(title="사용자 이름", description = "사용자 이름을 입력합니다")
    @Size(min = 2, message = "Name은 2글자 이상 입력해주세요")
    private String name;

    @Schema(title="사용자 등록일", description = "사용자 등록일을 입력합니다. 입력하지않으면 현재 날짜가 지정됩니다.")
    @Past(message = "등록일은 미래날짜를 작성할 수 없습니다.")
    private Date joinDate;

    @Schema(title = "사용자 비밀번호") // JsonIgnoreProperties로 인해 swagger에 보이지 않음
//    @JsonIgnore
    private String password;

    @Schema(title = "사용자 주민번호")
//    @JsonIgnore
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(Integer id, String name, Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }
}
