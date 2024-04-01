import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public final class TextElement {
   private Font _font;
   private static Thread _thread;
   private static boolean SkipEmoji;
   private static Hashtable Field233;
   private static Vector EmojiCache;
   public int Height;

   public TextElement(Font font) {
      this._font = font;
      this.Height = Math.max(16, this._font.getHeight());
      if (_thread == null)
      {
         (_thread = new Class270(this)).setPriority(1);
         _thread.start();
      }

   }

   public final void Draw(Graphics g, Class277 var2, int xPos, int var4, int color) {
      if (var2 != null && g != null) {
         if ((color & 8) == 8) {
            xPos -= this.Method90(var2);
         }

         if ((color & 1) == 1) {
            xPos -= this.Method90(var2) / 2;
         }

         if ((color & 32) == 32) {
            var4 -= this.Height;
         }

         if ((color & 2) == 2) {
            var4 -= this.Height / 2;
         }

         g.setFont(this._font);
         if (!var2.Field875) {
            if (var2.Text.length > 0) {
               g.drawString(var2.Text[0], xPos, var4 + (this.Height - this._font.getHeight()) / 2, 20);
            }

         } else {
            color = g.getColor();
            int var6 = 0;

            try
            {
            for(int i = 0; i < var2.Field873.length; i++)
            {
               if (var2.Field873[i] != 1) {
                  g.setColor(color);
                  g.drawString(var2.Text[i], xPos + var6, var4 + (this.Height - this._font.getHeight()) / 2, 20);
                  var6 += this._font.stringWidth(var2.Text[i]);
               } else {
                  label62: {
                     var6++;
                     if (!SkipEmoji) {
                        if (Field233.containsKey(var2.Text[i]) || EmojiCache.contains(var2.Text[i])) {
                           Object img = Field233.get(var2.Text[i]);
                           if (img instanceof Image)
                           {
                              if (Settings.Instance.DebugDrawEmojiRed) {
                                 g.setColor(16711680);
                                 g.fillRect(xPos + var6, var4 + (this.Height - 16) / 2, ((Image)img).getWidth(), ((Image)img).getHeight());
                              }

                              g.drawImage((Image)img, xPos + var6, var4 + (this.Height - 16) / 2, 20);
                           } else {
                              g.setColor(Class6.ColorsInstanse.Field328);
                              g.fillRect(xPos + var6, var4 + (this.Height - 16) / 2, this.Height, this.Height);
                           }
                           break label62;
                        }

                        EmojiCache.addElement(var2.Text[i]);
                     }

                     g.setColor(Class6.ColorsInstanse.Field328);
                     g.fillRect(xPos + var6, var4 + (this.Height - 16) / 2, this.Height, this.Height);
                  }

                  var6 += 17;
               }
            }

            g.setColor(color);
            }
            catch(Exception ex)//
            {
            	int i =0;
            }
         }
      }
   }

   public static void Method89() {
      while(!SkipEmoji) {
         try {
            if (!EmojiCache.isEmpty() && Class198.Instance.Field627 != null && !Class198.Instance._recordStore.Field374) {
               for(int i = 0; i < EmojiCache.size(); i++) {
                  try {
                     String var1 = (String)EmojiCache.elementAt(i);
                     Logger.PrintToConsole("Trying to get emoji " + var1);
                     Image var2 = Class198.OpenImage("emoji/" + var1 + ".png");
                     if (var2 == null)
                     {
                        Logger.PrintToConsole("Failed to get emoji " + var1);
                     }

                     Field233.put(var1, var2 != null ? var2.toString() : "null");//todo: var2.toString()???
                     EmojiCache.removeElementAt(i);
                     --i;
                     Class198.Instance.Repaint();
                  } catch (OutOfMemoryError var3) {
                     throw var3;
                  } catch (Exception var4) {
                  }
               }
            }
            else
            {
               try
               {
                  Thread.sleep(3000L);
               } catch (Exception var5) {
               }
            }
         } catch (OutOfMemoryError var6) {
            EmojiCache.removeAllElements();
            Field233.clear();
            SkipEmoji = true;
            System.gc();
         }
      }

   }

   public final int Method90(Class277 var1) {
      if (var1 == null) {
         return 0;
      } else {
         int var2 = 0;

         for(int i = 0; i < var1.Field873.length; i++) {
            var2 += var1.Field873[i] == 1 ? 18 : this._font.stringWidth(var1.Text[i]);
         }

         return var2;
      }
   }

   public final Class277[] Method91(Class277 var1, int var2) {
      if (var1 != null && var1.Field876 != 0) {
         Vector var3 = new Vector();
         StringBuffer var4 = new StringBuffer();
         StringBuffer var5 = new StringBuffer();
         int var6 = 0;

         for(int i = 0; i < var1.Field873.length; i++) {
            if (var1.Field873[i] == 1) {
               if (var6 + this._font.stringWidth(var5.toString()) + 16 > var2) {
                  var6 = 0;
                  var3.addElement(new Class277(var4.toString()));
                  var5.setLength(0);
                  var4.setLength(0);
               }

               var6 += 18;
               var4.append(Class277.Method382(var1.Text[i]));
            } else {
               String var8 = var1.Text[i];

               for(int pos = 0; pos < var8.length(); pos++) {
                  if (var8.charAt(pos) == '\n') {
                     var6 = 0;
                     var3.addElement(new Class277(var4.toString()));
                     var5.setLength(0);
                     var4.setLength(0);
                  } else {
                     var4.append(var8.charAt(pos));
                     var5.append(var8.charAt(pos));
                     if (this._font.stringWidth(var5.toString()) + var6 > var2) {
                        if (var4.toString().lastIndexOf(32) != -1) {
                           String var10 = var4.toString();
                           var4.setLength(0);
                           var5.setLength(0);
                           var6 = 0;
                           int var11 = var10.lastIndexOf(32);
                           var3.addElement(new Class277(var10.substring(0, var11)));
                           var5.append(var10.substring(var11 + 1, var10.length()));
                           var4.append(var10.substring(var11 + 1, var10.length()));
                        } else {
                           var4.setLength(var4.length() - 1);
                           var3.addElement(new Class277(var4.toString()));
                           var4.setLength(0);
                           var5.setLength(0);
                           var6 = 0;
                           var4.append(var8.charAt(pos));
                           var5.append(var8.charAt(pos));
                        }
                     }
                  }
               }
            }
         }

         if (var4.length() > 0) {
            var3.addElement(new Class277(var4.toString()));
         }

         Class277[] var12 = new Class277[var3.size()];
         var3.copyInto(var12);
         return var12;
      } else {
         return new Class277[0];
      }
   }

   public final Class277 Method92(Class277 var1, int var2, boolean var3) {
      if (var1 != null && var1.Field876 != 0) {
         StringBuffer var4 = new StringBuffer();
         StringBuffer var5 = new StringBuffer();
         int var6 = 0;

         for(int i = 0; i < var1.Field873.length; i++) {
            if (var1.Field873[i] == 1) {
               if (var6 + this._font.stringWidth(var5.toString().trim() + (var3 ? "..." : "")) + 16 > var2) {
                  return new Class277(var4.toString().trim() + (var3 ? "..." : ""));
               }

               var6 += 18;
               var4.append(Class277.Method382(var1.Text[i]));
            } else {
               String var8 = var1.Text[i];

               for(int j = 0; j < var8.length(); j++) {
                  if (var8.charAt(j) == '\n') {
                     var4.append(' ');
                     var5.append(' ');
                  } else {
                     var4.append(var8.charAt(j));
                     var5.append(var8.charAt(j));
                  }

                  if (this._font.stringWidth(var5.toString().trim() + (var3 ? "..." : "")) + var6 > var2) {
                     var4.setLength(var4.length() - 1);
                     return new Class277(var4.toString().trim() + (var3 ? "..." : ""));
                  }
               }
            }
         }

         return new Class277(var4.toString());
      } else {
         return var1;
      }
   }

   public static Class277 Method93(Class277 var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else {
         int var2 = var0.Field873.length - 1;
         Class277 var3;
         (var3 = new Class277(null)).Field873 = new byte[var0.Field873.length];
         var3.Text = new String[var0.Text.length];
         var3.Field875 = var1 && var0.Field873.length != 0 ? var0.Field873[var2] == 1 : false;
         var3.Field876 = var0.Field876;

         for(int i = 0; i < var0.Field873.length - (var1 ? 1 : 0); i++) {
            var3.Field873[var2] = 0;
            if (var0.Field873[i] == 1) {
               var3.Text[i] = "*";
            } else {
               var3.Text[i] = Class328.Method165(var0.Text[i], false);
            }
         }

         if (var1 && var0.Field873.length != 0) {
            if (var0.Field873[var2] == 1) {
               var3.Field873[var2] = 1;
               var3.Text[var2] = var0.Text[var2];
            } else {
               var3.Field873[var2] = 0;
               var3.Text[var2] = Class328.Method165(var0.Text[var2], true);
            }
         }

         return var3;
      }
   }

   static {
      SkipEmoji = !Settings.Instance.HasEmoji;
      Field233 = new Hashtable();
      EmojiCache = new Vector();
   }
}
