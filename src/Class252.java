import java.util.Hashtable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Class252 {
   private static Hashtable Field794 = new Hashtable();
   public static Image[] Field795;
   private static int Field796 = -1;
   private static Image _img;

   public static void Method320() {
      if (!Settings.Instance.RenderDimm && _img == null) {
         _img = Class198.OpenImage("new/shadow.png");
      }

   }

   public static void Method321() {
      Field794.clear();
      System.gc();
   }

   public static Image Method322(int var0, int var1, int var2) {
      if (var1 <= 0) {
         var1 = 1;
      }

      int var3 = var1 * Class198.Instance.Field648;
      if (Field795 == null || Field796 != var3) {
         Field795 = new Image[7];
         Field796 = var3;
      }
      
      if (Field795[var2] == null) {
         var3 = var2 * 255 / 10 / 2 << 24 | var0 & 16777215;
         int[] var5 = new int[Field796];

         for(int i = 0; i < var5.length; i++) {
            var5[i] = var3;
         }

         Field795[var2] = Image.createRGBImage(var5, Class198.Instance.Field648, var1, true);
      }
      
      return Field795 != null ? Field795[var2] : null;
   }

   public static Image Method323(int var0, int var1, int var2, int var3, int var4, int var5, boolean var6) {
      return GenerateMask(var0, var1, var2, var3, var4, var5, 0, var1, var6);
   }

   public static Image GenerateMask(int width, int height, int radius, int color, int var4, int var5, int var6, int var7, boolean var8) {
      if (!Settings.Instance.Gradients) {
         color = var4 = Method332(color, var4, 128);
      }

      if (width > 0 && height > 0 && radius > 0) {
         if (var8) {
            color |= -16777216;
            var4 |= -16777216;
         }

         int[] pixels = new int[width * height];
         int i;
         int var11;
         int j;
         if (color == var4) {
            for(i = 0; i < pixels.length; i++) {
               pixels[i] = color;
            }
         } else {
            for(i = 0; i < height; i++) {
               var11 = Method332(color, var4, 255 * (i + var6) / Math.max(1, var7 - 1));

               for(j = 0; j < width; j++) {
                  pixels[i * width + j] = var11;
               }
            }
         }

         i = Math.max(var5 & 1, var5 >> 1 & 1);
         var11 = Math.max(var5 >> 2 & 1, var5 >> 2 & 1);
         boolean var24 = i <= 0 || var11 <= 0;
         boolean var20 = (var5 & 1) == 1;
         boolean var22 = (var5 & 2) == 2;
         boolean var23 = (var5 & 8) == 8;
         boolean var21 = (var5 & 4) == 4;
         if (var24) {
            radius = Math.min(radius, Math.min(width, height));
         } else {
            radius = Math.min(radius, Math.min(width / 2, height / 2));
         }

         var7 = radius << 1;
         var11 = (i = radius * radius) << 2;

         for(j = 0; j < radius; j++) {
            int var13;
            int var14 = (var13 = (radius - j) * (radius - j)) << 2;
            int var15 = (var7 - 1 - (j << 1)) * (var7 - 1 - (j << 1));

            int var18;
            for(int var16 = 0; var16 < radius; var16 = var18 + 1) {
               int var17;
               var18 = (var17 = (radius - var16) * (radius - var16)) << 2;
               int var19 = (var7 - 1 - (var16 << 1)) * (var7 - 1 - (var16 << 1));
               var17 = (var17 + var13 >= i ? 63 : 0) + (var18 + var15 >= var11 ? 64 : 0) + (var19 + var14 >= var11 ? 64 : 0) + (var19 + var15 >= var11 ? 64 : 0);
               if (var8) {
                  var17 = 255 - var17;
               }

               var17 <<= 24;
               var18 = var16;
               var19 = j;
               if (var20) {
                  pixels[j * width + var16] = var17 | (pixels[j * width + var16] &= 16777215);
               }

               var16 = width - var16 - 1;
               if (var22) {
                  pixels[j * width + var16] = var17 | (pixels[j * width + var16] &= 16777215);
               }

               j = height - j - 1;
               if (var21) {
                  pixels[j * width + var16] = var17 | (pixels[j * width + var16] &= 16777215);
               }

               if (var23) {
                  pixels[j * width + var18] = var17 | (pixels[j * width + var18] &= 16777215);
               }

               j = var19;
            }
         }

         return Image.createRGBImage(pixels, width, height, true);
      } else {
         return null;
      }
   }

   public static Image Method325(int var0, Image var1, int var2) {
      if (var0 <= 0) {
         return var1;
      } else if (var1 == null) {
         return null;
      } else {
         var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var2 * var3];
         var1.getRGB(var4, 0, var2, 0, 0, var2, var3);
         int var16 = Math.max(1, 1);
         int var5 = Math.max(1, 1);
         if (var16 <= 0 || var5 <= 0) {
            var0 = Math.min(var0, Math.min(var2, var3));
         } else {
            var0 = Math.min(var0, Math.min(var2 / 2, var3 / 2));
         }

         var16 = var0 << 1;
         int var6 = (var5 = var0 * var0) << 2;

         for(int var7 = 0; var7 < var0; var7++) {
            int var8;
            int var9 = (var8 = (var0 - var7) * (var0 - var7)) << 2;
            int var10 = (var16 - 1 - (var7 << 1)) * (var16 - 1 - (var7 << 1));

            int var13;
            for(int var11 = 0; var11 < var0; var11 = var13 + 1) {
               int var12;
               var13 = (var12 = (var0 - var11) * (var0 - var11)) << 2;
               int var14 = (var16 - 1 - (var11 << 1)) * (var16 - 1 - (var11 << 1));
               var12 = (var12 + var8 >= var5 ? 63 : 0) + (var13 + var10 >= var6 ? 64 : 0) + (var14 + var9 >= var6 ? 64 : 0) + (var14 + var10 >= var6 ? 64 : 0);
               var12 = 255 - var12;
               var13 = var11;
               var14 = var7;
               int var15 = var4[var7 * var2 + var11];
               var4[var7 * var2 + var11] = var12 * (var15 >>> 24) / 255 << 24 | var15 & 16777215;
               var11 = var2 - var11 - 1;
               var15 = var4[var7 * var2 + var11];
               var4[var7 * var2 + var11] = var12 * (var15 >>> 24) / 255 << 24 | var15 & 16777215;
               var7 = var3 - var7 - 1;
               var15 = var4[var7 * var2 + var11];
               var4[var7 * var2 + var11] = var12 * (var15 >>> 24) / 255 << 24 | var15 & 16777215;
               var15 = var4[var7 * var2 + var13];
               var4[var7 * var2 + var13] = var12 * (var15 >>> 24) / 255 << 24 | var15 & 16777215;
               var7 = var14;
            }
         }

         return Image.createRGBImage(var4, var2, var3, true);
      }
   }

   public static Image Method326(int var0, int var1) {
      if (var0 <= 0) {
         return null;
      } else {
         int[] var2 = new int[var0 * var0];
         var1 &= 16777215;
         int var3 = var0 << 1;
         int var4 = var0 * var0;

         for(int i = 0; i < var0; i++) {
            int var6 = i * var0;
            int var7;
            int var8 = (var7 = (var0 - i) * (var0 - i)) << 2;
            int var9 = (var3 - 1 - (i << 1)) * (var3 - 1 - (i << 1));

            for(int var10 = 0; var10 < var0; var10++) {
               int var11;
               int var12 = (var11 = (var0 - var10) * (var0 - var10)) << 2;
               int var13 = (var3 - 1 - (var10 << 1)) * (var3 - 1 - (var10 << 1));
               var11 = (Math.abs(var7 + var11 - var4) <= var0 ? 63 : 0) + (Math.abs(var8 / 4 + var13 / 4 - var4) <= var0 ? 64 : 0) + (Math.abs(var9 / 4 + var12 / 4 - var4) <= var0 ? 64 : 0) + (Math.abs(var9 / 4 + var13 / 4 - var4) <= var0 ? 64 : 0);
               var2[var10 + var6] = var11 << 24 | var1;
            }
         }

         return Image.createRGBImage(var2, var0, var0, true);
      }
   }

   public static void DrawBorder(Graphics g, int var1, int var2, int var3, int var4, boolean var5, boolean var6)
   {
      g.setColor(var5 ? Class6.ColorsInstanse.Field309 : Class6.ColorsInstanse.Field297);
      g.drawRect(var1, var2, var3 - 1, var4 - 1);
      Image img;
      if ((img = var5 ? TextBox2.Field483 : TextBox2.Field482) != null) {
         g.setColor(var6 ? Class6.ColorsInstanse.Field361 : Class6.ColorsInstanse.Field291);
         g.fillRect(var1, var2, TextBox2.Field481, TextBox2.Field481);
         g.fillRect(var1 + var3 - TextBox2.Field481, var2 + var4 - TextBox2.Field481, TextBox2.Field481, TextBox2.Field481);
         g.fillRect(var1 + var3 - TextBox2.Field481, var2, TextBox2.Field481, TextBox2.Field481);
         g.fillRect(var1, var2 + var4 - TextBox2.Field481, TextBox2.Field481, TextBox2.Field481);
         g.drawImage(img, var1, var2, 20);
         g.drawRegion(img, 0, 0, TextBox2.Field481, TextBox2.Field481, 5, var1 + var3 - TextBox2.Field481, var2, 0);
         g.drawRegion(img, 0, 0, TextBox2.Field481, TextBox2.Field481, 3, var1 + var3 - TextBox2.Field481, var2 + var4 - TextBox2.Field481, 0);
         g.drawRegion(img, 0, 0, TextBox2.Field481, TextBox2.Field481, 6, var1, var2 + var4 - TextBox2.Field481, 0);
      }
   }

   public static void Method328(Graphics g, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = g.getColor();
      if (!Settings.Instance.Gradients)
      {
         var5 = var6 = Method332(var5, var6, 128);
      }

      if (var5 == var6) {
         g.setColor(var5);
         g.fillRect(var1, var2, var3, var4);
      }
      else
      {
         for(int i = 0; i < var4; i++) {
            g.setColor(Method332(var5, var6, 255 * (i + 1) / var4));
            g.drawLine(var1, var2 + i, var1 + var3 - 1, var2 + i);
         }
      }
      
      g.setColor(var7);
   }

   public static Image Method329(Image var0, int var1) {
      if (var0 == null) {
         return null;
      } else {
         int w = var0.getWidth();
         int h = var0.getHeight();
         if (var1 <= 0) {
            return Image.createImage(1, 1);
         } else {
            int[] var4 = new int[w * h];
            var0.getRGB(var4, 0, w, 0, 0, w, h);
            int var10001 = w;
            int var10002 = h;
            h = var1;
            w = var10002;
            var1 = var10001;
            int[] var22 = var4;
            if (var4 == null) {
               return null;
            } else if (h > 0 && var1 > 0 && w > 0) {
               int var23 = h;
               int var5;
               if ((var5 = var1 * h / Math.max(w, 1)) > 1 && var5 > 1) {
                  int[] var6 = new int[var5 * w];
                  int[] var7 = new int[var5 * h];
                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  int var13;
                  int var14;
                  int var15;
                  int var16;
                  int var17;
                  int var18;
                  int var19;
                  int var20;
                  int var21;
                  if (var5 < var1) {
                     for(var8 = 0; var8 < w; var8++) {
                        var9 = var8 * var1;
                        var10 = var8 * var5;
                        var12 = 0;
                        var13 = 0;
                        var14 = 0;
                        var15 = 0;
                        var16 = 0;

                        for(var11 = 0; var11 < var5; var11++) {
                           var17 = var1;
                           var18 = 0;
                           var19 = 0;
                           var20 = 0;
                           var21 = 0;
                           if (var12 != 0) {
                              var18 = var13 * var12;
                              var19 = var14 * var12;
                              var20 = var15 * var12;
                              var21 = var16 * var12;
                              var17 = var1 - var12;
                           }

                           for(; var17 > 0; var17 -= var5) {
                              var16 = var22[var9] >>> 24;
                              var13 = var22[var9] >> 16 & 255;
                              var14 = var22[var9] >> 8 & 255;
                              var15 = var22[var9++] & 255;
                              if (var17 > var5) {
                                 var18 += var13 * var5;
                                 var19 += var14 * var5;
                                 var20 += var15 * var5;
                                 var21 += var16 * var5;
                              } else {
                                 var18 += var13 * var17;
                                 var19 += var14 * var17;
                                 var20 += var15 * var17;
                                 var21 += var16 * var17;
                                 var12 = var5 - var17;
                                 var6[var10++] = var18 / var1 << 16 | var19 / var1 << 8 | var20 / var1 | var21 / var1 << 24;
                              }
                           }
                        }
                     }
                  } else {
                     for(var8 = 0; var8 < w; var8++) {
                        var9 = var8 * var1;
                        var10 = var8 * var5;

                        for(var11 = 0; var11 < var5; var11++) {
                           var13 = (var12 = (var11 << 8) * (var1 - 1) / (var5 - 1)) >>> 8;
                           var14 = var12 & 255;
                           var15 = var22[var9 + var13];
                           if (var13 < var1 - 1) {
                              var16 = var22[var9 + var13 + 1];
                              var15 = Method332(var15, var16, var14);
                           }

                           var6[var10++] = var15;
                        }
                     }
                  }

                  if (h < w) {
                     for(var8 = 0; var8 < var5; var8++) {
                        var9 = var8;
                        var10 = var8;
                        var12 = 0;
                        var13 = 0;
                        var14 = 0;
                        var15 = 0;
                        var16 = 0;

                        for(var11 = 0; var11 < h; var11++) {
                           var17 = w;
                           var18 = 0;
                           var19 = 0;
                           var20 = 0;
                           var21 = 0;
                           if (var12 != 0) {
                              var18 = var13 * var12;
                              var19 = var14 * var12;
                              var20 = var15 * var12;
                              var21 = var16 * var12;
                              var17 = w - var12;
                           }

                           for(; var17 > 0; var17 -= var23) {
                              var16 = var6[var9] >>> 24;
                              var13 = var6[var9] >> 16 & 255;
                              var14 = var6[var9] >> 8 & 255;
                              var15 = var6[var9] & 255;
                              var9 += var5;
                              if (var17 > var23) {
                                 var18 += var13 * var23;
                                 var19 += var14 * var23;
                                 var20 += var15 * var23;
                                 var21 += var16 * var23;
                              } else {
                                 var18 += var13 * var17;
                                 var19 += var14 * var17;
                                 var20 += var15 * var17;
                                 var21 += var16 * var17;
                                 var12 = var23 - var17;
                                 if (var21 != 0) {
                                    var7[var10] = var18 / w << 16 | var19 / w << 8 | var20 / w | var21 / w << 24;
                                 } else {
                                    var7[var10] = 0;
                                 }

                                 var10 += var5;
                              }
                           }
                        }
                     }
                  } else {
                     for(var8 = 0; var8 < var5; var8++) {
                        var9 = var8;
                        var10 = var8;

                        for(var11 = 0; var11 < h; var11++) {
                           var13 = (var12 = (var11 << 8) * (w - 1) / (h - 1)) >>> 8;
                           var14 = var12 & 255;
                           var15 = var6[var9 + var13 * var5];
                           if (var13 < w - 1) {
                              var16 = var6[var9 + (var13 + 1) * var5];
                              var15 = Method332(var15, var16, var14);
                           }

                           var7[var10] = var15;
                           var10 += var5;
                        }
                     }
                  }

                  return Image.createRGBImage(var7, var5, h, true);
               } else {
                  return Image.createImage(1, 1);
               }
            } else {
               return Image.createImage(1, 1);
            }
         }
      }
   }

   public static void DrawRle(Graphics g, int x, int y, String file, int var4, int var5, int var6, int size, int var8) {
      String var11 = file + "_" + size + "_" + var4;
      Integer var9 = (Integer)Field794.get(var11);
      int var10 = var9 == null ? 0 : var9.intValue();
      var10 = Class6.ColorsInstanse.Method140(g, x, y, var10, file, var5, var6, size, var8);
      if (var9 == null || var9.intValue() == 0) {
         Field794.put(var11, new Integer(var10));
      }

   }

   static void Method331(Graphics g, int var1, int var2, int var3, int var4) {
      if (!Settings.Instance.RenderDimm && _img != null) {
         int var5;
         int var6;
         int var7 = Math.min(var6 = (var5 = _img.getWidth() / 3) >> 1, var3 / 2);
         int var8 = Math.min(var6, var4 / 2);
         g.drawRegion(_img, 0, 0, var6 + var7, var6 + var8, 0, var1 - var6, var2 - var6, 0);
         var7 = Math.min(var6, var3 - var3 / 2);
         g.drawRegion(_img, (var5 << 1) + var6 - var7, 0, var6 + var7, var6 + var8, 0, var1 + var3 - var7, var2 - var6, 0);
         var7 = Math.min(var6, var3 / 2);
         var8 = Math.min(var6, var4 - var4 / 2);
         g.drawRegion(_img, 0, (var5 << 1) + var6 - var8, var6 + var7, var6 + var8, 0, var1 - var6, var2 + var4 - var8, 0);
         var7 = Math.min(var6, var3 - var3 / 2);
         g.drawRegion(_img, (var5 << 1) + var6 - var7, (var5 << 1) + var6 - var8, var6 + var7, var6 + var8, 0, var1 + var3 - var7, var2 + var4 - var8, 0);
         var7 = var1 + var3 - var6;

         int var9;
         for(var3 = var1 + var6; var3 < var7; var3 += var5) {
            var9 = Math.min(var7 - var3, var5);
            g.drawRegion(_img, var5, 0, var9, var5, 0, var3, var2 - var6, 0);
            g.drawRegion(_img, var5, var5 << 1, var9, var5, 0, var3, var2 + var4 - var6, 0);
         }

         var8 = var2 + var4 - var6;

         for(var3 = var2 + var6; var3 < var8; var3 += var5) {
            var9 = Math.min(var8 - var3, var5);
            g.drawRegion(_img, 0, var5, var5, var9, 0, var1 - var6, var3, 0);
            g.drawRegion(_img, var5 << 1, var5, var5, var9, 0, var7, var3, 0);
         }

      }
   }

   public static int Method332(int var0, int var1, int var2) {
      if (var2 == 0) {
         return var0;
      } else if (var2 == 255) {
         return var1;
      } else {
         int var3 = 255 - var2;
         int var4 = ((var0 >>> 24) * var3 + (var1 >>> 24) * var2) / 255;
         int var5 = ((var0 >> 16 & 255) * var3 + (var1 >> 16 & 255) * var2) / 255;
         int var6 = ((var0 >> 8 & 255) * var3 + (var1 >> 8 & 255) * var2) / 255;
         var0 = ((var0 & 255) * var3 + (var1 & 255) * var2) / 255;
         return var4 << 24 | var5 << 16 | var6 << 8 | var0;
      }
   }
}
