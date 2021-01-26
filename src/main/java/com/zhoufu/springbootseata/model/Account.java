package com.zhoufu.springbootseata.model;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
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
    private Integer balance;

    /**
     * 
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}