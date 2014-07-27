package com.meena.pizzashop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by meena on 20/7/14.
 */
@Entity
public class Image implements Serializable {
    @Id
    @GeneratedValue
    //(generator = "ID_GENERATOR")
    protected Long id;
}
