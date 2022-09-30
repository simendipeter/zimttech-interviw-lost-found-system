package com.simendi.interview.zimttech.auditrail;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created on 30/09/2022.
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@Component
public class AppAuditorAware implements AuditorAware<String>, Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3916619591736957909L;

    @Override
    public Optional<String> getCurrentAuditor() {
        String userName;
        try{
            userName = SecurityContextHolder.getContext().getAuthentication().getName();
        }catch (Exception e) {
            userName = "PUBLIC_USER";
        }

        return Optional.of(userName);
    }

}
