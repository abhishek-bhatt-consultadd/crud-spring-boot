package com.example.crud.crud_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Medicine")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String company;

}