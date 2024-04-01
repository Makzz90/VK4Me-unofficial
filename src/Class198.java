import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.Vector;
import javax.microedition.io.HttpConnection;
import javax.microedition.io.HttpsConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextBox;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Class198 extends Canvas {
   public boolean Field616 = false;
   private static int _maxSize = 3072;
   public static Class198 Instance;
   public static TextBox _texBox;
   public static TextBox2 Field620;
   boolean _inLoadingState;
   private Graphics _g;
   public Font _font;
   public Font _fontBold;
   public TextElement _tbNormal;
   public TextElement _tbBold;
   public Page Field627;
   double Field628;
   long Field629;
   Class36 Field630;
   public int Field631;
   public int Field632;
   public int Field633;
   public int Field634;
   public boolean Field635;
   //private boolean Field636;
   private boolean Field637;
   boolean Field638;
   private int Field639;
   private int Field640;
   private int _headerHeight;
   private int _headerIconHeight;
   private boolean Field643;
   private boolean Field644;
   public int HeaderHeight;
   public int Field646;
   private int Field647;
   public int Field648;
   public int imgH;
   private int Field650;
   private int Field651;
   private int Field652;
   public boolean _touchHud;
   private boolean _showHeader;
   private boolean _showFooter;
   private int Field656;
   private int Field657;
   public String Field658;
   public int _height;
   public int _width;
   private boolean IsForwardNavigation;
   RecordStoreHelper _recordStore;
   RecordStoreHelper _recordStore2;
   private Page NewPage;
   private Image PrevPageScreenImage;
   private Image NewPageScreenImage;
   private int Field666;
   int Field667;   
   byte Field669;
   private boolean Field670 = true;
   private boolean Field671;
   private boolean Field672;
   private boolean Field673;
   private boolean _slimHeader;
   private int Field675;
   public int CharSpaceWidth;
   int Field677;
   private Thread _thread;
   Vector Field679;
   private Image _img;
   private boolean Field681;
   private boolean Field682;
   private Class336 Field683;
   private Class336 Field684 = new Class257(this, null);
   public boolean _reverseSofts;
   Page _page;
   private int Field687;
   public int Field688;
   private static Player _player;

   //это используется как текст заголовка 
   public Class198() {
      Instance = this;
      this.setTitle("VK");//VK4ME
      this._width = this.getWidth();
      this._height = this.getHeight();
      //Runtime.getRuntime();
      this.Field637 = this.hasPointerEvents();
      this.Field638 = !this.Field637;
      this._tbNormal = new TextElement(this._font = Font.getFont(0, 0, Font.SIZE_SMALL));//myFont.getFontFace(), myFont.getFontStyle(), Font.SIZE_MEDIUM
      this._tbBold = new TextElement(this._fontBold = Font.getFont(0, 0, Font.SIZE_SMALL));//Font.STYLE_BOLD
      this.CharSpaceWidth = this._font.charWidth(' ');

      try {
         TextBox var1 = new TextBox("", "", 3072, 0);
         if (var1.getMaxSize() < _maxSize) {
            _maxSize = var1.getMaxSize();
         }
      } catch (Throwable var2) {
         _maxSize = 3072;
      }

      this.Field679 = new Vector();
      System.gc();
   }

   protected final void paint(Graphics g) {
      try {
         long var2 = System.currentTimeMillis();
         if (this._g == null || this._width != this.getWidth() || this._height != this.getHeight()) {
            this._g = g;
            this.Method464(false);
            if (!this.Field670) {
               this.DrawNavigationImages();
            }
         }

         this._g = g;
         if (this.Field670)
         {//
            Class252.Method328(this._g, 0, 0, this.getWidth(), this.getHeight(), Class6.ColorsInstanse.Field284, Class6.ColorsInstanse.Field285);
            this.Field675 = Class6.ColorsInstanse.Method140(this._g, this.getWidth() / 2, this.getHeight() / 2, this.Field675, "new/logo-outline.rle", Class6.ColorsInstanse.Field287, Class6.ColorsInstanse.Field288, Math.min(this.getWidth() / 3, this.getHeight() / 3), 3);
         }

         if (!this.Field670) {
            if (Class6.Field13.Field374)
            {
               Class6.Method338();
            }

            boolean var4;
            if (!(var4 = this.Field630 != null && this.Field630.Field63 && this.Field630.Field62) || this.Field630.Field64) {
               this._g.setColor(Class6.ColorsInstanse.Field291);
               this._g.fillRect(0, 0, this.getWidth(), this.getHeight());
               this.DrawNavigationImages();
               boolean var6 = false;
               
               if (this.Field627 != null && this.Field646 < this.Field627.ScrollableHeight) {
                  if (this._recordStore2.Field374)
                  {
                     var6 = true;
                     if (this._recordStore2.Method156()) {
                        if (this._recordStore2.Field379 <= 0) {
                           this.Field669 = -1;
                        } else if (this._recordStore2.Field379 >= 6) {
                           this.Field669 = 1;
                        }
                     }
                  }

                  Image var7;
                  if (this._recordStore2.Field379 != 0 && (var7 = Class252.Method322(Class6.ColorsInstanse.Field359, Math.max(this._width, this._height), this._recordStore2.Field379)) != null) {
                     this._g.drawRegion(var7, 0, 0, this.Field648, this.Field646 * this.Field646 / this.Field627.ScrollableHeight, 0, this.Field647, this.HeaderHeight + this.Field627.VerticalScroll * this.Field646 / this.Field627.ScrollableHeight, 20);
                  }
               }

               if (var6) {
                  this.Repaint();
               }

               Class198 var5;
               int var12;
               if (this._touchHud)
               {
            	   
                  var5 = this;
                  
                  Class252.Method328(this._g, 0, 0, this._width, this._headerHeight, Class6.ColorsInstanse.Field284, Class6.ColorsInstanse.Field285);
                  
                  var12 = Settings.Instance.ShiftTitleRight ? 22 : 0;
                  int var13 = this.CharSpaceWidth + this.CharSpaceWidth;
            	   
                  
                  if (this._inLoadingState || this.Field683 != null)
                  {
                     if (this.Field643)
                     {
                        Class252.Method328(this._g, var12, 0, this._headerHeight, this._headerHeight, Class6.ColorsInstanse.Field289, Class6.ColorsInstanse.Field290);
                     }

                     if (this._inLoadingState)
                     {
                        byte var8;
                        switch(this.Field667) {
                        case 1:
                           var8 = 5;
                           break;
                        case 2:
                           var8 = 3;
                           break;
                        case 3:
                           var8 = 6;
                           break;
                        default:
                           var8 = 0;
                        }

                        this.Field666 = Class6.ColorsInstanse.Method141(this._g, var12 + this._headerHeight / 2, this._headerHeight / 2, this.Field666, "new/loading.rle", Class6.ColorsInstanse.Field287, Class6.ColorsInstanse.Field288, this._headerIconHeight, var8, 3);
                     }
                     else if (Settings.Instance.GuiUseDrawer && LoginForm.HomePage != null)
                     {
                        this.Field687 = Class6.ColorsInstanse.Method140(this._g, var12 + this._headerHeight / 2, this._headerHeight / 2, this.Field687, "new/menu.rle", Class6.ColorsInstanse.Field287, Class6.ColorsInstanse.Field288, this._headerIconHeight, 3);
                     }
                     else
                     {
                        this.Field656 = Class6.ColorsInstanse.Method140(this._g, var12 + this._headerHeight / 2, this._headerHeight / 2, this.Field656, "new/arrow-left.rle", Class6.ColorsInstanse.Field287, Class6.ColorsInstanse.Field288, this._headerIconHeight, 3);
                     }

                     var12 += this._headerHeight;
                  }

                  var12 += this.CharSpaceWidth + this.CharSpaceWidth;
                  if (Class248.arrayIndex != -1 && Class248.charIndex != -1)
                  {
                	  
                     this._g.setColor(Class6.ColorsInstanse.Field286);
                     this._g.setFont(this._fontBold);

                     char[] chs = ( Class248._textModicator / 2 == 0 ? Class248.engDict[Class248.arrayIndex] : Class248.rusDict[Class248.arrayIndex]);
                     for(int i = chs.length - 1; i >= 0; i--) {
                        if (Class248._textModicator % 2 == 1) {
                           chs[i] = Character.toUpperCase(chs[i]);
                        }

                        int var10 = var5._fontBold.charWidth(chs[i]);
                        if (Class248.charIndex == i) {
                           Class252.Method328(var5._g, var5._width - var13 - var10, var5.Field652, var10, var5._fontBold.getHeight(), Class6.ColorsInstanse.Field289, Class6.ColorsInstanse.Field290);
                        }

                        var5._g.drawChar(chs[i], var5._width - var13, var5.Field652, 24);
                        var13 += var10;
                     }

                     var13 += var5.CharSpaceWidth + var5.CharSpaceWidth;
                	  
                     
                  } else if (Class248.arrayIndex != 11 && Class248.arrayIndex != 10)
                  {
                     if (this.Field627 != null && this.Field627.Method29() != null) {
                        var13 = this._headerHeight + this.CharSpaceWidth + this.CharSpaceWidth;
                        if (this.Field644) {
                           Class252.Method328(this._g, this._width - this._headerHeight, 0, this._headerHeight, this._headerHeight, Class6.ColorsInstanse.Field289, Class6.ColorsInstanse.Field290);
                        }

                        this.Field657 = Class6.ColorsInstanse.Method140(this._g, this._width - this._headerHeight / 2, this._headerHeight / 2, this.Field657, "new/dots-vertical.rle", Class6.ColorsInstanse.Field287, Class6.ColorsInstanse.Field288, this._headerIconHeight, 3);
                     }
                	  
                  }
                  else {
                     this._g.setColor(Class6.ColorsInstanse.Field286);
                     this._g.setFont(this._fontBold);
                     String var14 = "Bksp";
                     if (Class248.arrayIndex == 11) {
                        switch(Class248._textModicator) {
                        case 0:
                           var14 = "eng";
                           break;
                        case 1:
                           var14 = "ENG";
                           break;
                        case 2:
                           var14 = "СЂСѓСЃ";
                           break;
                        case 3:
                           var14 = "Р РЈРЎ";
                        }
                     }

                     this._g.drawString(var14, this._width - var13, this.Field652, 24);
                     var13 += this.CharSpaceWidth + this.CharSpaceWidth + this._fontBold.stringWidth(var14);
                  }

                  if (var5.Field627.Title != null) {
                     Class252.DrawRle(var5._g, var12, var5.Field652, var5.Field627.Title, 1, Class6.ColorsInstanse.Field349, Class6.ColorsInstanse.Field349, Button.Field263, 20);
                     var12 += Button.Field263 + var5.CharSpaceWidth;
                  }


                  
                  int var16 = var5._width - var12 - var13;
                  if (var5.Field627 != null && var5.Field627.Field819 != null && (var5.Field627.Field820 == null || var5.Field627.Field821 != var16)) {
                     var5.Field627.Field820 = var5._tbBold.Method92(var5.Field627.Field819, var16, true);
                     var5.Field627.Field821 = var16;
                  }

                  if (var5.Field627 != null && var5.Field627.Field820 != null) {
                     var5._g.setColor(Class6.ColorsInstanse.Field286);
                     var5._tbBold.Draw(var5._g, var5.Field627.Field820, var12, var5.Field652, 20);
                  }

                  if (this.Field673) {
                     Class252.Method328(this._g, 0, this.Field640, this._width, this.Field639, Class6.ColorsInstanse.Field284, Class6.ColorsInstanse.Field285);
                  }
                 
               }
               else
               {
                  this.Method463();
                  this.Method462();
               }

               if (var4) {
                  var5 = this;
                  if (!Settings.Instance.RenderDimm)
                  {
                     if (this._img == null) {
                        this.Method494();
                     }

                     for(var12 = 0; var12 < var5._height; var12 += 10) {
                        var5._g.drawImage(var5._img, 0, var12, 0);
                     }
                  }
               }
            }

            if (var4) {
               this.Field630.Method292(this._g, 0);
            }

            if (Settings.Instance.DebugDrawFPS) {
               this.Method461(g, var2);
            }

            if (Settings.Instance.DebugLongPoll) {
               g.setColor(this.Field616 ? '\uff00' : (LongPollInstanse.IsAppPaused ? 16776960 : 16711680));
               g.fillRect(this._width - 20, 0, 20, 20);
            }

         }
      } catch (Throwable var11) {
         if (var11 instanceof OutOfMemoryError) {
            this.Method464(true);
         }

         this.ShowError(var11);
      }
   }

   private void Method461(Graphics g, long var2) {
      int var8;
      if ((var8 = (int)(System.currentTimeMillis() - var2)) == 0) {
         var8 = 1;
      }

      int var3 = 1000 / var8;
      int var4 = this._fontBold.getHeight();
      String var9 = "Paint time: " + var8;
      String var5 = "FPS: " + var3;
      Runtime var6 = Runtime.getRuntime();
      String var10 = (var6.totalMemory() - var6.freeMemory()) / 1024L + " / " + var6.totalMemory() / 1024L + " KiB";
      g.setColor(this.Field671 ? 8388608 : 0);
      this.Field671 = false;
      g.fillRect(0, 0, 8 + Math.max(this._fontBold.stringWidth(var9), Math.max(this._fontBold.stringWidth(var5), this._fontBold.stringWidth(var10))), var4 * 3 + 8 + 4);
      int var7 = 16711680;
      if (var3 >= 40) {
         var7 = 65501;
      } else if (var3 >= 30) {
         var7 = 65280;
      } else if (var3 >= 20) {
         var7 = 16776960;
      } else if (var3 >= 15) {
         var7 = 16744448;
      }

      g.setColor(var7);
      g.setFont(this._fontBold);
      g.drawString(var9, 4, 4, 0);
      g.drawString(var5, 4, var4 + 4 + 2, 0);
      g.drawString(var10, 4, var4 + 4 + 2 + var4 + 2, 0);
   }

   private void Method462() {
      if (this._showHeader) {
         Class252.Method328(this._g, 0, 0, this._width, this._headerHeight, Class6.ColorsInstanse.Field284, Class6.ColorsInstanse.Field285);
         int var1 = this.CharSpaceWidth + this.CharSpaceWidth;
         if (Class248.arrayIndex != -1 && Class248.charIndex != -1) {
            this._g.setColor(Class6.ColorsInstanse.Field286);
            this._g.setFont(this._fontBold);

            char[] var6 = ( Class248._textModicator / 2 == 0 ? Class248.engDict[Class248.arrayIndex] : Class248.rusDict[Class248.arrayIndex]);
            for(int i = var6.length - 1; i >= 0; i--) {
               if (Class248._textModicator % 2 == 1) {
                  var6[i] = Character.toUpperCase(var6[i]);
               }

               int var4 = this._fontBold.charWidth(var6[i]);
               if (Class248.charIndex == i) {
                  Class252.Method328(this._g, this._width - var1 - var4, this.Field652, var4, this._fontBold.getHeight(), Class6.ColorsInstanse.Field289, Class6.ColorsInstanse.Field290);
               }

               this._g.drawChar(var6[i], this._width - var1, this.Field652, 24);
               var1 += var4;
            }

            var1 += this.CharSpaceWidth + this.CharSpaceWidth;
         } else if (Class248.arrayIndex != 11 && Class248.arrayIndex != 10) {
            if (this._inLoadingState) {
               byte var5;
               switch(this.Field667) {
               case 1:
                  var5 = 5;
                  break;
               case 2:
                  var5 = 3;
                  break;
               case 3:
                  var5 = 6;
                  break;
               default:
                  var5 = 0;
               }

               this.Field666 = Class6.ColorsInstanse.Method141(this._g, this._width - var1, this._headerHeight / 2, this.Field666, "new/loading.rle", Class6.ColorsInstanse.Field287, Class6.ColorsInstanse.Field288, this._headerIconHeight, var5, 10);
               var1 = this.CharSpaceWidth + this.CharSpaceWidth + this._headerHeight + this.CharSpaceWidth + this.CharSpaceWidth;
            }
         } else {
            this._g.setColor(Class6.ColorsInstanse.Field286);
            this._g.setFont(this._fontBold);
            String var2 = "Bksp";
            if (Class248.arrayIndex == 11) {
               switch(Class248._textModicator) {
               case 0:
                  var2 = "eng";
                  break;
               case 1:
                  var2 = "ENG";
                  break;
               case 2:
                  var2 = "рус";
                  break;
               case 3:
                  var2 = "РУС";
               }
            }

            this._g.drawString(var2, this._width - var1, this.Field652, 24);
            var1 += this.CharSpaceWidth + this.CharSpaceWidth + this._fontBold.stringWidth(var2);
         }

         int var7 = this._width - this.CharSpaceWidth - this.CharSpaceWidth - var1 - (Settings.Instance.ShiftTitleRight ? 22 : 0);
         if (this.Field627.Title != null) {
            Class252.DrawRle(this._g, this.CharSpaceWidth + this.CharSpaceWidth + (Settings.Instance.ShiftTitleRight ? 22 : 0), this.Field652, this.Field627.Title, 1, Class6.ColorsInstanse.Field349, Class6.ColorsInstanse.Field349, Button.Field263, 20);
            var7 -= Button.Field263 + this.CharSpaceWidth;
         }

         if (this.Field627 != null && this.Field627.Field819 != null && (this.Field627.Field820 == null || this.Field627.Field821 != var7)) {
            this.Field627.Field820 = this._tbBold.Method92(this.Field627.Field819, var7, true);
            this.Field627.Field821 = var7;
         }

         if (this.Field627 != null && this.Field627.Field820 != null) {
            this._g.setColor(Class6.ColorsInstanse.Field286);
            this._tbBold.Draw(this._g, this.Field627.Field820, this.CharSpaceWidth + this.CharSpaceWidth + (Settings.Instance.ShiftTitleRight ? 22 : 0) + (this.Field627.Title != null ? Button.Field263 + this.CharSpaceWidth : 0), this.Field652, 20);
         }

      }
   }

   private void Method463() {
      String var1 = this.Method475() ? (this.Field627.Method368() instanceof Class376 ? this.Field627.Method29() : Localized.GetString("action.erase")) : (this.Field627 != null ? this.Field627.Method29() : null);
      if ((this.Field684.Field972 != null || var1 != null) && (this.Field684.Field972 == null || var1 == null || var1.intern() != this.Field684.Field972)) {
         if (this.Field684.Field971 != null) {
            this.removeCommand(this.Field684.Field971);
         }

         this.Field684.Method133(var1);
         if (this.Field684.Field971 != null && !this._showFooter) {
            this.addCommand(this.Field684.Field971);
         }
      }

      if (this._showFooter) {
         Class336 var5 = this.Field684.Field972 == null ? null : this.Field684;
         Class336 var2 = this._reverseSofts ? var5 : this.Field683;
         var5 = this._reverseSofts ? this.Field683 : var5;
         Class252.Method328(this._g, 0, this.Field640, this._width, this.Field639, Class6.ColorsInstanse.Field284, Class6.ColorsInstanse.Field285);
         int var3 = Math.max(0, this._width / 2 - (this.Field658 == null ? 0 : this._fontBold.stringWidth(this.Field658)) / 2 - (this.CharSpaceWidth << 1));
         int var4;
         if (var2 != null) {
            if (var2.Field974 == null || var2.Field973 != var3) {
               var2.Field973 = var3;
               var2.Field974 = Class328.Method164(var2.Field972, var2.Field973, true, this._font);
            }

            var4 = Math.min(var3, this._font.stringWidth(var2.Field974) + (this.CharSpaceWidth << 2));
            if (this.Field643) {
               Class252.Method328(this._g, 0, this.Field640, var4, this.Field639, Class6.ColorsInstanse.Field289, Class6.ColorsInstanse.Field290);
            }

            this._g.setColor(Class6.ColorsInstanse.Field286);
            this._g.setFont(this._font);
            this._g.drawString(var2.Field974, var4 / 2, this.Field640 + this.Field650, 17);
         }

         if (var5 != null) {
            if (var5.Field974 == null || var5.Field973 != var3) {
               var5.Field973 = var3;
               var5.Field974 = Class328.Method164(var5.Field972, var5.Field973, true, this._font);
            }

            var4 = Math.min(var3, this._font.stringWidth(var5.Field974) + (this.CharSpaceWidth << 2));
            if (this.Field644) {
               Class252.Method328(this._g, this.getWidth() - var4, this.Field640, var4, this.Field639, Class6.ColorsInstanse.Field289, Class6.ColorsInstanse.Field290);
            }

            this._g.setColor(Class6.ColorsInstanse.Field286);
            this._g.setFont(this._font);
            this._g.drawString(var5.Field974, this.getWidth() - var4 / 2, this.Field640 + this.Field650, 17);
         }

         if (this.Field658 != null) {
            this._g.setColor(Class6.ColorsInstanse.Field286);
            this._g.setFont(this._fontBold);
            this._g.drawString(this.Field658, this.getWidth() / 2, this.Field640 + this.Field651, 17);
         }

      }
   }

   public final void Method464(boolean var1) {
      if (var1) {
         this.Field679.removeAllElements();
         Class252.Method321();
         Class252.Method320();
         Class6.ColorsInstanse.Method142();
         if (this.Field627 != null) {
            this.Field627.Field809.clear();
         }
      }

      this.Field671 = true;
      this.Field677 = (this.getWidth() << 1) / 3;
      if (var1 || Settings.Instance.RenderDimm) {
         this._img = null;
      }

      this._width = this.getWidth();
      this._height = this.getHeight();
      this.Method493();
      this.Field630 = null;
      if (var1) {
         this._g = null;
      }

      this.PrevPageScreenImage = null;
      this.NewPageScreenImage = null;
      System.gc();
      //this.Field636 = false;
      this._reverseSofts = Settings.Instance.GuiReverseSofts;
      this._touchHud = Settings.Instance.GuiTouchHud;
      this._showHeader = Settings.Instance.GuiShowHeader || this._touchHud || Settings.Instance.GuiFullscreen;
      this._showFooter = Settings.Instance.GuiShowFooter /*|| this._touchHud || Settings.Instance.GuiFullscreen*/;
      this.Field673 = false;
      this._slimHeader = Settings.Instance.GuiSlimHeader && this._touchHud;
      if (!Settings.Instance.GuiUseDrawer || !this._touchHud) {
         this._page = null;
         if (LoginForm.HomePage != null) {
            LoginForm.HomePage.Method361(null);
         }
      }

      this.setCommandListener(this._showFooter ? null : new Class259(this));
      if (this._showFooter) {
         if (this.Field684.Field971 != null) {
            this.removeCommand(this.Field684.Field971);
         }

         if (this.Field683 != null && this.Field683.Field971 != null) {
            this.removeCommand(this.Field683.Field971);
         }
      } else {
         if (this.Field684.Field971 != null) {
            this.addCommand(this.Field684.Field971);
         }

         if (this.Field683 != null && this.Field683.Field971 != null) {
            this.addCommand(this.Field683.Field971);
         }
      }

      this.Field639 = this._touchHud ? this._tbNormal.Height * 5 / 2 : this._tbNormal.Height * 3 / 2;
      this._headerHeight = this._touchHud && !this._slimHeader ? this._tbNormal.Height * 5 / 2 : this._tbNormal.Height * 3 / 2;
      this.HeaderHeight = this._showHeader ? this._headerHeight : 0;
      this._headerIconHeight = this._headerHeight - (this._touchHud && !this._slimHeader ? this._tbNormal.Height * 5 / 4 : this._tbNormal.Height / 4);
      this.Field640 = this.getHeight() - ((!this._touchHud || !this.Field673) && (this._touchHud || !this._showFooter) ? 0 : this.Field639);
      this.imgH = this.Field646 = this._height - this.HeaderHeight;
      if (this._touchHud && this.Field673 || !this._touchHud && this._showFooter) {
         this.imgH -= this.Field639;
      }

      this.Field648 = this._tbNormal.Height / 4;
      this.Field647 = this.getWidth() - this.Field648;
      this.Field650 = (this.Field639 - this._tbNormal.Height) / 2;
      this.Field651 = (this.Field639 - this._tbBold.Height) / 2;
      this.Field652 = (this._headerHeight - this._tbBold.Height) / 2;
      this.IsForwardNavigation = false;
      this._recordStore = new RecordStoreHelper(2);
      this.Method467();
      this.NewPage = null;
      this._recordStore2 = new RecordStoreHelper(2);
      if (this.Field627 != null) {
         this.Field627.Field824 = this.imgH;
         this.setTitle(this.Field627.Field819 == null ? "VK" : this.Field627.Field819.toString());//VK4ME
      }

      double var2;
      this.Field628 = ((var2 = (double)this.getWidth()) * var2 + (var2 = (double)this.getHeight()) * var2) / 41984.0D;
      if (!this.Field672) {
         (new Timer()).schedule(new TimerEx(this), 0L, 1000L);
         (new Timer()).schedule(new Class256(this), 0L, 200L);//!!!!!!!
         (new Class251(this)).start();
         this.Field672 = true;
      }

   }

   protected final void pointerPressed(int var1, int var2) {
      LongPollInstanse.IsAppPaused = false;
      this.Field688 = 0;
      if (!this.Field637) {
         this.Field637 = true;
         this.Method464(false);
      }

      this.Field638 = false;
      this.Field635 = true;
      this.Field633 = var1;
      this.Field634 = var2;
      this.Field631 = var1;
      this.Field632 = var2;
      if (this.Method492()) {
         this.Field630.Method62(var1, var2);
         this.Repaint();
      } else {
         if (var2 >= this.Field640 && !this._touchHud && this._showFooter || var2 < this._headerHeight && this._touchHud) {
            var2 = this._touchHud ? this._headerHeight : this.getWidth() / 2;
            this.Field681 = true;
            if (var1 < var2) {
               this.Field643 = true;
            } else if (var1 >= this.getWidth() - var2) {
               this.Field644 = true;
            }
         } else if (var2 < this.HeaderHeight) {
            this.Field682 = true;
         } else {
            this.Field681 = false;
            this.Field682 = false;
            if (this.Field627 != null) {
               this.Field627.Method62(var1, var2);
            }
         }

         this.Repaint();
      }
   }

   protected final void pointerReleased(int var1, int var2) {
      LongPollInstanse.IsAppPaused = false;
      this.Field688 = 0;
      if (!this.Field637) {
         this.Field637 = true;
         this.Method464(false);
      }

      this.Field635 = false;
      this.Field633 = this.Field631;
      this.Field634 = this.Field632;
      this.Field631 = var1;
      this.Field632 = var2;
      if (this.Method492()) {
         try {
			this.Field630.Method63(var1, var2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         this.Repaint();
      } else {
         int var3 = this._touchHud ? this._headerHeight : this.getWidth() / 2;
         boolean var4 = var2 >= this.Field640 && !this._touchHud && this._showFooter || var2 < this._headerHeight && this._touchHud;
         if (this.Field643) {
            this.Field643 = false;
            if (var4 && var1 < var3 && this.Field683 != null) {
               if (!this._touchHud && this._reverseSofts) {
                  if (this.Method475() && !this._touchHud) {
                     Class248.Method230(1000010, this.Field627.Method368());
                  } else {
                     if (this.Field630 != null) {
                        this.Field630.Field62 = false;
                     }

                     if (this.Field684 != null) {
                        this.Field684.Method134();
                     }
                  }
               } else if (this.Field683 != null) {
                  this.Field683.Method134();
               }
            }
         } else if (this.Field644) {
            this.Field644 = false;
            if (var4 && var1 >= this.getWidth() - var3) {
               if (this._reverseSofts && !this._touchHud) {
                  if (this.Field683 != null) {
                     this.Field683.Method134();
                  }
               } else if (this.Method475() && !this._touchHud) {
                  Class248.Method230(1000010, this.Field627.Method368());
               } else {
                  if (this.Field630 != null) {
                     this.Field630.Field62 = false;
                  }

                  if (this.Field684 != null) {
                     this.Field684.Method134();
                  }
               }
            }
         } else if (!this.Field681 && !this.Field682 && this.Field627 != null) {
            try {
				this.Field627.Method63(var1, var2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }

         this.Repaint();
      }
   }

   protected final void pointerDragged(int var1, int var2) {
      LongPollInstanse.IsAppPaused = false;
      this.Field688 = 0;
      if (!this.Field637) {
         this.Field637 = true;
         this.Method464(false);
      }

      this.Field635 = true;
      this.Field633 = this.Field631;
      this.Field634 = this.Field632;
      this.Field631 = var1;
      this.Field632 = var2;
      if (this.Method492()) {
         this.Method470();
         this.Field630.Method64(var1, var2);
         this.Repaint();
      } else {
         if (this.Field627 != null && !this.Field681 && !this.Field682) {
            this.Method470();
            this.Field627.Method64(var1, var2);
         }

         this.Repaint();
      }
   }

   private void DrawNavigationImages() {
      int width;
      if (this.Field627 != null) {
         if (this._recordStore.Field374) {
            if (this.PrevPageScreenImage == null) {
               this.PrevPageScreenImage = Image.createImage(this.getWidth(), this.imgH);
               width = this.HeaderHeight;
               this.HeaderHeight = 0;
               this.Field627.Method292(this.PrevPageScreenImage.getGraphics(), 0);
               this.HeaderHeight = width;
            }

            this._g.drawImage(this.PrevPageScreenImage, this._recordStore.Field379, this.HeaderHeight, 20);
         } else {
            this.Field627.Method292(this._g, this._recordStore.Field379);
         }
      }

      if (this.NewPage != null) {
         width = this._recordStore.Field379 + (this.IsForwardNavigation ? this.getWidth() : -this.getWidth());
         if (this._recordStore.Field374)
         {
            if (this.NewPageScreenImage == null)
            {
               this.NewPageScreenImage = Image.createImage(this.getWidth(), this.imgH);
               int var2 = this.HeaderHeight;
               this.HeaderHeight = 0;
               this.NewPage.Method292(this.NewPageScreenImage.getGraphics(), 0);
               this.HeaderHeight = var2;
            }

            this._g.drawImage(this.NewPageScreenImage, width, this.HeaderHeight, 20);
         }
         else
         {
            this.NewPage.Method292(this._g, width);
         }
      }

      boolean var3 = this._recordStore.Field374;
      if (this._recordStore.Field374 && this._recordStore.Method156()) {
         this.Method467();
      }

      if (var3)
      {
         this.Repaint();
      }
   }

   private void Method466(Page page, boolean var2) {
      this.Method467();
      if (page != null && (this.Field627 == null || !this.Field627.equals(page))) {
         if (this.Field627 instanceof ConversationsPage) {
            ((ConversationsPage)this.Field627).Method283(null, 0);
         }

         this._page = null;
         if (this.Field627 == null) {
            this.Field627 = page;
            this.Field627.Method118();
            this.setTitle(this.Field627.Field819 == null ? "VK" : this.Field627.Field819.toString());//VK4ME
            this.Method467();
         } else {
            if (!(this.Field627 instanceof ConversationsPage) && (LoginForm.HomePage == null || !LoginForm.HomePage.equals(this.Field627))) {
               this.Field627.Field809.clear();
            }

            System.gc();
            if (Settings.Instance.GuiAnimations)
            {
            	//Анимация перехода по страницам
               this.NewPage = page;
               this.IsForwardNavigation = !var2;
               this._recordStore.Field378 = (var2 ? 1 : -1) * this.getWidth();
               this._recordStore.SetAnimationDuration(200);//время анимации
            }
            else
            {
               this.Field627 = page;
               this.Field627.Method118();
               this.setTitle(this.Field627.Field819 == null ? "VK" : this.Field627.Field819.toString());//VK4ME
            }

            if (this.Field627 instanceof Class247)
            {
               ((Class247)this.Field627).Method0();
            }

            this.Repaint();
         }
      }
   }

   private void Method467() {
      if (Settings.Instance.GuiAnimations) {
         if (this.NewPage != null) {
            this.Field627 = this.NewPage;
            this.Field627.Method118();
            this.setTitle(this.Field627.Field819 == null ? "VK" : this.Field627.Field819.toString());//VK4ME
         }

         this._recordStore.Field378 = 0;
         this._recordStore.Method155();
         this.IsForwardNavigation = false;
         this.NewPage = null;
         this.PrevPageScreenImage = null;
         this.NewPageScreenImage = null;
         this.Repaint();
      }
   }

   public final void NavigateBack(Page page) {
      this.Method466(page, true);
   }

   public final void NavigateForward(Page page) {
      this.Method466(page, false);
   }

   public final void Method470() {
      if (Settings.Instance.GuiAnimations) {
         this._recordStore2.Field378 = 6;
         this._recordStore2.Method153(100);
      } else {
         this._recordStore2.Field379 = 6;
         this.Field669 = 1;
      }
   }

   public final void Method471(TextBox2 var1) {
      if (var1 != null) {
         Field620 = var1;//VK4ME
         (_texBox = new TextBox(var1.Field478 == null ? "VK" : var1.Field478.toString(), var1.Field477 == null ? "" : var1.Field477.toString(), Settings.Instance.IncreaseTextLimit ? _maxSize : 500, 0)).setCommandListener(new Class253(this));
         _texBox.addCommand(new Command(Localized.GetString("action.ok"), 4, 1));
         _texBox.addCommand(new Command(Localized.GetString("action.close"), 2, 1));
         Display.getDisplay(Midlet.Instance).setCurrent(_texBox);
      }
   }

   public final void Method472() {
      if (this.Field630 != null) {
         this.Field630.Field64 = this.Field630.Field62;
      }

      this.setFullScreenMode( Settings.Instance.GuiFullscreen);
      Display.getDisplay(Midlet.Instance).setCurrent(this);
      this.Repaint();
      Field620 = null;
      _texBox = null;
   }

   protected final void keyPressed(int code) {
	   //
	   //1 up
	   //6 down
	   //5 right
	   //2 left
	   //8 ok
	   
      LongPollInstanse.IsAppPaused = false;
      this.Field688 = 0;
      code = this.GetButtonCode(code);
      this.Field638 = /*this.Field638 ||*/ code == 6 || code == 1;
      if (this.Method492()) {
         if (this.Field630.Method117() && Class248.Method232(code)) {
            Class248.Method230(code, this.Field630.Method368());
         } else {
            this.Field630.Method67(code);
         }

         this.Repaint();
      } else {
         if (code == -11) {
            if (this.Field627 != null && this.Field627.Field807 != null) {
               Page var2 = this.Field627.Field807;
               this.Method466(var2, true);
            }
         } else if (code == 1000001) {
            this.Field643 = true;
            if (!this._touchHud && this._reverseSofts) {
               if (this.Method475()) {
                  Class248.Method230(1000010, this.Field627.Method368());
               } else {
                  if (this.Field630 != null) {
                     this.Field630.Field62 = false;
                  }

                  if (this.Field684 != null) {
                     this.Field684.Method134();
                  }
               }
            } else if (this.Field683 != null) {
               this.Field683.Method134();
            }
         } else if (code == 1000002) {
            this.Field644 = true;
            if (!this._touchHud && this._reverseSofts) {
               if (this.Field683 != null) {
                  this.Field683.Method134();
               }
            } else if (this.Method475()) {
               Class248.Method230(1000010, this.Field627.Method368());
            } else {
               if (this.Field630 != null) {
                  this.Field630.Field62 = false;
               }

               if (this.Field684 != null) {
                  this.Field684.Method134();
               }
            }
         } else if (code == 2) {
            if (this.Field627 != null) {
               this.Field627.Method67(code);
            }
         } else if (code == 5) {
            if (this.Field627 != null) {
               this.Field627.Method67(code);
            }
         } else if (code == 1 || code == 50 && !this.Method475()) {
            if (this.Field627 != null) {
               this.Field627.Method67(code);
            }
         } else if (code != 6 && (code != 56 || this.Method475())) {
            if (this.Method475() && Class248.Method232(code)) {
               Class248.Method230(code, this.Field627.Method368());
            } else if (code == 1000010 && this.Method476()) {
               if (this.Field683 != null) {
                  this.Field683.Method134();
               }
            } else if (this.Field627 != null) {
               this.Field627.Method67(code);
            }
         } else if (this.Field627 != null) {
            this.Field627.Method67(code);
         }

         this.Repaint();
      }
   }

   protected final void keyRepeated(int key) {
      LongPollInstanse.IsAppPaused = false;
      this.Field688 = 0;
      key = this.GetButtonCode(key);
      if (this.Method492()) {
         if (this.Field630.Method117() && Class248.Method232(key)) {
            Class248.Method231(key, this.Field630.Method368());
         } else {
            this.Field630.Method65(key);
         }

         this.Repaint();
      } else {
         if (key == -11) {
            if (Settings.Instance.IsAutorized()) {
               LoginForm.Method265();
            }
         } else if (key == 2) {
            if (this.Field627 != null) {
               this.Field627.Method65(key);
            }
         } else if (key == 5) {
            if (this.Field627 != null) {
               this.Field627.Method65(key);
            }
         } else if (key == 1) {
            if (this.Field627 != null) {
               this.Field627.Method65(key);
            }
         } else if (key == 6) {
            if (this.Field627 != null) {
               this.Field627.Method65(key);
            }
         } else if (key == 1000002) {
            this.Field644 = true;
            if (!this._touchHud && this._reverseSofts) {
               if (Settings.Instance.IsAutorized()) {
                  LoginForm.Method265();
               }
            } else if (this.Method475()) {
               Class248.Method231(1000010, this.Field627.Method368());
            }
         } else if (key == 1000001) {
            this.Field643 = true;
            if (!this._touchHud && this._reverseSofts) {
               if (this.Method475()) {
                  Class248.Method231(1000010, this.Field627.Method368());
               }
            } else if (Settings.Instance.IsAutorized()) {
               LoginForm.Method265();
            }
         } else if (this.Method475() && Class248.Method232(key)) {
            Class248.Method231(key, this.Field627.Method368());
         } else if (key == 1000010 && this.Method476()) {
            if (Settings.Instance.IsAutorized()) {
               LoginForm.Method265();
            }
         } else if (this.Field627 != null) {
            this.Field627.Method65(key);
         }

         this.Repaint();
      }
   }

   protected final void keyReleased(int code) {
      LongPollInstanse.IsAppPaused = false;
      this.Field688 = 0;
      if ((code = this.GetButtonCode(code)) == 1000001) {
         this.Field643 = false;
      } else if (code == 1000002) {
         this.Field644 = false;
      }

      if (this.Method492()) {
         if (!this.Field630.Method117()) {
            try {
				this.Field630.ButtonPressed(code);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }

         this.Repaint();
      } else {
         if (code != -11) {
            if (code == 1000001) {
               this.Field643 = false;
            } else if (code == 1000002) {
               this.Field644 = false;
            } else {
               label38: {
                  if (code == 8) {
                     if (this.Field627 == null) {
                        break label38;
                     }
                  } else if (this.Field627 == null || this.Method475() && Class248.Method232(code)) {
                     break label38;
                  }

                  try {
					this.Field627.ButtonPressed(code);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               }
            }
         }

         this.Repaint();
      }
   }

   private int GetButtonCode(int button) {
      if (button == -11) {
         return -11;
      } else {
         try {
            label122: {
               String btnName = this.getKeyName(button).toLowerCase();
               System.out.println(btnName);
               if (!"soft1".equals(btnName) && !"soft 1".equals(btnName) && !"soft_1".equals(btnName) && !"softkey 1".equals(btnName) && !"sk2(left)".equals(btnName) && !btnName.startsWith("left soft")) {
                  if (!"soft2".equals(btnName) && !"soft 2".equals(btnName) && !"soft_2".equals(btnName) && !"softkey 4".equals(btnName) && !"sk1(right)".equals(btnName) && !btnName.startsWith("right soft")) {
                     if (!"on/off".equals(btnName) && !"back".equals(btnName)) {
                        if (!"trackball".equals(btnName) && !"select".equals(btnName)) {
                           if ("enter".equals(btnName)) {
                              return 1000011;
                           }

                           if (!"backspace".equals(btnName) && !"clear".equals(btnName)) {
                              break label122;
                           }

                           return 1000010;
                        }

                        return 8;
                     }

                     return 1000003;
                  }

                  return 1000002;
               }

               return 1000001;
            }
         } catch (Throwable var4) {
         }

         if (this.Method476()) {
            label130: {
               if (button != 113 && button != 81) {
                  if (button != 112 && button != 80) {
                     if (button == 42) {
                        return 1000001;
                     }

                     if (button == 35) {
                        return 1000002;
                     }
                     break label130;
                  }

                  return 1000002;
               }

               return 1000001;
            }
         }

         switch(button) {
         case -203:
         case -22:
         case -7:
         case 22:
         case 57346:
            return 1000002;
         case -202:
         case -21:
         case -6:
         case 21:
         case 57345:
            return 1000001;
         case -8:
            return 1000010;
         default:
            try {
               int var5;
               switch(var5 = this.getGameAction(button)) {
               case 1:
               case 2:
               case 5:
               case 6:
                  if (Class248.Method232(button)) {
                     return button;
                  }

                  return var5;
               case 3:
               case 4:
               case 7:
               default:
                  return button;
               case 8:
                  return Class248.Method232(button) ? button : var5;
               }
            } catch (Throwable var3) {
               return button;
            }
         }
      }
   }

   public final void Repaint() {
      if (!Midlet.Instance.IsPaused && this.isShown()) {
         this.repaint();
      }

   }

   private boolean Method475() {
      return this.Field627 != null && this.Field627.Method117() || this.Method492() && this.Field630.Method117();
   }

   private boolean Method476() {
      return Settings.Instance.UsePQSofts && !this.Method475() && (!(this.Field627 instanceof ConversationHistoryPage) || !((ConversationHistoryPage)this.Field627).Field925.Field1087) && (!(this.Field627 instanceof Class240) || !((Class240)this.Field627).Field755.Field70);
   }

   public static Image Method477(String url)
   {
      if (url == null)
      {
         return null;
      }
      else
      {
         try
         {
        	 InputStream stream;
             Image img;
             int temp = Settings.Instance.NetworkMode;
             if(url.toLowerCase().indexOf("https") != -1 && (temp == 1 || temp == 2 || temp == 4) )
             {
            	 HttpsConnection https = (HttpsConnection)Class278.Field877.Method44(url, true);
            	 stream=https.openInputStream();
                 img = Image.createImage(stream);
                 https.close();
             }
             else
             {
            	 HttpConnection http = (HttpConnection)Class278.Field877.Method44(url, true);
            	 stream=http.openInputStream();
                 img = Image.createImage(stream);
                 http.close();
             }
             
             stream.close();
             
             return img;
         }
         catch (Exception ex)
         {
        	 return null;
         }
         
      }
   }

   public static Image OpenImage(String file) {
      try {
         return file == null ? null : Image.createImage("/res/" + file);
      } catch (Exception var1) {
         return null;
      }
   }

   public final void SetInLoadingState(boolean isLoading) {
      this._inLoadingState = isLoading;
      this.Repaint();
   }

   private void Method480(Class36 var1, int var2, int var3, int var4) {
      if (var1 != null) {
         this.Method487();
         var1.Field62 = false;
         this.Field630 = var1;
         this.Field630.Method83(var2, var3, var4);
         this.Repaint();
      }
   }

   public final void Method481(Class36 var1) {
      this.Method480(var1, this._width / 2, this._height / 2, 3);
   }

   public final void Method482(Class36 var1) {
      if (Settings.Instance.GuiTouchHud) {
         this.Method480(var1, this._width / 2, this._height / 2, 3);
      } else if (this._reverseSofts && this._showFooter) {
         this.Method480(var1, 0, this.Field640, 36);
      } else {
         this.Method480(var1, this._width, this.Field640, 40);
      }
   }

   public final void Method483(String var1, String var2) {
      this.Method484(var1, var2, null);
   }

   public final void Method484(String title, String var2, Runnable var3) {
      if (var2 != null && Settings.Instance.IsAutorized()) {
         var2 = Class291.Method438(var2, Settings.Instance.Token, "*censored*");
      }

      if (title == null) {
         title = Localized.GetString("general.error");
      }

      Logger.PrintToConsole(title + ": " + var2);
      Class36 var4;
      Class36 var10000 = var4 = new Class36();
      TextBlock var10001 = new TextBlock(title);
      boolean var6 = true;
      TextBlock var5 = var10001;
      var10001.IsBold = true;
      var6 = true;
      var5.SkipImage = var6;
      var10000.AddElement(var5);
      var10001 = new TextBlock(var2);
      var6 = true;
      var5 = var10001;
      var10001.SkipImage = var6;
      var4.AddElement(var5);
      var4.AddElement((new Class276(this, Localized.GetString("action.close"), var3)).Method109(true));
      this.Method481(var4);
      var4.Field814 = 2;
   }

   public final void ShowError(String text)
   {
      this.Method484(null, text, null);
   }

   public final void ShowError(Throwable th) {
      if (th != null) {
         Logger.PrintErrorWithMessage(th);
         this.ShowError(th.toString() + ": " + th.getMessage());
      }
   }

   public final void Method487() {
      if (this.Field630 != null) {
         this.Field630.Field62 = false;
      }

      this.Field630 = null;
   }

   public final int Method488() {
      return this.Field630 != null ? this.Field630.Field61 : 0;
   }

   public final int Method489() {
      return this.Field630 != null ? this.Field630.Method5() : 0;
   }

   public static void Play() {
      try {
         if (_player == null) {
            (_player = Manager.createPlayer(Runtime.getRuntime().getClass().getResourceAsStream("/bb2.mp3"), Class377.Method301())).realize();
            _player.prefetch();
         }

         _player.start();
      } catch (Throwable var1) {
         Logger.PrintErrorWithMessage(var1);
      }
   }

   public static long Method491(double var0) {
      double var2 = Math.floor(var0);
      return var0 - var2 < 0.5D ? (long)var2 : (long)Math.ceil(var0);
   }

   public final boolean Method492() {
      return this.Field630 != null && this.Field630.Field63 && this.Field630.Field62;
   }

   public final void Method493() {
      Class252.Field795 = null;
      if (!Settings.Instance.RenderDimm && (this._img == null || 0 != Class6.ColorsInstanse.Field351 || this._img.getWidth() != this._width)) {
         this.Method494();
      }

      Button.Field252 = Class252.GenerateMask(Button.IconSizeLarge, Button.IconSizeLarge, Button.IconSizeLarge * Settings.Instance.GuiPhotosCircleType / 200, Class6.ColorsInstanse.Field291, Class6.ColorsInstanse.Field291, 15, (Button.Field260 - Button.IconSizeLarge) / 2, Button.Field260, false);
      Button.Field253 = Class252.GenerateMask(Button.IconSizeLarge, Button.IconSizeLarge, Button.IconSizeLarge * Settings.Instance.GuiPhotosCircleType / 200, Class6.ColorsInstanse.Field302, Class6.ColorsInstanse.Field303, 15, (Button.Field260 - Button.IconSizeLarge) / 2, Button.Field260, false);
      Button.Field254 = Class252.GenerateMask(Button.IconSizeLarge, Button.IconSizeLarge, Button.IconSizeLarge * Settings.Instance.GuiPhotosCircleType / 200, Class6.ColorsInstanse.Field318, Class6.ColorsInstanse.Field319, 15, (Button.Field260 - Button.IconSizeLarge) / 2, Button.Field260, false);
      Button.Field249 = Class252.GenerateMask(Button.IconSizeSmall, Button.IconSizeSmall, Button.IconSizeSmall * Settings.Instance.GuiPhotosCircleType / 200, Class6.ColorsInstanse.Field291, Class6.ColorsInstanse.Field291, 15, (Button.Field259 - Button.IconSizeSmall) / 2, Button.Field259, false);
      Button.Field250 = Class252.GenerateMask(Button.IconSizeSmall, Button.IconSizeSmall, Button.IconSizeSmall * Settings.Instance.GuiPhotosCircleType / 200, Class6.ColorsInstanse.Field302, Class6.ColorsInstanse.Field303, 15, (Button.Field259 - Button.IconSizeSmall) / 2, Button.Field259, false);
      Button.Field251 = Class252.GenerateMask(Button.IconSizeSmall, Button.IconSizeSmall, Button.IconSizeSmall * Settings.Instance.GuiPhotosCircleType / 200, Class6.ColorsInstanse.Field318, Class6.ColorsInstanse.Field319, 15, (Button.Field259 - Button.IconSizeSmall) / 2, Button.Field259, false);
      MessageItemUC.Field1270 = MessageItemUC.Field1269 * Settings.Instance.GuiAvatarCircleType / 100;
      MessageItemUC.Field1263 = Class252.Method323(MessageItemUC.Field1269, MessageItemUC.Field1269, MessageItemUC.Field1270, Class6.ColorsInstanse.Field318, Class6.ColorsInstanse.Field318, 1, false);
      MessageItemUC.Field1264 = Class252.Method323(MessageItemUC.Field1269, MessageItemUC.Field1269, MessageItemUC.Field1270, Class6.ColorsInstanse.Field291, Class6.ColorsInstanse.Field291, 1, false);
      MessageItemUC.Field1266 = Class252.Method326(MessageItemUC.Field1270, Class6.ColorsInstanse.Field342);
      MessageItemUC.Field1265 = Class252.Method326(MessageItemUC.Field1270, Class6.ColorsInstanse.Field343);
      MessageItemUC.Field1267 = Class252.Method326(MessageItemUC.Field1270, Class6.ColorsInstanse.Field309);
      Button.Field255 = Class252.Method323(Button.Field264, Button.Field264, Button.Field264 / 2, Class6.ColorsInstanse.Field350, Class6.ColorsInstanse.Field350, 15, true);
      Button.Field256 = Class252.GenerateMask(Button.Field265, Button.Field265, Button.Field265 * Settings.Instance.GuiAvatarCircleType / 200, Class6.ColorsInstanse.Field291, Class6.ColorsInstanse.Field291, 15, this._tbNormal.Height * 7 / 4 - this.CharSpaceWidth / 2, Button.Field260, false);
      Button.Field257 = Class252.GenerateMask(Button.Field265, Button.Field265, Button.Field265 * Settings.Instance.GuiAvatarCircleType / 200, Class6.ColorsInstanse.Field302, Class6.ColorsInstanse.Field303, 15, this._tbNormal.Height * 7 / 4 - this.CharSpaceWidth / 2, Button.Field260, false);
      Button.Field258 = Class252.GenerateMask(Button.Field265, Button.Field265, Button.Field265 * Settings.Instance.GuiAvatarCircleType / 200, Class6.ColorsInstanse.Field318, Class6.ColorsInstanse.Field319, 15, this._tbNormal.Height * 7 / 4 - this.CharSpaceWidth / 2, Button.Field260, false);
      Class36.Field69 = Class252.Method323(Class36.Field68 = this._fontBold.getHeight() * Settings.Instance.GuiAvatarCircleType / 200, Class36.Field68, Class36.Field68, Class6.ColorsInstanse.Field361, Class6.ColorsInstanse.Field361, 1, true);
      Class288.Field900 = Class252.Method323(Class288.Field899 = Math.max(2, this._font.getHeight() & -2), Class288.Field899, Class288.Field899 / 2, Class6.ColorsInstanse.Field333, Class6.ColorsInstanse.Field334, 15, true);
      Class288.Field901 = Class252.Method326(Class288.Field899 / 2, Class6.ColorsInstanse.Field337);
      Class288.Field902 = Class252.Method323(Class288.Field899, Class288.Field899, Class288.Field899 / 2, Class6.ColorsInstanse.Field335, Class6.ColorsInstanse.Field336, 15, true);
      Class288.Field903 = Class252.Method326(Class288.Field899 / 2, Class6.ColorsInstanse.Field362);
      TextBox2.Field482 = Class252.Method326(TextBox2.Field481 = (this._font.getHeight() + this.CharSpaceWidth + this.CharSpaceWidth) * Settings.Instance.GuiAvatarCircleType / 200, Class6.ColorsInstanse.Field297);
      TextBox2.Field483 = Class252.Method326(TextBox2.Field481, Class6.ColorsInstanse.Field309);
   }

   private void Method494() {
      int[] var1 = new int[this._width * 10];

      for(int i = 0; i < var1.length; i++) {
         var1[i] = -1728053248 | Class6.ColorsInstanse.Field351;
      }

      this._img = Image.createRGBImage(var1, this._width, 10, true);
   }

   public final void Method495(Class463 var1) {
      this.Method496(var1, -1);
   }

   public final void Method496(Class463 var1, int index) {
      if (!Settings.Instance.DoNotLoadImages && var1 != null)
      {
         if (index < 0 || index >= this.Field679.size())
         {
            index = -1;
         }

         if (!this.Field679.contains(var1) && var1.Method5() < 5)
         {
            if (index == -1) {
               this.Field679.addElement(var1);
            } else {
               this.Field679.insertElementAt(var1, index);
            }
         }

         if (this._thread == null || !this._thread.isAlive()) {
            this._thread = new Class275(this);
            this._thread.start();
         }

      }
   }

   public final void Method497(Class336 var1) {
      if (this.Field683 != null && this.Field683.Field971 != null) {
         this.removeCommand(this.Field683.Field971);
      }

      this.Field683 = var1;
      if (this.Field683 != null && this.Field683.Field971 != null && !this._showFooter) {
         this.addCommand(this.Field683.Field971);
      }

      this.Repaint();
   }

   public final void Method498(String var1, String var2) {
      if (!Class291.IsNullOrEmpty(var2)) {//VK4ME
         (_texBox = new TextBox(var1 == null ? "VK" : var1, var2, Settings.Instance.IncreaseTextLimit ? _maxSize : 500, 0)).setCommandListener(new Class274(this));
         _texBox.addCommand(new Command(Localized.GetString("action.ok"), 4, 1));
         Display.getDisplay(Midlet.Instance).setCurrent(_texBox);
      }
   }

   public final void Method499() {
      this.Field679.removeAllElements();
   }

   static void Method500(Class198 var0) {
      var0.Field670 = false;
      var0.Repaint();
   }
}
