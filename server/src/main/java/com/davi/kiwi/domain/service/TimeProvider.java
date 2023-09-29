package com.davi.kiwi.domain.service;

public interface TimeProvider {
    long currentTimestampMillis();
    long daysToMillis(long days);
}
