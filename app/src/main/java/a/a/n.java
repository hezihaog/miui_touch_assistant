package a.a;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

class n
{
  private static Object a(ClassLoader paramClassLoader)
  {
    Field[] arrayOfField;
    int j;
    int i;
    if ((paramClassLoader instanceof BaseDexClassLoader))
    {
      arrayOfField = BaseDexClassLoader.class.getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i < j)
      {
        localObject = arrayOfField[i];
        if ("dalvik.system.DexPathList".equals(((Field)localObject).getType().getName())) {
          ((Field)localObject).setAccessible(true);
        }
      }
      try
      {
        localObject = ((Field)localObject).get(paramClassLoader);
        return localObject;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        i++;
        continue;
        throw new NoSuchFieldException("dexPathList field not found.");
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;) {}
      }
    }
  }
  
  private static Field a(Object paramObject)
  {
    for (Field localField : paramObject.getClass().getDeclaredFields())
    {
      paramObject = localField.getType();
      if ((((Class)paramObject).isArray()) && ("dalvik.system.DexPathList$Element".equals(((Class)paramObject).getComponentType().getName())))
      {
        localField.setAccessible(true);
        return localField;
      }
    }
    throw new NoSuchFieldException("dexElements field not found.");
  }
  
  private static void a(Object paramObject, File paramFile)
  {
    Field localField = b(paramObject);
    File[] arrayOfFile1 = (File[])localField.get(paramObject);
    File[] arrayOfFile2 = new File[arrayOfFile1.length + 1];
    arrayOfFile2[0] = paramFile;
    System.arraycopy(arrayOfFile1, 0, arrayOfFile2, 1, arrayOfFile1.length);
    localField.set(paramObject, arrayOfFile2);
  }
  
  private static void a(Object paramObject1, Object paramObject2)
  {
    Field localField = a(paramObject1);
    Object[] arrayOfObject1 = (Object[])localField.get(paramObject1);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(Class.forName("dalvik.system.DexPathList$Element"), arrayOfObject1.length + 1);
    arrayOfObject2[0] = paramObject2;
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 1, arrayOfObject1.length);
    localField.set(paramObject1, arrayOfObject2);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    for (;;)
    {
      try
      {
        Object localObject = a(paramClassLoader);
        if (paramString2 != null) {
          continue;
        }
        paramString2 = new dalvik/system/PathClassLoader;
        paramString2.<init>(paramString1, paramString3, paramClassLoader.getParent());
        paramString1 = paramString2;
        paramString1 = a(paramString1);
        a(localObject, ((Object[])(Object[])a(paramString1).get(paramString1))[0]);
        if (paramString3 != null)
        {
          paramString1 = new java/io/File;
          paramString1.<init>(paramString3);
          a(localObject, paramString1);
        }
      }
      catch (IllegalArgumentException paramString1)
      {
        continue;
      }
      catch (NoSuchFieldException paramString1)
      {
        continue;
      }
      catch (ClassNotFoundException paramString1)
      {
        continue;
      }
      catch (IllegalAccessException paramString1)
      {
        continue;
      }
      return true;
      paramString1 = new DexClassLoader(paramString1, paramString2, paramString3, paramClassLoader.getParent());
    }
  }
  
  private static Field b(Object paramObject)
  {
    for (Field localField : paramObject.getClass().getDeclaredFields())
    {
      Class localClass = localField.getType();
      if ((localClass.isArray()) && (localClass.getComponentType() == File.class))
      {
        localField.setAccessible(true);
        return localField;
      }
    }
    throw new NoSuchFieldException("nativeLibraryDirectories field not found.");
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */