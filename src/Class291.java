import java.util.TimeZone;
import java.util.Vector;

public final class Class291 {
   private static final byte[] Field911 = new byte[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   private static int Field912 = TimeZone.getDefault().getRawOffset() / 1000;

   public static long Method434() {
      return System.currentTimeMillis() / 1000L + (long)Field912;
   }

   public static int[] Method435(long var0) {
      int var3 = (int)(var0 % 60L);
      int var4 = (int)(var0 / 60L % 60L);
      int var5 = (int)((var0 -= (long)(var4 * 60)) / 3600L % 24L);
      int var9 = (int)((var0 - (long)(var5 * 3600)) / 86400L);
      int var7 = 1970;

      while(true) {
         int var10001 = var7 % 4 == 0 && var7 != 2000 ? 366 : 365;
         int var10000 = var9 - (var7 % 4 == 0 && var7 != 2000 ? 366 : 365);
         int var1 = var9 - var10001;
         if (var10000 <= 0) {
            int var8 = var7 % 4 == 0 && var7 != 2000 ? 29 : 28;
            int var6 = 1;

            for(int i = 0; i < 12 && (var1 = var9 - (i == 1 ? var8 : Field911[i])) > 0; i++) {
               ++var6;
               var9 = var1;
            }

            return new int[]{var3, var4, var5, var9, var6, var7};
         }

         var9 = var1;
         ++var7;
      }
   }

   public static String Method436(long var0) {
      return var0 < 10L ? "0" + String.valueOf(var0) : String.valueOf(var0);
   }

   public static boolean IsNullOrEmpty(String text) {
      return text == null || text.trim().length() == 0;
   }

   public static String Method438(String var0, String var1, String var2) {
      String[] var10000;
      if (var0 == null) {
         var10000 = null;
      } else if (var1 == null) {
         var10000 = new String[]{var0};
      } else {
         int var3;
         String[] var4 = new String[(var3 = var0.indexOf(var1)) != -1 ? 2 : 1];
         if (var3 == -1) {
            var4[0] = var0;
            var10000 = var4;
         } else {
            var4[1] = var0.substring(var3 + var1.length());
            var4[0] = var0.substring(0, var0.length() - var1.length() - var4[1].length());
            var10000 = var4;
         }
      }

      String[] var5 = var10000;
      if (var10000 == null) {
         return null;
      } else {
         return var5.length == 1 ? var5[0] : var5[0] + var2 + var5[1];
      }
   }

   public static Vector Separete(String input, String var1) {
      StringBuffer var2 = new StringBuffer();
      Vector var3 = new Vector();
      char[] var5 = input.toCharArray();

      for(int i = 0; i < var5.length; i++) {
         var2.append(var5[i]);
         if (var2.toString().indexOf(var1) != -1) {
            var2.setLength(var2.length() - var1.length());
            var3.addElement(var2.toString());
            var2.setLength(0);
         }
      }

      if (var2.length() > 0) {
         var3.addElement(var2.toString());
      }

      return var3;
   }

   public static String Method440(String var0, Vector var1) {
      StringBuffer var2 = new StringBuffer();
      if (var1 != null) {
         for(int i = 0; i < var1.size(); i++) {
            var2.append(var1.elementAt(i));
            if (i != var1.size() - 1) {
               var2.append(var0);
            }
         }
      }

      return var2.toString();
   }

   public static String Method441(long var0, boolean var2) {
      long var10000 = var0 + (long)Field912;
      boolean var5 = var2;
      long var3 = var10000;
      if (var10000 == 0L) {
         return "[incorrect data]";
      } else {
         int[] var1 = Method435(var3);
         StringBuffer var6;
         (var6 = new StringBuffer()).append(Method436((long)var1[2])).append(':').append(Method436((long)var1[1]));
         if (var5) {
            var6.append(':').append(Method436((long)var1[0]));
         }

         return var6.toString();
      }
   }

   public static int[] Method442(String var0) {
      if (var0 == null) {
         return null;
      } else {
         int[] var1 = new int[6];
         Vector var5;
         if ((var5 = Separete(var0, ".")).size() > 2) {
            try {
               var1[5] = Integer.parseInt((String)var5.elementAt(2));
            } catch (Exception var4) {
            }
         }

         if (var5.size() > 1) {
            try {
               var1[4] = Integer.parseInt((String)var5.elementAt(1));
            } catch (Exception var3) {
            }
         }

         if (var5.size() > 0) {
            try {
               var1[3] = Integer.parseInt((String)var5.elementAt(0));
            } catch (Exception var2) {
            }
         }

         return var1;
      }
   }
}
