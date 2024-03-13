package com.ssegning.com.school.service;

import io.github.thibaultmeyer.cuid.CUID;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

// TODO
@Slf4j
public class CuidGenerator implements IdentifierGenerator {
    @Override
    public CUID generate(SharedSessionContractImplementor session, Object object) {
        return CUID.randomCUID2(32);
    }
}
