package com.zucc.lamperouge.viewmodel;

import com.zucc.lamperouge.utility.ModelMapperSingle;
import org.modelmapper.ModelMapper;

public class BaseVM {
    protected static ModelMapper modelMapper = ModelMapperSingle.Instance();


    public static ModelMapper getModelMapper() {
        return modelMapper;
    }

    public static void setModelMapper(ModelMapper modelMapper) {
        BaseVM.modelMapper = modelMapper;
    }
}
