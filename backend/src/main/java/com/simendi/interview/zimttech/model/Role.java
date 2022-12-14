package com.simendi.interview.zimttech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simendi.interview.zimttech.auditrail.AAuditTrail;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@Where(clause = "status=true")
@Getter
@Setter
@Entity
@Table(name = "sec_role")
public class Role extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5906359157470193026L;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
