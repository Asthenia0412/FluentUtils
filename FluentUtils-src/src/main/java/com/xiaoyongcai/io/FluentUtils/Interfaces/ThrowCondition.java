package com.xiaoyongcai.io.FluentUtils.Interfaces;

@FunctionalInterface
public interface ThrowCondition<T,E extends Throwable> {
    void handle() throws E;
}
