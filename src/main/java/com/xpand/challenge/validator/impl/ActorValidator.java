package com.xpand.challenge.validator.impl;

import com.xpand.challenge.dto.ActorDTO;
import com.xpand.challenge.validator.Validator;

import java.util.Optional;

public class ActorValidator implements Validator<ActorDTO> {

    @Override
    public void validate(ActorDTO actor) {
        Optional.ofNullable(actor.getName())
            .map(String::trim)
            .filter(name -> !name.isEmpty())
            .orElseThrow(() -> new IllegalArgumentException("Name must not be empty"));

        Optional.ofNullable(actor.getGender())
            .filter(gender -> gender.equalsIgnoreCase("Male")
                    || gender.equalsIgnoreCase("Female"))
            .orElseThrow(() -> new IllegalArgumentException("Gender must be Male or Female"));

        Optional.ofNullable(actor.getBirthDate())
            .orElseThrow(() -> new IllegalArgumentException("Date must not be empty"));

    }

}
