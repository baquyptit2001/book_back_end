package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    // user_id relation to User. One User may have many books
    @ManyToOne
    private User user;
    private String author;
    private String edition;
    private UUID isbn = UUID.randomUUID();
}
