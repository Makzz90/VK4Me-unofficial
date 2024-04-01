

public final class Class435 {
   private static String[] Field1206 = new String[]{"A", "B", "V", "G", "D", "E", "ZH", "Z", "I", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "KH", "TS", "CH", "SH", "SHCH", "IE", "Y", "", "E", "IU", "IA", "a", "b", "v", "g", "d", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "ie", "y", "", "e", "iu", "ia"};

   public static String Method32(VKAudio var0) {
      if (var0 == null) {
         return null;
      } else {
         StringBuffer var10000 = new StringBuffer();
         String var10001;
         if (var0 == null) {
            var10001 = null;
         } else {
            String var1 = Method33(var0.artist);
            String var2 = Method33(var0.title);
            var10001 = (var1 = Method35(var1) + " - " + Method35(var2) + " - " + Method34(var0)).length() <= 46 ? var1 : ((var1 = Method35(var2) + " - " + Method34(var0)).length() <= 46 ? var1 : Method34(var0));
         }

         return var10000.append(var10001).append(".mp3").toString();
      }
   }

   private static String Method33(String var0) {
      if (!Settings.Instance.TranslitFiles) {
         return var0;
      } else if (var0 == null) {
         return null;
      } else {
         StringBuffer var1 = new StringBuffer();
         char[] var4 = var0.toCharArray();

         for(int i = 0; i < var4.length; i++) {
            char var3;
            if ((var3 = var4[i]) >= 1040 && var3 <= 1103) {
               var1.append(Field1206[var3 - 1040]);
            } else if (var3 == 1105) {
               var1.append('e');
            } else if (var3 == 1025) {
               var1.append('E');
            } else {
               var1.append(var3);
            }
         }

         return var1.toString();
      }
   }

   private static String Method34(VKAudio var0) {
      return new String(Class283.Method402(new byte[]{(byte)((int)(var0.owner_id >>> 24)), (byte)((int)(var0.owner_id >>> 16)), (byte)((int)(var0.owner_id >>> 8)), (byte)((int)var0.owner_id), (byte)(var0.id >> 24), (byte)(var0.id >>> 16), (byte)(var0.id >>> 8), (byte)var0.id, 0}));
   }

   private static String Method35(String var0) {
      if (var0 == null) {
         return null;
      } else {
         char[] var4 = var0.toCharArray();
         StringBuffer var1 = new StringBuffer();

         for(int i = 0; i < var4.length; i++) {
            char var3;
            if (!Character.isDigit(var3 = var4[i]) && !Character.isLowerCase(var3) && !Character.isUpperCase(var3)) {
               var1.append(' ');
            } else {
               var1.append(var3);
            }
         }

         if (var1.length() > 20) {
            var1.setLength(20);
         }

         return var1.toString().trim();
      }
   }
}
