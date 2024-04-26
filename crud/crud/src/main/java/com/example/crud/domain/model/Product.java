package com.example.crud.domain.model;


import com.example.crud.api.dtos.request.RequestProductDTOPost;
import jakarta.persistence.*;
import lombok.*;

//define que eh uma tabela e o nome dela (mesma coisa pra entidade)
@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// considerar apenas o atributo "id" da classe para realizar as comparações e cálculos.
@EqualsAndHashCode(of = "id")
public class Product {

    //define que eh um id e gera o valor dele por UUID
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private float price_in_cents;

    public Product(RequestProductDTOPost requestProduct) {
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }
}
