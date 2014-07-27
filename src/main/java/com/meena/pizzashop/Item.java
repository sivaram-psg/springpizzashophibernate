package com.meena.pizzashop;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item")
@org.hibernate.annotations.GenericGenerator(
        name = "test-native-strategy",
        strategy = "native")
public class Item implements Serializable {

    public void setId(Long id) {
        this.id = id;
    }

    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   // @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @Version
    protected long version;

  //  @NotNull
    protected String name;

  /*  @ElementCollection
    @CollectionTable(name = "IMAGE")
    protected Set<Image> images = new HashSet<Image>();*/

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Long getId() { // Optional but useful
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 /*   public Set<Image> getImages() {
        return images;
    }*/

    // If you want to put this in a Set when it's in detached state, you
    // have to override equals/hashCode!
}