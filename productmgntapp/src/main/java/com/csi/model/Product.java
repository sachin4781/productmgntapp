package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue

    private int productid;

    @Size(min = 5,message = "Product Name Shoud Be AtLeast 5 Character..")
    private String productname;

    @Column(unique = true)
    private String productcode;

    private double productprice;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date productlaunchdate;
}
