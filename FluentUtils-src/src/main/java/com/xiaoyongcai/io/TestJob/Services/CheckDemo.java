package com.xiaoyongcai.io.TestJob.Services;

import com.xiaoyongcai.io.FluentUtils.Tools.Check;
import com.xiaoyongcai.io.TestJob.Pojo.User;

import java.util.*;

public class CheckDemo {

    public static void main(String[] args) {
        CheckDemo demo = new CheckDemo();
        demo.demoBasicChecks();
        demo.demoObjectChecks();
        demo.demoStringChecks();
        demo.demoCollectionChecks();
        demo.demoMapChecks();
        demo.demoNumberChecks();
        demo.demoBooleanChecks();
        demo.demoComplexScenario();
    }

    private void demoBasicChecks() {
        System.out.println("\n=== 基础条件检查演示 ===");

        // that() 方法
        User user = new User("john_doe", "P@ssw0rd", "john@example.com");
        Check.that(user, u -> u.getUsername().length() >= 5)
                .then(() -> System.out.println("用户名长度有效"));

        // either() 方法
        Check.either(user, u -> u.getEmail().contains("@"))
                .then(() -> System.out.println("邮箱格式正确"))
                .otherwise(() -> System.out.println("邮箱格式错误"));

        // throwing() 方法
        try {
            Check.throwing(user, u -> u.getPassword().length() < 8,
                            () -> new IllegalArgumentException("密码太短"));
        } catch (IllegalArgumentException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }

    private void demoObjectChecks() {
        System.out.println("\n=== 对象检查演示 ===");

        User nullUser = null;
        User existingUser = new User();

        // isNull()
        Check.isNull(nullUser).then(() -> System.out.println("用户对象为null"));

        // nonNull()
        Check.nonNull(existingUser).then(() -> System.out.println("用户对象不为null"));
    }

    private void demoStringChecks() {
        System.out.println("\n=== 字符串检查演示 ===");

        String emptyStr = "";
        String blankStr = "   ";
        String validStr = "Hello";

        // isEmpty()
        Check.isEmpty(emptyStr).then(() -> System.out.println("字符串为空"));

        // isBlank()
        Check.isBlank(blankStr).then(() -> System.out.println("字符串为空白"));

        // equalsIgnoreCase()
        Check.equalsIgnoreCase(validStr, "HELLO")
                .then(() -> System.out.println("字符串匹配(忽略大小写)"));
    }

    private void demoCollectionChecks() {
        System.out.println("\n=== 集合检查演示 ===");

        List<String> emptyList = new ArrayList<>();
        List<String> roles = Arrays.asList("ADMIN", "USER");

        // isEmpty()
        Check.isEmpty(emptyList).then(() -> System.out.println("集合为空"));

        // contains()
        Check.contains(roles, "ADMIN")
                .then(() -> System.out.println("集合包含ADMIN角色"));
    }

    private void demoMapChecks() {
        System.out.println("\n=== Map检查演示 ===");

        Map<String, String> emptyMap = new HashMap<>();
        Map<String, String> userPrefs = new HashMap<>();
        userPrefs.put("theme", "dark");

        // isEmpty()
        Check.isEmpty(emptyMap).then(() -> System.out.println("Map为空"));

        // containsKey()
        Check.containsKey(userPrefs, "theme")
                .then(() -> System.out.println("Map包含theme键"));
    }

    private void demoNumberChecks() {
        System.out.println("\n=== 数值检查演示 ===");

        Integer positiveNum = 10;
        Double negativeNum = -5.5;

        // isPositive()
        Check.isPositive(positiveNum)
                .then(() -> System.out.println("数字为正数"));

        // isNegative()
        Check.isNegative(negativeNum)
                .then(() -> System.out.println("数字为负数"));
    }

    private void demoBooleanChecks() {
        System.out.println("\n=== 布尔检查演示 ===");

        Boolean trueValue = true;
        Boolean falseValue = false;

        // isTrue()
        Check.isTrue(trueValue)
                .then(() -> System.out.println("布尔值为true"));

        // isFalse()
        Check.isFalse(falseValue)
                .then(() -> System.out.println("布尔值为false"));
    }

    private void demoComplexScenario() {
        System.out.println("\n=== 复杂场景演示 ===");

        User user = new User();
        user.setUsername("admin");
        user.setPassword("Admin@1234");
        user.setAge(25);
        user.setActive(true);
        user.setRoles(Arrays.asList("ADMIN", "USER"));

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("language", "zh-CN");
        prefs.put("notifications", "enabled");
        user.setPreferences(prefs);

        // 组合检查 - 修正版
        Check.nonNull(user).then(() -> {
            // 用户名检查
            Check.either(user.getUsername(), u -> u == null || u.trim().isEmpty())
                    .then(() -> System.out.println("警告: 用户名为空"))
                    .otherwise(() -> {
                        Check.that(user.getUsername(), u -> u.length() < 6)
                                .then(() -> System.out.println("警告: 用户名太短"));
                    });

            // 用户激活状态检查
            Check.isTrue(user.isActive()).then(() -> {
                Check.contains(user.getRoles(), "ADMIN")
                        .then(() -> System.out.println("管理员用户已激活"));
            });

            // 用户偏好设置检查
            Check.containsKey(user.getPreferences(), "language").then(() -> {
                String lang = (String) user.getPreferences().get("language");
                Check.equalsIgnoreCase(lang, "zh-CN")
                        .then(() -> System.out.println("用户偏好中文界面"));
            });
        });
    }
}