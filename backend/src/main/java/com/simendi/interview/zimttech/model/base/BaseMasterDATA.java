package com.simendi.interview.zimttech.model.base;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 * @param <KEY>
 */
@Getter
@Setter
@MappedSuperclass
public class BaseMasterDATA<KEY extends Serializable> implements SingleKeyDATA<KEY>, Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -81861420500108351L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id", nullable = false)
    private KEY id;

    @Column(name = "code", length = 50, unique = true, nullable = false)
    @NotNull(message = "Code Field of Entity is Required")
    @Size(max = 50)
    private String code;

    @Size(max = 50)
    @NotNull(message = "Name Field of Entity is Required")
    @Column(name = "name", length = 50)
    private String name;

    @Column(name= "status", nullable = false)
    protected Boolean status;

    @Size(max = 256)
    @Column(name= "remarks", length=256)
    protected String remarks;

    @Override
    public KEY getId() {
        return id;
    }
}