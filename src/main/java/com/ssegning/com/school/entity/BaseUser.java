package com.ssegning.com.school.entity;

import com.ssegning.com.school.converter.CUIDConverter;
import io.github.thibaultmeyer.cuid.CUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

// TODO
@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@IdClass(BaseUser.PK.class)
public abstract class BaseUser implements Serializable {

    @Id
    private CUID id;

    @CreatedDate
    @Column(name = "creation_date")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @CreatedBy
    @Column(name = "creation_by")
    private String creationBy;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @NotNull
    @Column(columnDefinition = "text")
    private String name;

    @NotNull
    @Column(columnDefinition = "text")
    private String password;

    @Data
    public static class PK implements Serializable {
        @Column
        @Convert(converter = CUIDConverter.class)
        @GeneratedValue(generator = "cuid-generator")
        @GenericGenerator(name = "cuid-generator",
                strategy = "com.ssegning.com.school.service.CuidGenerator"
        )
        private CUID id;
    }
}
