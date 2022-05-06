package br.twoModels.projectRelationshipTwoModels.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String serialNumber;

    public Cart(Integer id, String serial){
        this.id = id;
        this.serialNumber = serial;
    }

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "cart_item")
    @JsonManagedReference
    private List<Item> cart_items = new ArrayList<>();

    public void addItem(Item item){
        this.cart_items.add(item);
    }

    public void removeItem(Item item){
        this.cart_items.remove(item);
    }
}
