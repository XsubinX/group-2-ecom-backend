package edu.semo.cs533.bx1.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EcomUser {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
}