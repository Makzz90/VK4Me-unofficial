public final class Class283 {
   private static final byte[] Field883 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
   private static final byte[] Field884 = new byte[]{80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 62, 80, 62, 80, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 80, 80, 80, 64, 80, 80, 80, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 80, 80, 80, 80, 63, 80, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 80, 80, 80, 80, 80};

   public static final byte[] Method402(byte[] var0) {
      byte[] var1 = new byte[var0.length / 3 + (var0.length % 3 != 0 ? 1 : 0) << 2];
      int var2 = 0;

      for(int var3 = 0; var3 < var0.length; var3 += 3) {
         if (var3 + 2 >= var0.length) {
            if (var3 + 1 >= var0.length) {
               var1[var2++] = Field883[(var0[var3] & 255) >>> 2];
               var1[var2++] = Field883[(var0[var3] & 3) << 4];
               var1[var2++] = 61;
               var1[var2++] = 61;
            } else {
               var1[var2++] = Field883[(var0[var3] & 255) >>> 2];
               var1[var2++] = Field883[(var0[var3] & 3) << 4 | (var0[var3 + 1] & 240) >>> 4];
               var1[var2++] = Field883[(var0[var3 + 1] & 15) << 2];
               var1[var2++] = 61;
            }
         } else {
            var1[var2++] = Field883[(var0[var3] & 255) >>> 2];
            var1[var2++] = Field883[(var0[var3] & 3) << 4 | (var0[var3 + 1] & 240) >>> 4];
            var1[var2++] = Field883[(var0[var3 + 1] & 15) << 2 | (var0[var3 + 2] & 192) >>> 6];
            var1[var2++] = Field883[var0[var3 + 2] & 63];
         }
      }

      return var1;
   }

   public static final byte[] Method403(byte[] var0) {
      if (var0.length == 0) {
         return var0;
      } else if (var0.length % 4 != 0) {
         return null;
      } else {
         byte[] var1 = new byte[var0.length / 4 * 3 - (var0[var0.length - 1] == 61 ? 1 : 0) - (var0[var0.length - 2] == 61 ? 1 : 0)];
         int var2 = 0;

         for(int var3 = 0; var3 < var0.length; var3 += 4) {
            if (var0[var3 + 3] == 61) {
               if (var0[var3 + 2] == 61) {
                  var1[var2++] = (byte)(Field884[var0[var3]] << 2 | (Field884[var0[var3 + 1]] & 240) >>> 4);
               } else {
                  var1[var2++] = (byte)(Field884[var0[var3]] << 2 | (Field884[var0[var3 + 1]] & 240) >>> 4);
                  var1[var2++] = (byte)((Field884[var0[var3 + 1]] & 15) << 4 | (Field884[var0[var3 + 2]] & 60) >>> 2);
               }
            } else {
               var1[var2++] = (byte)(Field884[var0[var3]] << 2 | (Field884[var0[var3 + 1]] & 240) >>> 4);
               var1[var2++] = (byte)((Field884[var0[var3 + 1]] & 15) << 4 | (Field884[var0[var3 + 2]] & 60) >>> 2);
               var1[var2++] = (byte)((Field884[var0[var3 + 2]] & 3) << 6 | Field884[var0[var3 + 3]] & 63);
            }
         }

         return var1;
      }
   }
}
