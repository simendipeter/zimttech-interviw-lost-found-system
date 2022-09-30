package com.simendi.interview.zimttech.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public class DateUtil {

    public static SimpleDateFormat BirthDateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    public static Date addNYearToDate(int n, Date p_PrevDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(p_PrevDate);
        c.add(Calendar.YEAR, n);
        return c.getTime();
    }
}
