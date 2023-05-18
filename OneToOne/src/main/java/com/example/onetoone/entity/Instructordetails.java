package com.example.onetoone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Instructordetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String youtubeChannel;
    private String hobby;

//     @OneToOne(mappedBy = "instructordetails",cascade =CascadeType.ALL )
//      private Instructor instructor;
//}
}
