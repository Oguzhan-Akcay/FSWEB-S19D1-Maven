package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vegetable", schema = "public")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;

    /*public void setGrownOnTree(Boolean grownOnTree) {
        isGrownOnTree = grownOnTree;
    }

    public Boolean isGrownOnTree() {
        return isGrownOnTree;
    }*/

}
