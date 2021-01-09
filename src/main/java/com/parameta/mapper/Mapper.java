package com.parameta.mapper;

import javax.xml.datatype.DatatypeConfigurationException;

public interface Mapper<E,S> {

    public S map(E entry) throws DatatypeConfigurationException;

}
