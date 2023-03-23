package run.faang.school.task_1.battlefield;

import ru.faang.school.task_1.battlefield.Battlefield;

import java.lang.reflect.Method;

public final class BattlefieldReflector {
    protected static Method getDeclaredMethodWithoutArguments(String methodName) throws NoSuchMethodException {
        Method method = Battlefield.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method;
    }

    protected static Method getDeclaredMethodWithTypeArguments(String methodName, Class<?>... argTypes) throws NoSuchMethodException {
        Method method = Battlefield.class.getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        return method;
    }
}
