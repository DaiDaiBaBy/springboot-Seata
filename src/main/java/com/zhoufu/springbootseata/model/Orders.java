package com.zhoufu.springbootseata.model;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer productId;

    /**
     * 
     */
    private Integer payAmount;

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