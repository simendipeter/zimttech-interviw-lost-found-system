package com.simendi.interview.zimttech.statval;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public interface Constants {

    interface Bean {
        String REGISTRATION_VALIDATOR = "bean-registration-validator";
        String LOST_ITEM_VALIDATOR = "bean-lost-item-validator";
    }

    interface Path {
        String REGISTRATION = "/registration";
        String LOGIN = "/login";
        String REGISTER = "/register";
        String DASHBOARD = "/api/dashboard";
    }

    interface RoleCode {
        String ADMIN = "ROLE_ADMIN";
    }

    interface RoleName {
        String ADMIN = "ADMIN";
    }
}
