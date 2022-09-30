package com.simendi.interview.zimttech.model;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Where(clause = "status=true")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sec_item")
public class Item {

    @Column(name = "id")
    private String id;

    @Column(name = "item_description")
    private String firstName;

    @Column(name = "date")
    private Date date;

    @Column(name = "province")
    private String province
            ;
}
