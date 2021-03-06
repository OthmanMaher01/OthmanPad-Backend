package com.example.othmanpad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Role {
    @Id
    @SequenceGenerator(
            name="role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    private Long roleId;
    private String roleName;
}
