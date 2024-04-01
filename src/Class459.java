import java.util.Hashtable;

public final class Class459 {
   private static Hashtable Field1280 = new Hashtable();

   public static void Method195(Class362 var0) {
      if (var0 != null) {
         Field1280.put(var0.Method73(), var0);
      }
   }

   public static Class362 Method196(String var0) {
      return var0 == null ? null : (Class362)Field1280.get(var0);
   }

   public static void Method197(Class362 var0) {
      if (var0 != null) {
         Method198(var0.Method73());
      }
   }

   public static void Method198(String var0) {
      if (var0 != null) {
         Field1280.remove(var0);
      }
   }

   public static boolean Method199(String var0) {
      return var0 == null ? false : Field1280.containsKey(var0);
   }
}
