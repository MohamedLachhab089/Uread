package com.med.uread.Entities;

import com.med.uread.Common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feedback extends BaseEntity {

    private int note;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
