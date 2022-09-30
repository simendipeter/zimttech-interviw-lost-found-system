package com.simendi.interview.zimttech.dao;

import com.simendi.interview.zimttech.exception.DAOException;
import com.simendi.interview.zimttech.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public interface RoleDAO extends JpaRepository<Role, Long> {

    Role findByName(String p_Name) throws DAOException;

    Role findByCode(String p_Code) throws DAOException;
}
