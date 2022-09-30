package com.simendi.interview.zimttech.mapper;

import com.simendi.interview.zimttech.dao.RoleDAO;
import com.simendi.interview.zimttech.dto.RequestLostItemDTO;
import com.simendi.interview.zimttech.dto.RequestRegistrationDTO;
import com.simendi.interview.zimttech.exception.DAOException;
import com.simendi.interview.zimttech.model.Item;
import com.simendi.interview.zimttech.model.Role;
import com.simendi.interview.zimttech.model.User;
import com.simendi.interview.zimttech.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.simendi.interview.zimttech.statval.Constants.RoleCode.ADMIN;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@Service
public class ItemMapper implements Converter<RequestLostItemDTO, Item> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemMapper.class);

    /**
     * <ol>
     *     <li>
     *         User will be set as ADMIN by Default
     *     </li>
     *     <li>
     *         Password will be equal with first name
     *     </li>
     * </ol>
     * @param source
     * @return
     */
    @Override
    public Item convert(RequestLostItemDTO source) {
        Item item = new Item();
        item.setDate(source.getDate());
        item.setDescription(source.getDescription());
        item.setProvince(source.getProvince);

        return item;
    }
}
