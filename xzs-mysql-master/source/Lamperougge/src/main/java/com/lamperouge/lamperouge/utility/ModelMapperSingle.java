package com.lamperouge.lamperouge.utility;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


/**
 * @author nmj
 * @create 2022-01-24 18:39
 */
public class ModelMapperSingle {

    protected final static ModelMapper modelMapper = new ModelMapper();
    private final static ModelMapperSingle modelMapperSingle = new ModelMapperSingle();

    static {
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static ModelMapper Instance() {
        return modelMapperSingle.modelMapper;
    }
}
