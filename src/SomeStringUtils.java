import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class SomeStringUtils {
   public static String[] Field913 = new String[]{"", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};

   public static final boolean IsStringEmpty(String text) {
      return Class291.IsNullOrEmpty(text);
   }
/*
   public static final int Method426(boolean var0) {
      return var0 ? 1 : 0;
   }
*/
   public static final String Method427(int var0) {
      return Class291.Method441((long)var0, false);
   }

   public static String Method428(int var0) {
      int[] var1 = Class291.Method435((long)var0);
      return Class291.Method436((long)var1[3]) + " " + Field913[var1[4]];
   }

   public static final String Method429(int var0) {
      return System.currentTimeMillis() / 1000L / 86400L - (long)(var0 / 86400) > 0L ? Method428(var0) : Class291.Method441((long)var0, false);
   }

   public static final String Method430(long var0) {
      long var2 = var0 / 60L;
      long var4 = var0 % 60L;
      return var2 + ":" + Class291.Method436(var4);
   }

   public static final String GetCommaSepareted(MethodsWithParameters var0) {
      StringBuffer sb = new StringBuffer();
      if (var0 == null) {
         return sb.toString();
      } else {
         String var3;
         String var4;
         Hashtable var5;
         for(Enumeration var2 = (var5 = var0.GetParameters()).keys(); var2.hasMoreElements(); sb.append(var3).append('=').append(var4)) {
            var3 = (String)var2.nextElement();
            var4 = (String)var5.get(var3);
            if (sb.length() > 0) {
               sb.append('&');
            }
         }

         return sb.toString();
      }
   }

   public static final String Method432(String var0, Vector var1) {
      StringBuffer sb = new StringBuffer();
      if (var1 != null && var0 != null) {
         for(int i = 0; i < var1.size(); i++) {
            Object var4;
            if ((var4 = var1.elementAt(i)) != null) {
               if (sb.length() > 0) {
                  sb.append(var0);
               }

               sb.append(var4.toString());
            }
         }

         return sb.toString();
      } else {
         return sb.toString();
      }
   }

   public static final boolean Method433(int var0) {
      return var0 == 1;
   }
}
