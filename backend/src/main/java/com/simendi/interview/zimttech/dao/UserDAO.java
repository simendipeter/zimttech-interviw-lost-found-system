package com.simendi.interview.zimttech.dao;

import com.simendi.interview.zimttech.exception.DAOException;
import com.simendi.interview.zimttech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public interface UserDAO extends JpaRepository<User, Long> {

    User findByMobileNumber(String p_MobileNumber) throws DAOException;

    User findByEmail(String p_Email) throws DAOException;

    User findByCodeAndStatus(String p_Code, Boolean p_Status)throws DAOException;

    User findByCodeOrEmail(String p_Code, String p_Email) throws DAOException;
}
