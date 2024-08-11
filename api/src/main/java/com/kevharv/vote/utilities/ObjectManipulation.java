package com.kevharv.vote.utilities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectManipulation {

    /*
     * Copies non-null properties from one object to the other. Useful for
     * patching objects in API calls. Allows the specification of only
     * the attributes you wish to change, rather than the entire object.
     */
    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private static String[] getNullPropertyNames(Object src) {
        final BeanWrapper source = new BeanWrapperImpl(src);
        java.beans.PropertyDescriptor[] pds = source.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = source.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
