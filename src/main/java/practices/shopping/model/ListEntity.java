package practices.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "lists")
@AllArgsConstructor
@NoArgsConstructor
@Data
// I recommend renaming this class. List is too broad. GroceryPlan or something.
// Shitf+f6 on class name below and rename, don't forget to rename things like @Table(name = "lists")
public class ListEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column() //something missing in ()?
    private String name;

    // find out why lombok does not work in your workspace
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductsOnList> getProductsOnLists() {
        return productsOnLists;
    }

    public void setProductsOnLists(Set<ProductsOnList> productsOnLists) {
        this.productsOnLists = productsOnLists;
    }

    @OneToMany(mappedBy = "listEntity")
    Set<ProductsOnList> productsOnLists;
}
