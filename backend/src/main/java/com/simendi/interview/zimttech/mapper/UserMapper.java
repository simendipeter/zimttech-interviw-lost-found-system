package com.simendi.interview.zimttech.mapper;

import com.simendi.interview.zimttech.dao.RoleDAO;
import com.simendi.interview.zimttech.dto.RequestRegistrationDTO;
import com.simendi.interview.zimttech.exception.DAOException;
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
public class UserMapper implements Converter<RequestRegistrationDTO, User> {

    @Autowired private RoleDAO roleDAO;
    @Autowired private PasswordEncoder passwordEncoder;
    private static Date CURRENT_DATE = new Date();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapper.class);

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
    public User convert(RequestRegistrationDTO source) {
        User user = new User();
        user.setCode(source.getEmail());
        user.setName(source.getFirstName().concat(" ").concat(source.getLastName()));
        user.setStatus(true);
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setMobileNumber(source.getMobileNumber());
        try {
            user.setDateOfBirth(DateUtil.BirthDateFormatter.parse(source.getDob()));
        } catch (ParseException e) {
            LOGGER.warn("Date is not in valid format {}", e.toString());
        }
        user.setGender(source.getGender());
        user.setEmail(source.getEmail());
        user.setPassword(passwordEncoder.encode(user.getFirstName()));
        user.setEnabled(true);
        user.setExpiredDate(DateUtil.addNYearToDate(1, CURRENT_DATE));
        user.setCredentialsExpiredDate(DateUtil.addNYearToDate(1, CURRENT_DATE));
        user.setNonLocked(true);

        Role role = null;
        try {
            role = roleDAO.findByCode(ADMIN);
        } catch (DAOException e) {
            LOGGER.error("Error find Role By Name {} : {}", ADMIN, e.toString());
        }
        Set<Role> roles = new HashSet<>();
        if (role != null) {
            roles.add(role);
        }
        user.setRoles(roles);
        return user;
    }
}
