package com.simendi.interview.zimttech.dao;

import com.simendi.interview.zimttech.exception.DAOException;
import com.simendi.interview.zimttech.model.Item;
import com.simendi.interview.zimttech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public interface ItemDAO extends JpaRepository<Item, Long> {

    Item findById(String id) throws DAOException;
}
