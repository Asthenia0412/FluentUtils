package com.xiaoyongcai.io.FluentUtils.Interfaces;

@FunctionalInterface
public interface IfCondition<T> {
    void then(Runnable action);
}
