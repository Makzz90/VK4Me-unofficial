import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public class Button extends Class328 implements Class187, Class463 {
   public Class277 LableElement;
   private Class277 Field238;
   private int Field239;
   private boolean Field240;
   private int _iconType;
   public byte Type;
   public String Field243;
   public short IsChecked;
   private String _content;
   public Class277 SubtitleElement;
   private Class277 Field247;
   String _photoUrl;
   public static Image Field249 = null;
   public static Image Field250 = null;
   public static Image Field251 = null;
   public static Image Field252 = null;
   public static Image Field253 = null;
   public static Image Field254 = null;
   public static Image Field255 = null;
   public static Image Field256 = null;
   public static Image Field257 = null;
   public static Image Field258 = null;
   public static int Field259;
   public static int Field260;
   public static int IconSizeSmall;
   public static int IconSizeLarge;
   public static int Field263;
   public static int Field264;
   public static int Field265;
   public boolean Field266;
   public boolean Field267;
   public boolean Field268;
   public int TextOffset;
   public int Field270;
   private int Field271;
   private int Field272;

   public final int Method5() {
      return this.Field272;
   }

   public final void Method6() {
      if (this.Field272 <= 5) {
         ++this.Field272;
      }
   }

   public final int Count() {
      return 1;
   }

   public final boolean Method11(int var1) {
      return this._iconType == 2;
   }

   public final String GetUrl(int var1) {
      return this._photoUrl == null || this._iconType == 0 || (this.SubtitleElement != null || this._page == null || this._page.Field809.get("s/" + this._photoUrl) != null) && (this.SubtitleElement == null || this._page == null || this._page.Field809.get("f/" + this._photoUrl) != null) ? null : this._photoUrl;
   }

   public final void SetImage(int var1, Image var2) {
      if (var2 != null && this._photoUrl != null && this._page != null) {
         if (this.SubtitleElement == null) {
            this._page.Field809.put("s/" + this._photoUrl, Class252.Method329(var2, Math.min(IconSizeSmall * var2.getHeight() / Math.max(1, var2.getWidth()), IconSizeSmall * var2.getWidth() / Math.max(1, var2.getHeight()))));
         } else {
            this._page.Field809.put("f/" + this._photoUrl, Class252.Method329(var2, Math.min(IconSizeLarge * var2.getHeight() / Math.max(1, var2.getWidth()), IconSizeLarge * var2.getWidth() / Math.max(1, var2.getHeight()))));
         }
      }
   }

   public final Button SetContent(String content) {
      this._content = content;
      return this;
   }

   public final Button Method95(int var1) {
      this._content = SomeStringUtils.Method429(var1);
      return this;
   }

   public final Button Method96(boolean var1) {
      this.Field267 = true;
      return this;
   }

   public final Button Method97(int var1) {
      this.Field243 = GetPlatformImage(var1);
      return this;
   }

   private Button Method98(String var1) {
      if (this._photoUrl != null && var1 != null && !this._photoUrl.equals(var1) && this._page != null) {
         this._page.Field809.remove("s/" + this._photoUrl);
         this._page.Field809.remove("f/" + this._photoUrl);
      }

      this._photoUrl = null;
      this._iconType = -1;
      return this;
   }

   public final Button SetRleIcon(String url) {
      this.Method98(url);
      if (url == null) {
         return this;
      } else {
         this._photoUrl = url;
         this._iconType = 0;
         return this;
      }
   }

   private Button Method100(String photoUrl) {
      this.Method98(photoUrl);
      if (Settings.Instance.DoNotLoadImages) {
         return this;
      } else {
         this._photoUrl = photoUrl;
         this._iconType = 1;
         return this;
      }
   }

   public final Button SetPngIcon(String photoUrl) {
      this.Method98(photoUrl);
      if (Settings.Instance.DoNotLoadImages) {
         return this;
      } else {
         this._photoUrl = photoUrl;
         this._iconType = 2;
         return this;
      }
   }

   public final Button Method102(VKAudio var1) {
      this.Method8();
      if (Settings.Instance.DoNotLoadImages) {
         this.SetRleIcon("new/music-note.rle");
         return this;
      } else {
         String var2;
         if ((var2 = var1 == null ? null : (this.Height > 68 ? var1.Method59() : var1.Method58())) == null) {
            this.SetPngIcon(this.Height > 68 ? "new/thumb_135.png" : "new/thumb_68.png");
         } else {
            this.Method100(var2);
         }

         return this;
      }
   }

   public final Button Method103(VKPlayList var1) {
      this.SetLable(var1.title);
      if (var1.Method58() != null) {
         this.SetSubtitle(var1.Method58());
      } else {
         this.SetSubtitle(Localized.GetString("title.playlist"));
      }

      this.Method8();
      String var2 = var1 != null && var1.Field775 != null ? (this.Height > 68 ? var1.Field775.Field204 : var1.Field775.Field203) : null;
      if (!Settings.Instance.DoNotLoadImages && var2 != null) {
         this.Method100(var2);
      } else {
         this.SetRleIcon("new/playlist-music.rle");
      }

      return this;
   }

   public final Button Method104(VKPhoto var1) {
      this.Method8();
      String var10000 = !Settings.Instance.DoNotLoadImages && var1 != null ? var1.GetUrl(this.Height) : null;
      String var2 = var10000;
      if (var10000 == null) {
         this.SetRleIcon("new/image.rle");
      } else {
         this.Method100(var2);
      }

      return this;
   }

   public final Button Method105() {
      this.Method8();
      if (Settings.Instance.DoNotLoadImages) {
         this.Method98(this._photoUrl);
         return this;
      } else {
         this.SetRleIcon("new/folder.rle");
         return this;
      }
   }

   public final Button SetIconByOwner(VKGroupOrUser owner) {
	   
      if (owner == null) {
         return this;
      } else {
         this.Method8();
         if (Settings.Instance.DoNotLoadImages) {
            this.Method98(this._photoUrl);
            return this;
         } else {
            String photoUrl = this.Height > 50 ? owner.GetPhoto100() : owner.GetPhoto50();
            if (photoUrl == null) {
               if (owner.is_group) {
                  if (!SomeStringUtils.IsStringEmpty(owner.GetGroup().deactivated)) {
                     this.SetPngIcon(this.Height > 50 ? "new/deactivated_100.png" : "new/deactivated_50.png");
                  } else {
                     this.SetPngIcon(this.Height > 50 ? "new/community_100.png" : "new/community_50.png");
                  }
               } else if (!SomeStringUtils.IsStringEmpty(owner.GetUser().deactivated)) {
                  this.SetPngIcon(this.Height > 50 ? "new/deactivated_100.png" : "new/deactivated_50.png");
               } else {
                  this.SetPngIcon(this.Height > 50 ? "new/camera_100.png" : "new/camera_50.png");
               }
            } else {
               this.Method100(photoUrl);
            }

            return this;
         }
      }
   }

   public final Button Method107(VKConversation var1, VKGroupOrUser owner) {
      if (var1 == null) {
         return this;
      } else {
         this.Method8();
         if (Settings.Instance.DoNotLoadImages) {
            this.Method98(this._photoUrl);
            return this;
         } else if (var1.GetPeerId() == Settings.Instance.UserId) {
            this.SetPngIcon(this.Height > 50 ? "new/im_favorites_100.png" : "new/im_favorites_50.png");
            return this;
         } else {
            String var10000 = this.Height > 50 ? (var1.Method213() ? var1.chat_settings.photo.Field1336 : null) : (var1.Method213() ? var1.chat_settings.photo.Field1335 : null);
            String var2 = var10000;
            if (var10000 == null) {
               if (var1.IsDialog())
               {
                  this.SetIconByOwner(owner/*Class31.GetUser(var1.GetPeerId())*/);
               } else {
                  this.SetPngIcon(this.Height > 50 ? "new/im_multichat_100.png" : "new/im_multichat_50.png");
               }
            } else {
               this.Method100(var2);
            }

            return this;
         }
      }
   }

   public void CommandExecuted()  {
      if (this.Type == 1) {
         this.IsChecked = (short)(this.IsChecked == 0 ? 1 : 0);
         this.Method21();
         this.ButtonPressed();
      }

   }

   public void ButtonPressed() {
   }

   private void Method21() {
      this.Field960 = Localized.GetString(this.Type == 0 ? this.Field960 : (this.Type == 1 ? (this.IsChecked != 0 ? "action.uncheck" : "action.check") : "action.goTo"));
   }

   public final Button SetLable(String lable) {
      this.LableElement = lable == null ? null : new Class277(lable);
      this.Field238 = null;
      this.Field239 = 0;
      return this;
   }

   public final Button Method109(boolean var1) {
      this.Field240 = var1;
      this.Field238 = null;
      this.Field239 = 0;
      return this;
   }

   public final Button SetSubtitle(String text) {
      return this.Method111(text == null ? null : new Class277(text));
   }

   public final Button Method111(Class277 var1) {
      this.SubtitleElement = var1;
      this.Method8();
      this.Field247 = null;
      this.Field238 = null;
      this.Field239 = 0;
      return this;
   }

   public final Button Method112(byte type) {
      this.Type = type;
      return this;
   }

   public Button(String lable, byte type) {
      this._iconType = -1;
      this.Type = type;
      this.Method8();
      this.SetLable(lable);
      this.Method21();
   }

   public Button(String title) {
      this(title, (byte)0);
   }

   public final void Method8() {
      this.Height = this.SubtitleElement != null ? Field260 : Field259;
   }

   public void Method9(Graphics g, int yPos, int var3) {
      this.Method8();
      if (this.Field959 && this.Field958 || (this.Type == 3 || this.Type == 4) && !this.Field267 && this.IsChecked != 0) {
         Class252.Method328(g, this.Field956 + var3, this.VerticalPosition + yPos, this.Field954, this.Height, this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field302 : Class6.ColorsInstanse.Field318, this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field303 : Class6.ColorsInstanse.Field319);
      }

      switch(this._iconType) {
      case 0:
         this.TextOffset = (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) + Class198.Instance.CharSpaceWidth * 4;//было 3, сдвиг текста у кнопки с обычной иконкой
         Class252.DrawRle(g, this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3, this.VerticalPosition + yPos + this.Height / 2, this._photoUrl, this.Field959 && this.Field958 ? 1 : 2, this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field308 : Class6.ColorsInstanse.Field296, this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall, 6);
         if (Settings.Instance.DebugDrawImagesFrames) {
            g.setColor(16711680);
            g.drawRect(this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3, this.VerticalPosition + yPos + this.Height / 2 - (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) / 2, (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) - 1, (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) - 1);
         }
         break;
      case 1:
      case 2:
         this.TextOffset = (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) + Class198.Instance.CharSpaceWidth * 5;//было 3, сдвиг текста у кнопки с двумя строками
         Image img;
         Image var5;
         Image var10000;
         if (this.SubtitleElement != null) {
            var10000 = this._page != null ? (Image)this._page.Field809.get("f/" + this._photoUrl) : null;
            img = var10000;
            if (var10000 == null) {
               Class198.Instance.Method495(this);
               g.setColor(Class6.ColorsInstanse.Field328);
               g.fillRect(this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3, this.VerticalPosition + yPos + this.Height / 2 - IconSizeLarge / 2, IconSizeLarge, IconSizeLarge);
            }
            else
            {
            	//image, width, height, Graphics.BOTTOM | Graphics.RIGHT
               g.drawImage(img, this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3 + IconSizeLarge / 2, this.VerticalPosition + yPos + this.Height / 2, Graphics.HCENTER | Graphics.VCENTER);// /2   3
            }

            if (!this.Field266) {
               if (this.Field959 && this.Field958)
               {
                  var5 = Field253;
               }
               else if ((this.Type == 3 || this.Type == 4) && this.IsChecked != 0)
               {
                  var5 = Field254;
               }
               else
               {
                  var5 = Field252;
               }

               if (var5 != null) {
                  g.drawImage(var5, this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3, this.VerticalPosition + yPos + this.Height / 2, 6);
               }
            }
         } else {
            var10000 = this._page != null ? (Image)this._page.Field809.get("s/" + this._photoUrl) : null;
            img = var10000;
            if (var10000 == null) {
               Class198.Instance.Method495(this);
               g.setColor(Class6.ColorsInstanse.Field328);
               g.fillRect(this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3, this.VerticalPosition + yPos + this.Height / 2 - IconSizeSmall / 2, IconSizeSmall, IconSizeSmall);
            } else {
               g.drawImage(img, this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3 + IconSizeSmall / 2, this.VerticalPosition + yPos + this.Height / 2, 3);
            }

            if (!this.Field266) {
               if (this.Field959 && this.Field958) {
                  var5 = Field250;
               } else if ((this.Type == 3 || this.Type == 4) && this.IsChecked != 0) {
                  var5 = Field251;
               } else {
                  var5 = Field249;
               }

               if (var5 != null) {
                  g.drawImage(var5, this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3, this.VerticalPosition + yPos + this.Height / 2, 6);
               }
            }
         }

         if (Settings.Instance.DebugDrawImagesFrames) {
            g.setColor(16711680);
            g.drawRect(this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3, this.VerticalPosition + yPos + this.Height / 2 - (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) / 2, (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) - 1, (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) - 1);
         }
         break;
      default:
         this.TextOffset = Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
      }

      this.Field270 = Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
      this.Field271 = Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
      String var10 = this.IsChecked + "";
      int var11;
      int var6 = Math.max((var11 = Class198.Instance._fontBold.stringWidth(var10)) + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth, Field265);
      int stringWidth = this._content != null ? Class198.Instance._font.stringWidth(this._content) : 0;
      switch(this.Type) {
      case 1:
      case 2:
         this.Field270 = this.Field271 = Class198.Instance.CharSpaceWidth * 3 + IconSizeSmall;
         break;
      case 3:
      case 4:
      case 5:
         if (this._content != null || this.IsChecked != 0) {
            this.Field270 = Math.max(var6, stringWidth) + Class198.Instance.CharSpaceWidth * 3;
         }

         if (this.IsChecked != 0 || this.Field268) {
            this.Field271 = this.Field270;
         }
      }

      if (this.LableElement != null && this.Field238 == null) {
         this.Field238 = (this.Field240 ? Class198.Instance._tbBold : Class198.Instance._tbNormal).Method92(this.LableElement, this.Field954 - this.TextOffset - this.Field270, true);
         this.Field239 = (this.Field240 ? Class198.Instance._tbBold : Class198.Instance._tbNormal).Method90(this.Field238);
      }

      stringWidth = this.VerticalPosition + yPos + Class198.Instance._tbNormal.Height / 2;
      int var8;
      int xPost;
      if (this.Field243 != null) {
         if (this._photoUrl != null && this._iconType != -1) {
            var8 = this.Field956 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth + var3 + (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) - Field263 / 2;
            xPost = this.VerticalPosition + yPos + this.Height / 2 + (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) / 2 - Field263 / 2;
            if (Field255 != null) {
               g.drawImage(Field255, var8, xPost, 3);
            }

            Class252.DrawRle(g, var8, xPost, this.Field243, 1, Class6.ColorsInstanse.Field349, Class6.ColorsInstanse.Field349, Field263, 3);
         } else {
            var8 = this.Field956 + var3 + this.TextOffset + this.Field239 + Class198.Instance.CharSpaceWidth;
            Class252.DrawRle(g, var8, stringWidth, this.Field243, 1, Class6.ColorsInstanse.Field349, Class6.ColorsInstanse.Field349, Field263, 20);
         }
      }

      if (this.SubtitleElement != null && this.Field247 == null) {
         this.Field247 = Class198.Instance._tbNormal.Method92(this.SubtitleElement, this.Field954 - this.TextOffset - this.Field271, true);
      }

      if (this.Field238 != null) {
         g.setColor(this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field304 : Class6.ColorsInstanse.Field292);
         (this.Field240 ? Class198.Instance._tbBold : Class198.Instance._tbNormal).Draw(g, this.Field238, this.Field956 + var3 + this.TextOffset, stringWidth, 20);
      }

      var8 = this.VerticalPosition + yPos + Class198.Instance._tbNormal.Height * 7 / 4;
      if (this.Field247 != null) {
         if ((!this.Field959 || !this.Field958) && this.Type == 5) {
            Class252.Method328(g, this.Field956 + var3 + this.TextOffset, var8, this.Field954 - this.TextOffset - this.Field271, Class198.Instance._tbNormal.Height, Class6.ColorsInstanse.Field318, Class6.ColorsInstanse.Field319);
         }

         g.setColor(this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field306 : Class6.ColorsInstanse.Field294);
         Class198.Instance._tbNormal.Draw(g, this.Field247, this.Field956 + var3 + this.TextOffset, var8, 20);
      }

      xPost = this.Field956 + this.Field954 + var3 - Field259 / 2 - Class198.Instance.CharSpaceWidth - Class198.Instance.CharSpaceWidth;
      yPos = this.VerticalPosition + yPos + this.Height / 2;
      
      switch(this.Type) {
      case 1://галочка справа
         Class252.DrawRle(g, xPost, yPos, this.IsChecked != 0 ? "new/checkbox-selected.rle" : "new/checkbox-none.rle", this.Field959 ? (this.Field958 ? 1 : (this.IsChecked != 0 ? 2 : 3)) : 4, this.Field959 ? (this.Field958 ? Class6.ColorsInstanse.Field311 : (this.IsChecked != 0 ? Class6.ColorsInstanse.Field310 : Class6.ColorsInstanse.Field298)) : Class6.ColorsInstanse.Field298, this.Field959 ? (this.Field958 ? Class6.ColorsInstanse.Field314 : (this.IsChecked != 0 ? Class6.ColorsInstanse.Field313 : Class6.ColorsInstanse.Field300)) : Class6.ColorsInstanse.Field300, IconSizeSmall, 3);
         return;
      case 2://стрелка справа
         Class252.DrawRle(g, xPost, yPos, "new/chevron-right.rle", this.Field959 && this.Field958 ? 1 : 2, this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field312 : Class6.ColorsInstanse.Field299, this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field315 : Class6.ColorsInstanse.Field301, IconSizeSmall, 3);
         return;
      case 3:
      case 4:
      case 5:
         xPost += Field259 / 2;
         if (this._content != null) {
            if (this.IsChecked == 0 && this.Field268) {
               stringWidth = yPos - Class198.Instance._fontBold.getHeight() / 2;
            }

            g.setFont(Class198.Instance._font);
            g.setColor(this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field306 : Class6.ColorsInstanse.Field294);
            g.drawString(this._content, xPost, stringWidth, 24);
         }

         if (this.IsChecked != 0) {
            if (this.SubtitleElement != null && this._content != null) {
               yPos = var8;
            } else {
               yPos -= Class198.Instance._fontBold.getHeight() / 2;
            }

            if (this.Type == 3) {
               var3 = this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field324 : Class6.ColorsInstanse.Field321;
               stringWidth = this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field325 : Class6.ColorsInstanse.Field322;
            } else {
               var3 = this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field365 : Class6.ColorsInstanse.Field363;
               stringWidth = this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field366 : Class6.ColorsInstanse.Field364;
            }

            Class252.Method328(g, xPost - var6, yPos - Class198.Instance.CharSpaceWidth / 2, var6, Field265, var3, stringWidth);
            var3 = Field265 / 2;
            if (this.Field959 && this.Field958) {
               if (Field257 != null) {
                  g.drawRegion(Field257, 0, 0, var3, Field265, 0, xPost - var6, yPos - Class198.Instance.CharSpaceWidth / 2, 20);
                  g.drawRegion(Field257, Field265 - var3, 0, var3, Field265, 0, xPost - var3, yPos - Class198.Instance.CharSpaceWidth / 2, 20);
               }
            } else if (this.IsChecked != 0) {
               if (Field258 != null) {
                  g.drawRegion(Field258, 0, 0, var3, Field265, 0, xPost - var6, yPos - Class198.Instance.CharSpaceWidth / 2, 20);
                  g.drawRegion(Field258, Field265 - var3, 0, var3, Field265, 0, xPost - var3, yPos - Class198.Instance.CharSpaceWidth / 2, 20);
               }
            } else if (Field256 != null) {
               g.drawRegion(Field256, 0, 0, var3, Field265, 0, xPost - var6, yPos - Class198.Instance.CharSpaceWidth / 2, 20);
               g.drawRegion(Field256, Field265 - var3, 0, var3, Field265, 0, xPost - var3, yPos - Class198.Instance.CharSpaceWidth / 2, 20);
            }

            g.setColor(this.Field959 && this.Field958 ? Class6.ColorsInstanse.Field323 : Class6.ColorsInstanse.Field320);
            g.setFont(Class198.Instance._fontBold);
            g.drawString(var10, xPost - (var6 - var11) / 2, yPos, 24);//TODO Это счётчик?
         }
      case 6:
      default:
      }
   }

   public static String GetPlatformImage(int var0) {
      switch(var0) {
      case 0:
         return null;
      case 1:
      default:
         return "new/online-pc.rle";
      case 2:
         return "new/online-mobile.rle";
      case 3:
         return "new/online-android.rle";
      case 4:
         return "new/online-apple.rle";
      case 5:
         return "new/online-win.rle";
      case 6:
         return "new/online-vkme.rle";
      case 7:
         return "new/pencil.rle";
      }
   }

   public final Class328 Method114(int var1, int var2, int var3) throws Exception {
      if (this.Field958 && this.Field959 && this._iconType != -1 && var1 < this.Field956 + (this.SubtitleElement != null ? IconSizeLarge : IconSizeSmall) + Class198.Instance.CharSpaceWidth && var1 > this.Field956 + Class198.Instance.CharSpaceWidth && var2 < this.VerticalPosition + this.Height + Class198.Instance.HeaderHeight - var3 && var2 > this.VerticalPosition + Class198.Instance.HeaderHeight - var3) {
         this.Method20();
         this.Field958 = false;
         return this;
      } else {
         return super.Method114(var1, var2, var3);
      }
   }

   public void Method20() throws Exception {
      this.CommandExecuted();
   }

   public final void Method23() {
      this.Field238 = null;
      this.Field239 = 0;
      this.Field247 = null;
   }

   public final Button Method115(boolean var1) {
      this.IsChecked = (short)(var1 ? 1 : 0);
      return this;
   }

   public final Button Method116(short var1) {
      if (this.IsChecked != 0 != (var1 != 0)) {
         this.Field238 = null;
         this.Field239 = 0;
         this.Field247 = null;
      }

      this.IsChecked = var1;
      return this;
   }

   public final boolean GetIsChecked() {
      return this.IsChecked != 0;
   }

   public final void Error(Throwable var1) {
      Class198.Instance.ShowError("List item: " + var1 != null ? var1.getMessage() : "Unknown error");
   }

   static {
      Field259 = Class198.Instance._tbNormal.Height << 1;
      Field260 = Class198.Instance._tbNormal.Height * 13 / 4;
      IconSizeSmall = Field259 - Class198.Instance._tbNormal.Height / 1;//было /2
      IconSizeLarge = Field260 - Class198.Instance._tbNormal.Height;
      Field264 = (Field263 = Class198.Instance._tbNormal.Height * 3 / 4) + (Math.max(2, Field263 / 3 / 2) << 1);
      Field265 = Class198.Instance._fontBold.getHeight() + Class198.Instance.CharSpaceWidth;
   }
}
