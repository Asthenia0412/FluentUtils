package com.xiaoyongcai.io.FluentUtils.Tools;

import com.xiaoyongcai.io.FluentUtils.Interfaces.IfCondition;
import com.xiaoyongcai.io.FluentUtils.Interfaces.IfElseCondition;
import com.xiaoyongcai.io.FluentUtils.Interfaces.ThrowCondition;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 条件检查工具类 - Fluent风格API
 */
public final class Check {

    private Check() {} // 工具类不可实例化

    // ========== 基础条件检查 ==========

    /**
     * 基础IF条件检查
     */
    public static <T> IfCondition<T> that(T target, Predicate<T> condition) {
        return action -> {
            if (condition.test(target)) {
                action.run();
            }
        };
    }

    /**
     * 基础IF-ELSE条件检查
     */
    public static <T> IfElseCondition<T> either(T target, Predicate<T> condition) {
        return action -> elseAction -> {
            if (condition.test(target)) {
                action.run();
            } else {
                elseAction.run();
            }
        };
    }

    /**
     * 基础异常抛出条件检查
     */
    public static <T, E extends Throwable> ThrowCondition<T, E> throwing(
            T target, Predicate<T> condition, Supplier<E> exceptionSupplier) {
        return () -> {
            if (condition.test(target)) {
                throw exceptionSupplier.get();
            }
        };
    }

    // ========== 常用条件预设 ==========

    // 对象检查
    public static <T> IfCondition<T> isNull(T target) {
        return that(target, t -> t == null);
    }

    public static <T> IfCondition<T> nonNull(T target) {
        return that(target, t -> t != null);
    }

    // 字符串检查
    public static IfCondition<String> isEmpty(String target) {
        return that(target, s -> s == null || s.isEmpty());
    }

    public static IfCondition<String> isBlank(String target) {
        return that(target, s -> s == null || s.trim().isEmpty());
    }

    public static IfCondition<String> equalsIgnoreCase(String target, String other) {
        return that(target, s -> s != null && s.equalsIgnoreCase(other));
    }

    // 集合检查
    public static <T> IfCondition<Collection<T>> isEmpty(Collection<T> target) {
        return that(target, c -> c == null || c.isEmpty());
    }

    public static <T> IfCondition<Collection<T>> contains(Collection<T> target, T element) {
        return that(target, c -> c != null && c.contains(element));
    }

    // Map检查
    public static <K, V> IfCondition<Map<K, V>> isEmpty(Map<K, V> target) {
        return that(target, m -> m == null || m.isEmpty());
    }

    public static <K, V> IfCondition<Map<K, V>> containsKey(Map<K, V> target, K key) {
        return that(target, m -> m != null && m.containsKey(key));
    }

    // 数值检查
    public static IfCondition<Number> isPositive(Number target) {
        return that(target, n -> n != null && n.doubleValue() > 0);
    }

    public static IfCondition<Number> isNegative(Number target) {
        return that(target, n -> n != null && n.doubleValue() < 0);
    }

    // 布尔检查
    public static IfCondition<Boolean> isTrue(Boolean target) {
        return that(target, b -> b != null && b);
    }

    public static IfCondition<Boolean> isFalse(Boolean target) {
        return that(target, b -> b != null && !b);
    }
}