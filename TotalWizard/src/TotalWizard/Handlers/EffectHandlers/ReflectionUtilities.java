package TotalWizard.Handlers.EffectHandlers;

import java.lang.reflect.Field;

public class ReflectionUtilities
{
	public static void setValue(Object instance, String fieldName, Object value) throws Exception
	{
		Field field = instance.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(instance, value);
	}

	public static Object getValue(Object instance, String fieldName) throws Exception
	{
		Field field = instance.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(instance);
	}
}

/*
 * Location: C:\Users\Brandon\Desktop\TotalWar.jar Qualified Name:
 * com.caved_in.Handlers.EffectHandlers.ReflectionUtilities JD-Core Version:
 * 0.6.2
 */