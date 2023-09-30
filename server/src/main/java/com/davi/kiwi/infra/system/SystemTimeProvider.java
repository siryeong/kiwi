package com.davi.kiwi.infra.system;

import com.davi.kiwi.domain.service.TimeProvider;
import org.springframework.stereotype.Component;

@Component
public class SystemTimeProvider implements TimeProvider {

    @Override
    public long currentTimestampMillis() {
        return System.currentTimeMillis();
    }

}
