package com.xiaoyongcai.io.FluentUtils.Interfaces;
@FunctionalInterface
public interface IfElseCondition<T> {
    OtherwiseCondition<T> then(Runnable action);
}
