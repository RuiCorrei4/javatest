package com.exemple.restserver.CustomAnotatins;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.exemple.restserver.Model.Financing;

public class MultiploValidation implements ConstraintValidator<Multiplo, Financing> {

    @Override
    public boolean isValid(Financing calculo, ConstraintValidatorContext constraintValidatorContext) {
        if (calculo.getFinanciamneto() == 0 && calculo.getA() > 48)
            return false;  
        return calculo.getA() % 12 == 0;
    }

    @Override
    public void initialize(Multiplo constraintAnnotation) {

    }
}
