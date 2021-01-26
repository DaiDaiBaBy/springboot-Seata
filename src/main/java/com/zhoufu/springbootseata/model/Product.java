package com.zhoufu.springbootseata.model;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer price;

    /**
     * 
     */
    private Integer stock;

    /**
     * 
     */
    private Date addTime;

    /**
     * 
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}