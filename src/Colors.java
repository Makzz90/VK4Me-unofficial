import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Colors
{
//   public ApplicationTheme Field283 = new ApplicationTheme();
   public int Field284 = 4539976;
   public int Field285 = 2895151;
   public int Field286 = 15790579;
   public int Field287 = 16777215;
   public int Field288 = 14869479;
   public int Field289 = 7829626;
   public int Field290 = 4539976;
   public int Field291 = 1644825;//25,25,25 1644825
   public int Field292 = 14869479;
   private int Field293 = 6184801;
   public int Field294 = 9475223;
   public int Field295 = 14343135;
   public int Field296 = 11448243;
   public int Field297 = 4539976;//69,70,72
   public int Field298 = 14343135;
   public int Field299 = 14343135;
   public int Field300 = 11448243;
   public int Field301 = 11448243;
   public int Field302 = 4539976;
   public int Field303 = 2895151;
   public int Field304 = 16777215;
   private int Field305 = 10197913;
   public int Field306 = 13488335;
   public int Field307 = 16777215;
   public int Field308 = 14869479;
   public int Field309 = 14869479;
   public int Field310 = 14343135;
   public int Field311 = 16777215;
   public int Field312 = 16777215;
   public int Field313 = 11448243;
   public int Field314 = 14869479;
   public int Field315 = 14869479;
   private int Field316 = 7708140;
   private int Field317 = 4681404;
   public int Field318 = 2236962;
   public int Field319 = 2236962;
   public int Field320 = 1644825;
   public int Field321 = 14343135;
   public int Field322 = 11448243;
   public int Field323 = 3684924;
   public int Field324 = 16777215;
   public int Field325 = 14869479;
   public int Field326 = 3487029;
   public int Field327 = 657930;
   public int Field328 = 2236962;
   public int Field329 = 9737364;
   public int Field330 = 6579300;
   public int Field331 = 16777215;
   public int Field332 = 14869479;
   public int Field333 = 2895151;
   public int Field334 = 1644825;
   public int Field335 = 4539976;
   public int Field336 = 2895151;
   public int Field337 = 4539976;
   public int Field338 = 4869198;
   public int Field339 = 3684924;
   public int Field340 = 3816253;
   public int Field341 = 2895151;
   public int Field342 = 5855837;
   public int Field343 = 4539976;
   public int Field344 = 9737364;
   public int Field345 = 14869479;
   public int Field346 = 14869479;
   private int Field347 = 16777215;
   private int Field348 = 16777215;
   public int Field349 = 4895562;
   public int Field350 = 1644825;
   public int Field351 = 0;
   public int Field352 = 2895151;
   public int Field353 = 16744574;
   public int Field354 = 13125959;
   public int Field355 = 16735579;
   public int Field356 = 16744574;
   public int Field357 = 13125959;
   public int Field358 = 16735579;
   public int Field359 = 14343135;
   public int Field360 = 657930;
   public int Field361 = 1710618;
   public int Field362 = 14869479;
   public int Field363 = 7171439;
   public int Field364 = 5724250;
   public int Field365 = 8947848;
   public int Field366 = 7434611;
   private int Field367 = 0;
   private int[][] Field368 = new int[10][2];
   private Image[] Field369 = new Image[10];
   private Hashtable Field370 = new Hashtable();
   private Hashtable Field371 = new Hashtable();
   private Hashtable Field372 = new Hashtable();

   public Colors()
   {
//      this.Field283.Name = "Classic Dark";
//      this.Field283.Version = "3.3.0";
   }
/*
   public Colors(byte[] var1) {
      try
      {
		this.Method149(new ByteArrayInputStream(var1));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
*/
   public final int Method140(Graphics g, int x, int y, int var4, String file, int var6, int var7, int var8, int var9) {
      return this.Method141(g, x, y, var4, file, var6, var7, var8, 0, var9);
   }

   public final int Method141(Graphics g, int x, int y, int var4, String file, int var6, int var7, int var8, int var9, int var10) {
      int var13;
      label28: {
         var13 = var4;
         if (var4 == 0) {
            if (this.Field367 == this.Field369.length) {
               int[][] var12 = new int[this.Field368.length + 10][2];
               System.arraycopy(this.Field368, 0, var12, 0, this.Field368.length);
               this.Field368 = var12;
               Image[] var16 = new Image[this.Field369.length + 10];
               System.arraycopy(this.Field369, 0, var16, 0, this.Field369.length);
               this.Field369 = var16;
            }

            var13 = this.Field367 + 1;
            ++this.Field367;
         } else if (this.Field369[var4 - 1] != null && this.Field369[var4 - 1].getHeight() == var8 && this.Field368[var4 - 1] != null && this.Field368[var4 - 1][0] == var6 && this.Field368[var4 - 1][1] == var7) {
            break label28;
         }

         this.Field369[var13 - 1] = this.Method143(file, var6, var7, var8);
         this.Field368[var13 - 1] = new int[]{var6, var7};
      }

      Image var15= this.Field369[var13 - 1];
      if (var15 != null)
      {
         g.drawRegion(var15, 0, 0, var15.getWidth(), var15.getHeight(), var9, x, y, var10);
      }

      return var13;
   }

   public final void Method142() {
      for(int i = 0; i < this.Field367; i++) {
         this.Field369[i] = null;
      }

      this.Field370.clear();
      this.Field371.clear();
      this.Field372.clear();
   }

   private Image Method143(String file, int var2, int var3, int var4) {
      try {
         int var6;
         byte[] var7= (byte[])this.Field370.get(file);
         int var11;
         if (var7 == null)
         {
            InputStream stream = (new Object()).getClass().getResourceAsStream("/res/" + file);
            DataInputStream var10= new DataInputStream(stream);
            byte[] var8 = new byte[var10.available()];
            var10.read(var8);
            var10.close();
            var11 = var8[0] << 24 | var8[1] << 16 | var8[2] << 8 | var8[3] & 255;
            var6 = var8[4] << 24 | var8[5] << 16 | var8[6] << 8 | var8[7] & 255;
            var7 = new byte[var11 * var6];
            Method146(var8, 8, var7);
            this.Field370.put(file, var7);
            this.Field371.put(file, new Integer(var11));
            this.Field372.put(file, new Integer(var6));
         } else {
            var11 = ((Integer)this.Field371.get(file)).intValue();
            var6 = ((Integer)this.Field372.get(file)).intValue();
         }

         return Method145(Method144(var7, var11, var6, var4), var2, var3);
      } catch (Exception ex) {
         Logger.PrintErrorWithMessage(ex);
         return Class252.Method329(Image.createImage(1, 1), var4);
      }
   }

   private static Object[] Method144(byte[] var0, int var1, int var2, int var3) {
      if (var0 == null) {
         return null;
      } else if (var3 <= 0) {
         return new Object[]{new byte[1], new Integer(1), new Integer(1)};
      } else {
         int var4 = var3;
         int var5;
         byte[] var6 = new byte[(var5 = var1 * var3 / var2) * var2];
         byte[] var7 = new byte[var5 * var3];
         int i;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         int j;
         int var15;
         int var16;
         if (var5 < var1) {
            for(i = 0; i < var2; i++) {
               var9 = i * var1;
               var10 = i * var5;
               var12 = 0;
               var13 = 0;

               for(j = 0; j < var5; j++) {
                  var15 = var1;
                  var16 = 0;
                  if (var12 != 0) {
                     var16 = var13 * var12;
                     var15 = var1 - var12;
                  }

                  for(; var15 > 0; var15 -= var5) {
                     var13 = var0[var9++] & 255;
                     if (var15 > var5) {
                        var16 += var13 * var5;
                     } else {
                        var16 += var13 * var15;
                        var12 = var5 - var15;
                        var6[var10++] = (byte)(var16 / var1);
                     }
                  }
               }
            }
         } else {
            for(i = 0; i < var2; i++) {
               var9 = i * var1;
               var10 = i * var5;

               for(var11 = 0; var11 < var5; var11++) {
                  var13 = (var12 = (var11 << 8) * (var1 - 1) / (var5 - 1)) >>> 8;
                  j = var12 & 255;
                  var15 = 255 - j;
                  var16 = var0[var9 + var13] & 255;
                  if (var13 < var1 - 1) {
                     var12 = var0[var9 + var13 + 1] & 255;
                     var16 = (var16 * var15 + var12 * j) / 255;
                  }

                  var6[var10++] = (byte)var16;
               }
            }
         }

         if (var3 < var2) {
            for(i = 0; i < var5; i++) {
               var9 = i;
               var10 = i;
               var12 = 0;
               var13 = 0;

               for(j = 0; j < var3; j++) {
                  var15 = var2;
                  var16 = 0;
                  if (var12 != 0) {
                     var16 = var13 * var12;
                     var15 = var2 - var12;
                  }

                  for(; var15 > 0; var15 -= var4) {
                     var13 = var6[var9] & 255;
                     var9 += var5;
                     if (var15 > var4) {
                        var16 += var13 * var4;
                     } else {
                        var16 += var13 * var15;
                        var12 = var4 - var15;
                        var7[var10] = (byte)(var16 / var2);
                        var10 += var5;
                     }
                  }
               }
            }
         } else {
            for(i = 0; i < var5; i++) {
               var9 = i;
               var10 = i;

               for(var11 = 0; var11 < var3; var11++) {
                  var13 = (var12 = (var11 << 8) * (var2 - 1) / (var3 - 1)) >>> 8;
                  j = var12 & 255;
                  var15 = 255 - j;
                  var16 = var6[var9 + var13 * var5] & 255;
                  if (var13 < var2 - 1) {
                     var12 = var6[var9 + (var13 + 1) * var5] & 255;
                     var16 = (var16 * var15 + var12 * j) / 255;
                  }

                  var7[var10] = (byte)var16;
                  var10 += var5;
               }
            }
         }

         return new Object[]{var7, new Integer(var5), new Integer(var3)};
      }
   }

   private static Image Method145(Object[] data, int var1, int var2) {
      if (data == null) {
         return Image.createImage(1, 1);
      } else {
         if (!Settings.Instance.Gradients) {
            var1 = var2 = Class252.Method332(var1, var2, 128);
         }

         byte[] var3 = (byte[])data[0];
         int var4 = ((Integer)data[1]).intValue();
         int var9 = ((Integer)data[2]).intValue();
         int[] var5 = new int[var3.length];
         var1 &= 16777215;
         var2 &= 16777215;
         int var6;
         if (var1 == var2)
         {
            for(var6 = 0; var6 < var3.length; var6++)
            {
               var5[var6] = var3[var6] << 24 | var1;
            }

            return Image.createRGBImage(var5, var4, var9, true);
         }
         else
         {
            for(int i = 0; i < var9; i++)
            {
               for(int j = 0; j < var4; j++)
               {
                  var6 = i * var4 + j;
                  var5[var6] = var3[var6] << 24 | Class252.Method332(var1, var2, 255 * (i + 1) / var9);
               }
            }

            return Image.createRGBImage(var5, var4, var9, true);
         }
      }
   }

   private static int Method146(byte[] var0, int var1, byte[] var2) {
      int var3 = 0;

      while(var3 < var2.length && var0.length - var1 >= 3) {
         int var4 = (var0[var1] & 255) << 8 | var0[var1 + 1] & 255;
         var1 += 2;
         boolean var5 = var4 > 32767;
         var4 = (var4 & 32767) + 1;
         if (var5) {
            byte var6 = var0[var1];
            ++var1;

            for(var4 += var3; var3 < var4; var3++) {
               var2[var3] = var6;
            }
         } else {
            System.arraycopy(var0, var1, var2, var3, var4);
            var3 += var4;
            var1 += var4;
         }
      }

      return var2.length;
   }

   public final void Method147(int[] var1) {
      this.Field284 = var1[0];
      this.Field285 = var1[1];
      this.Field286 = var1[2];
      this.Field287 = var1[3];
      this.Field288 = var1[4];
      this.Field289 = var1[5];
      this.Field290 = var1[6];
      this.Field291 = var1[7];
      this.Field292 = var1[8];
      this.Field293 = var1[9];
      this.Field294 = var1[10];
      this.Field295 = var1[11];
      this.Field296 = var1[12];
      this.Field297 = var1[13];
      this.Field298 = var1[14];
      this.Field299 = var1[15];
      this.Field300 = var1[16];
      this.Field301 = var1[17];
      this.Field302 = var1[18];
      this.Field303 = var1[19];
      this.Field304 = var1[20];
      this.Field305 = var1[21];
      this.Field306 = var1[22];
      this.Field307 = var1[23];
      this.Field308 = var1[24];
      this.Field309 = var1[25];
      this.Field310 = var1[26];
      this.Field311 = var1[27];
      this.Field312 = var1[28];
      this.Field313 = var1[29];
      this.Field314 = var1[30];
      this.Field315 = var1[31];
      this.Field316 = var1[32];
      this.Field317 = var1[33];
      this.Field318 = var1[34];
      this.Field319 = var1[35];
      this.Field320 = var1[36];
      this.Field321 = var1[37];
      this.Field322 = var1[38];
      this.Field323 = var1[39];
      this.Field324 = var1[40];
      this.Field325 = var1[41];
      this.Field326 = var1[42];
      this.Field327 = var1[43];
      this.Field328 = var1[44];
      this.Field329 = var1[45];
      this.Field330 = var1[46];
      this.Field331 = var1[47];
      this.Field332 = var1[48];
      this.Field333 = var1[49];
      this.Field334 = var1[50];
      this.Field335 = var1[51];
      this.Field336 = var1[52];
      this.Field337 = var1[53];
      this.Field338 = var1[54];
      this.Field339 = var1[55];
      this.Field340 = var1[56];
      this.Field341 = var1[57];
      this.Field342 = var1[58];
      this.Field343 = var1[59];
      this.Field344 = var1[60];
      this.Field345 = var1[61];
      this.Field346 = var1[62];
      this.Field347 = var1[63];
      this.Field348 = var1[64];
      this.Field349 = var1[65];
      this.Field350 = var1[66];
      this.Field351 = var1[67];
      this.Field352 = var1[68];
      this.Field353 = var1[69];
      this.Field354 = var1[70];
      this.Field355 = var1[71];
      this.Field356 = var1[72];
      this.Field357 = var1[73];
      this.Field358 = var1[74];
      this.Field359 = var1[75];
      this.Field360 = var1[76];
      this.Field361 = var1[77];
      this.Field362 = var1[78];
      this.Field363 = var1[79];
      this.Field364 = var1[80];
      this.Field365 = var1[81];
      this.Field366 = var1[82];
      if (Class198.Instance != null && Settings.Instance != null) {
         Class198.Instance.Method493();
      }

   }

   public final int[] Method148()
   {
      int[] var1= new int[100];
      var1[0] = this.Field284;
      var1[1] = this.Field285;
      var1[2] = this.Field286;
      var1[3] = this.Field287;
      var1[4] = this.Field288;
      var1[5] = this.Field289;
      var1[6] = this.Field290;
      var1[7] = this.Field291;
      var1[8] = this.Field292;
      var1[9] = this.Field293;
      var1[10] = this.Field294;
      var1[11] = this.Field295;
      var1[12] = this.Field296;
      var1[13] = this.Field297;
      var1[14] = this.Field298;
      var1[15] = this.Field299;
      var1[16] = this.Field300;
      var1[17] = this.Field301;
      var1[18] = this.Field302;
      var1[19] = this.Field303;
      var1[20] = this.Field304;
      var1[21] = this.Field305;
      var1[22] = this.Field306;
      var1[23] = this.Field307;
      var1[24] = this.Field308;
      var1[25] = this.Field309;
      var1[26] = this.Field310;
      var1[27] = this.Field311;
      var1[28] = this.Field312;
      var1[29] = this.Field313;
      var1[30] = this.Field314;
      var1[31] = this.Field315;
      var1[32] = this.Field316;
      var1[33] = this.Field317;
      var1[34] = this.Field318;
      var1[35] = this.Field319;
      var1[36] = this.Field320;
      var1[37] = this.Field321;
      var1[38] = this.Field322;
      var1[39] = this.Field323;
      var1[40] = this.Field324;
      var1[41] = this.Field325;
      var1[42] = this.Field326;
      var1[43] = this.Field327;
      var1[44] = this.Field328;
      var1[45] = this.Field329;
      var1[46] = this.Field330;
      var1[47] = this.Field331;
      var1[48] = this.Field332;
      var1[49] = this.Field333;
      var1[50] = this.Field334;
      var1[51] = this.Field335;
      var1[52] = this.Field336;
      var1[53] = this.Field337;
      var1[54] = this.Field338;
      var1[55] = this.Field339;
      var1[56] = this.Field340;
      var1[57] = this.Field341;
      var1[58] = this.Field342;
      var1[59] = this.Field343;
      var1[60] = this.Field344;
      var1[61] = this.Field345;
      var1[62] = this.Field346;
      var1[63] = this.Field347;
      var1[64] = this.Field348;
      var1[65] = this.Field349;
      var1[66] = this.Field350;
      var1[67] = this.Field351;
      var1[68] = this.Field352;
      var1[69] = this.Field353;
      var1[70] = this.Field354;
      var1[71] = this.Field355;
      var1[72] = this.Field356;
      var1[73] = this.Field357;
      var1[74] = this.Field358;
      var1[75] = this.Field359;
      var1[76] = this.Field360;
      var1[77] = this.Field361;
      var1[78] = this.Field362;
      var1[79] = this.Field363;
      var1[80] = this.Field364;
      var1[81] = this.Field365;
      var1[82] = this.Field366;
      return var1;
   }
/*
   private void Method149(InputStream var1) throws IOException {
      DataInputStream var4 = new DataInputStream(var1);
      this.Field283 = new ApplicationTheme();
      this.Field283.Method512(var4);
      int[] var2 = new int[100];
      byte[] var3 = new byte[400];
      var4.readFully(var3);
      var3 = Class283.Method403(var3);

      for(int i = 0; i < 300; i += 3)
      {
         var2[i / 3] = (var3[i] & 255) << 16 | (var3[i + 1] & 255) << 8 | var3[i + 2] & 255;
      }

      this.Method147(var2);
   }*/
}
