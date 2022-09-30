package com.simendi.interview.zimttech.model.base;

import java.io.Serializable;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public interface SingleKeyDATA<KEY extends Serializable> {

    public KEY getId();

}
