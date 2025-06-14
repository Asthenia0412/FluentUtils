package com.xiaoyongcai.io.FluentUtils.Interfaces;
@FunctionalInterface
public interface OtherwiseCondition<T> {
    void otherwise(Runnable action);
}
