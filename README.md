# Fluent-Check 工具库

一个采用 Fluent 风格的条件检查工具库，为 Java 提供清晰可读的验证和条件逻辑处理方式。

## 功能特性

- **流式 API** - 支持链式方法调用，使条件检查代码更易读
- **全面检查** - 包含空值检查、字符串验证、集合操作等多种验证
- **异常处理** - 内置支持在条件失败时抛出异常
- **类型安全** - 泛型实现，适用于任何 Java 类型
- **轻量级** - 无外部依赖

快速开始

```java
// 基本检查
Check.nonNull(user).then(() -> System.out.println("用户不为空"));

// 字符串检查
Check.isBlank(username).then(() -> throw new IllegalArgumentException("用户名不能为空"));

// 条件分支
Check.either(user, u -> u.isActive())
    .then(() -> System.out.println("用户已激活"))
    .otherwise(() -> System.out.println("用户未激活"));
```

## 核心方法

### 基础检查

- `that(T, Predicate)` - 自定义条件检查
- `either(T, Predicate)` - 带分支的条件检查
- `throwing(T, Predicate, Supplier)` - 条件失败时抛出异常

### 常用检查

- **对象检查**: `isNull()`, `nonNull()`
- **字符串检查**: `isEmpty()`, `isBlank()`, `equalsIgnoreCase()`
- **集合检查**: `isEmpty()`, `contains()`
- **Map检查**: `isEmpty()`, `containsKey()`
- **数值检查**: `isPositive()`, `isNegative()`
- **布尔检查**: `isTrue()`, `isFalse()`

## 使用示例

```java
// 用户注册验证
public void register(User user) {
    Check.nonNull(user).then(() -> {
        Check.isBlank(user.getUsername())
            .then(() -> throw new IllegalArgumentException("用户名不能为空"));
            
        Check.that(user.getPassword(), p -> p.length() < 8)
            .then(() -> throw new IllegalArgumentException("密码长度至少8位"));
    });
}

// 产品库存检查
public void checkInventory(Product product) {
    Check.isPositive(product.getStock())
        .then(() -> System.out.println("库存充足"))
        .otherwise(() -> System.out.println("库存不足"));
}
```

## 最佳实践

1. **参数验证** - 在方法开头验证输入参数
2. **业务规则检查** - 用流式语法清晰表达业务规则
3. **异常处理** - 使用 `throwing()` 方法统一处理验证失败
4. **组合检查** - 嵌套多个检查构建复杂验证逻辑

## 贡献指南

欢迎提交 Issue 和 Pull Request。提交代码前请确保:

1. 通过所有单元测试
2. 遵循现有代码风格
3. 为新功能添加测试用例

## 许可证

Apache License 2.0
