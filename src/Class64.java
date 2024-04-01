import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public final class Class64 extends Class328 implements Class266, Class463 {
   private static Object Field162 = new Object();
   VKWallReply Field163;
   private boolean Field164;
   private boolean Field165;
   private Class277 Field166;
   private Class277[] Field167;
   private int Field168;
   private int Field169;
   private int Field170;
   private int Field171;
   private int Field172;
   private int Field173;
   private Class277 Field174;
   private Class277 Field175;
   private Class277[] Field176;
   private Class277[] Field177;
   private AttachmentItemUC[] Field178;
   private Class36 Field179;
   private boolean Field180;
   private String Field181;
   private int Field182;
   private int Field183;
   private int Field184;
   private boolean Field185;
   private Image[] _img;
   private String[] Field187;
   private String Field188;
   private boolean Field189;
   private Integer[] Field190;
   private Integer[] Field191;
   private String Field192;
   private int Field193;
   private boolean Field194;

   public final int Method5() {
      return this.Field193;
   }

   public final void Method6() {
      if (this.Field193 <= 5) {
         ++this.Field193;
      }
   }

   public final int Count() {
      return 1 + (this.Field187 != null ? this.Field187.length : 0);
   }

   public final boolean Method11(int var1) {
      return var1 == 0 && this.Field189;
   }

   public final String GetUrl(int var1) {
      if (var1 == 0 && this.Field188 != null && this._page != null && this._page.Field809.get(this.Field188) == null) {
         return this.Field188;
      } else {
         return var1 > 0 && var1 < this.Count() && this._img != null && this._img[var1 - 1] == null ? this.Field187[var1 - 1] : null;
      }
   }

   public final void SetImage(int var1, Image var2) {
      if (var2 != null) {
         if (var1 == 0 && this.Field188 != null && this._page.Field809.get(this.Field188) == null) {
            if (this._page != null) {
               this._page.Field809.put(this.Field188, Class252.Method329(var2, Button.IconSizeSmall));
               return;
            }
         } else if (var1 > 0 && var1 < this.Count() && this._img != null && this._img[var1 - 1] == null) {
            this._img[var1 - 1] = Class252.Method325(MessageItemUC.Field1270, Class252.Method329(var2, this.Field190[var1 - 1].intValue()), 15);
         }

      }
   }

   public Class64(Class240 var1, VKWallReply var2) {
      this.Field163 = var2;
      this._page = var1;
      this.Field194 = this._page != null;
      boolean var10001;
      if (this._page != null) {
         VKNewsfeedPost var3 = ((Class240)this._page).Field758;
         var10001 = true;
      } else {
         var10001 = false;
      }

      this.Field165 = var10001;
      this.Field164 = true;
   }

   public final void Method20() {
      if (this.Field163.IsAttachmentsExists()) {
         Page var1 = (new Page(Localized.GetString("title.attachmentsList"))).Method361(this._page);

         for(int i = 0; i < this.Field163.attachments.length; i++) {
            VKAttachment var3;
            if ((var3 = this.Field163.attachments[i]) != null) {
               var1.AddElement(new AttachmentItemUC(var3));
            }
         }

         Class198.Instance.Method487();
         Class198.Instance.NavigateForward(var1);
      }
   }

   public final void Method21() {
      if (this.Field163.Method40()) {
         Page var1 = (new Page(Localized.GetString("title.attachmentsList"))).Method361(this._page);
         if (this.Field163.Method40()) {
            TextBlock var10001 = new TextBlock(Localized.GetString("attachments.reply"));
            boolean var2 = true;
            TextBlock var3 = var10001;
            var10001.IsBold = true;
            var1.AddElement(var3);
            var1.AddElement(new Class64((Class240)null, this.Field163.Field841));
         }

         Class198.Instance.Method487();
         Class198.Instance.NavigateForward(var1);
      }
   }

   private void Method22() {
      synchronized(Field162) {
         if (this.Field163 != null && this._page != null && this.Field179 == null) {
            this.Field179 = new Class36(Localized.GetString("general.actions"));
            Class240 var2 = this.Field194 ? (Class240)this._page : null;
            VKGroupOrUser var3 = Class31.GetUser(this.Field163.from_id);
            if (var2 != null && var2.Field758.GetCanWrite()) {
               this.Field179.AddElement((new Class139(this, Localized.GetString("action.reply"), var2)).SetRleIcon("new/reply.rle"));
            }

            this.Field179.AddElement((new Class148(this, Localized.GetString("action.fwdMessage"))).SetRleIcon("new/share.rle"));
            if (var2 != null && var2.Field758.GetCanWrite()) {
               if (this.Field163.from_id != Settings.Instance.UserId) {
                  VKNewsfeedPost var4 = var2.Field758;
               } else {
                  this.Field179.AddElement((new Class150(this, Localized.GetString("action.deleteMessage"), var2)).SetRleIcon("new/delete.rle"));
               }
            }

            if (var2 != null && var2.Field758.GetCanWrite() && this.Field163.Method211() && this.Field163.from_id == Settings.Instance.UserId) {
               this.Field179.AddElement((new Class143(this, Localized.GetString("action.editMessage"), var2)).SetRleIcon("new/pencil.rle"));
            }

            if (this.Field163.IsAttachmentsExists()) {
               this.Field179.AddElement((new Class146(this, Localized.GetString("action.showAttachmentsList"))).SetRleIcon("new/paperclip.rle"));
            }

            if (this.Field163.Method40()) {
               this.Field179.AddElement((new Class157(this, Localized.GetString("action.additionalMessages"))).SetRleIcon("new/message.rle"));
            }

            if (var2 != null) {
               this.Field179.AddElement((new Class158(this, Localized.GetString("action.showReplies"), var2)).SetRleIcon("new/chevron-down.rle"));
            }

            if (!Class291.IsNullOrEmpty(this.Field163.text)) {
               this.Field179.AddElement((new Class152(this, Localized.GetString("action.showTextInEditor"))).SetRleIcon("new/content-copy.rle"));
            }

            this.Field179.AddElement((new Class155(this, Localized.GetString("action.goToProfile"), var3)).SetRleIcon("new/account.rle"));
         }
      }
   }

   public final void Method23() {
      this.Field167 = null;
      this.Field188 = null;
      this.Field166 = null;
      this.Field181 = null;
      this.Field174 = null;
      this.Field175 = null;
      this.Field176 = null;
      this.Field177 = null;
      this.Field168 = 0;
      this.Field185 = true;
   }

   public final void Method8() {
      if (this.Field163 != null) {
         boolean var1 = this.Field185;
         boolean var2 = false;
         if (this.Field954 > 0 && this.Field163 != null && this.Field163.IsStringExists() && this.Field167 == null) {
            Class277 var3 = new Class277(this.Field163.text);
            this.Field167 = Class198.Instance._tbNormal.Method91(var3, this.Field954 - (Class198.Instance.CharSpaceWidth << 1));
            var1 = true;
         }

         if (Settings.Instance.GuiMessagesAvatars && !Settings.Instance.DoNotLoadImages && (!Settings.Instance.GuiMessageDiffSides || !this.Field163.Field840) && this.Field954 > 0 && this.Field164 && this.Field165 && this.Field188 == null) {
            VKGroupOrUser var14 = Class31.GetUser(this.Field163.from_id);
            String var12 = Button.Field259 > 50 ? var14.GetPhoto100() : var14.GetPhoto50();
            boolean var4 = false;
            if (var12 == null) {
               var4 = true;
               if (var14.is_group) {
                  if (!SomeStringUtils.IsStringEmpty(var14.GetGroup().deactivated)) {
                     var12 = Button.Field259 > 50 ? "new/deactivated_100.png" : "new/deactivated_50.png";
                  } else {
                     var12 = Button.Field259 > 50 ? "new/community_100.png" : "new/community_50.png";
                  }
               } else if (!SomeStringUtils.IsStringEmpty(var14.GetUser().deactivated)) {
                  var12 = Button.Field259 > 50 ? "new/deactivated_100.png" : "new/deactivated_50.png";
               } else {
                  var12 = Button.Field259 > 50 ? "new/camera_100.png" : "new/camera_50.png";
               }
            }

            this.Field192 = Button.GetPlatformImage(LoginForm.Method261(var14));
            this.Field188 = var12;
            this.Field189 = var4;
            var2 = true;
            var1 = true;
         }

         if (this.Field954 > 0 && this.Field164 && this.Field165 && this.Field166 == null) {
            this.Field166 = Class198.Instance._tbBold.Method92(new Class277(Class31.GetUser(this.Field163.from_id).GetTitle("nom")), this.Field954 - (this.Field188 != null ? Button.IconSizeSmall + Class198.Instance.CharSpaceWidth : 0), true);
            this.Field183 = Class198.Instance._tbBold.Method90(this.Field166) + Class198.Instance.CharSpaceWidth;
            var1 = true;
         }

         if (this.Field954 > 0 && this.Field164 && this.Field181 == null) {
            this.Field181 = Class328.Method164(SomeStringUtils.Method429(this.Field163.GetDate()), this.Field954 - (Class198.Instance.CharSpaceWidth << 1) - (this.Field166 != null ? this.Field183 : 0) - (this.Field188 != null ? Button.IconSizeSmall + Class198.Instance.CharSpaceWidth : 0), true, Class198.Instance._font);
            this.Field182 = (Class198.Instance._tbBold.Height - Class198.Instance._font.getHeight()) / 2;
            this.Field184 = Class198.Instance._font.stringWidth(this.Field181);
            var1 = true;
         }

         if (!this.Field164) {
            this.Field181 = null;
         }

         if (this.Field954 > 0 && this.Field163.Method40()) {
            if (this.Field174 == null) {
               if (this.Field163.Field841.Method36()) {
                  this.Field174 = new Class277(Localized.GetString("j2vk.empty"));
               } else {
                  this.Field174 = Class198.Instance._tbBold.Method92(new Class277(Class31.GetUser(this.Field163.Field841.from_id).GetTitle("nom")), this.Field954, true);
               }

               var1 = true;
            }

            if (this.Field175 == null) {
               this.Field175 = Class198.Instance._tbNormal.Method92(new Class277(this.Field163.Field841.Method359(false, false, false, true)), this.Field954 - (Class198.Instance.CharSpaceWidth << 2), true);
               var1 = true;
            }
         }

         int var15 = -1;
         if (this.Field954 > 0 && this.Field163.IsAttachmentsExists() && (this._img == null || this.Field178 == null)) {
            var15 = 0;
            Vector var17 = new Vector();
            Vector var16 = new Vector();
            Vector var5 = new Vector();
            Vector var6 = new Vector();
            boolean var7 = false;

            for(int i = 0; i < this.Field163.attachments.length; i++) {
               VKAttachment attach = this.Field163.attachments[i];
               if (attach != null) {
                  var7 = var7 || attach.sticker!=null || attach.gift!=null;
                  if (attach instanceof Class184 && !Settings.Instance.DoNotLoadImages) {
                     int var21 = Math.min(Class198.Instance.getWidth() / 2, Class198.Instance.getHeight() / 2);
                     String var11;
                     if ((var11 = ((Class184)attach).GetUrl(var21)) != null) {
                        int var13 = ((Class184)attach).GetWidth(var21);
                        int var20 = ((Class184)attach).GetHeight(var21);
                        var20 = Math.min(var21, var13) * var20 / var13;
                        var13 = Math.min(var21, var13);
                        var17.addElement(var11);
                        var16.addElement(new Integer(var20));
                        var5.addElement(new Integer(var13));
                        this.Field168 = Math.max(this.Field168, var13);
                        var15 += var20 + Class198.Instance.CharSpaceWidth;
                        var2 = true;
                     }
                  } else {
                     AttachmentItemUC var10;
                     (var10 = new AttachmentItemUC(attach)).Method8();
                     var6.addElement(var10);
                     this.Field168 = Math.max(this.Field168, this.Field954 - (Class198.Instance.CharSpaceWidth << 1));
                     var15 += var10.Height + Class198.Instance.CharSpaceWidth;
                  }
               }
            }

            this._img = new Image[var17.size()];
            this.Field187 = new String[var17.size()];
            var17.copyInto(this.Field187);
            this.Field190 = new Integer[var16.size()];
            var16.copyInto(this.Field190);
            this.Field191 = new Integer[var5.size()];
            var5.copyInto(this.Field191);
            this.Field178 = new AttachmentItemUC[var6.size()];
            var6.copyInto(this.Field178);
            this.Field180 = var7;
            var1 = true;
         }

         if (var1) {
            int var19;
            if (this.Field167 != null) {
               for(var19 = 0; var19 < this.Field167.length; var19++) {
                  this.Field168 = Math.max(this.Field168, Class198.Instance._tbNormal.Method90(this.Field167[var19]));
               }
            }

            this.Field168 = Math.max(this.Field168, Class198.Instance._tbBold.Method90(this.Field174) + (Class198.Instance.CharSpaceWidth << 1));
            this.Field168 = Math.max(this.Field168, Class198.Instance._tbNormal.Method90(this.Field175) + (Class198.Instance.CharSpaceWidth << 1));
            if (this.Field191 != null) {
               for(var19 = 0; var19 < this.Field191.length; var19++) {
                  this.Field168 = Math.max(this.Field168, this.Field191[var19].intValue());
               }
            }

            if (this.Field178 != null && this.Field178.length > 0) {
               this.Field168 = Math.max(this.Field168, this.Field954 - (Class198.Instance.CharSpaceWidth << 1));
            }

            this.Field169 = this.Field167 == null ? 0 : this.Field167.length * Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth;
            this.Field171 = !this.Field164 ? 0 : (!this.Field165 || (!Settings.Instance.GuiMessagesAvatars) || Settings.Instance.DoNotLoadImages || Settings.Instance.GuiMessageDiffSides && this.Field163.Field840 ? Class198.Instance._tbBold.Height : Button.IconSizeSmall) + Class198.Instance.CharSpaceWidth;
            this.Field170 = this.Field163.Field841 != null ? Class198.Instance._tbBold.Height + Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth : 0;
            if (var15 == -1) {
               var15 = 0;
               if (this.Field190 != null) {
                  for(var19 = 0; var19 < this.Field190.length; var19++) {
                     var15 += this.Field190[var19].intValue() + Class198.Instance.CharSpaceWidth;
                  }
               }

               if (this.Field178 != null) {
                  for(var19 = 0; var19 < this.Field178.length; var19++) {
                     AttachmentItemUC var18;
                     if ((var18 = this.Field178[var19]) != null) {
                        var18.Method8();
                        var15 += var18.Height + Class198.Instance.CharSpaceWidth;
                     }
                  }
               }
            }

            this.Field172 = var15;
            this.Field173 = 0;
            this.Height = this.Field171 + Math.max(MessageItemUC.Field1269 << 1, Class198.Instance.CharSpaceWidth + this.Field170 + this.Field169 + this.Field173 + this.Field172) + (Class198.Instance.CharSpaceWidth << 1);
            this.Field185 = false;
         }

         if (var2) {
            Class198.Instance.Method495(this);
         }

         if (this.Field179 == null) {
            this.Method22();
         }

      }
   }

   public final void Method9(Graphics g, int var2, int var3) {
      this.Method8();
      int var4 = var2;
      var2 += Class198.Instance.CharSpaceWidth;
      boolean var5 = this.Field959 && this.Field958;
      boolean var6 = false;
      int var7;
      int var8;
      int var9;
      Image var10;
      if (this.Field164) {
         var7 = Settings.Instance.GuiMessageDiffSides && this.Field163.Field840 ? this.Field954 - this.Field183 - this.Field184 - (this.Field188 != null ? Button.IconSizeSmall : 0) : 0;
         var3 += var7;
         if (Settings.Instance.GuiMessageDiffSides && this.Field163.Field840) {
            if (this.Field181 != null) {
               g.setColor(Class6.ColorsInstanse.Field294);
               g.setFont(Class198.Instance._font);
               g.drawString(this.Field181, this.Field956 + var3 + (this.Field166 != null ? this.Field183 : 0), this.VerticalPosition + var2 + this.Field182, 20);
            }
         } else {
            var8 = 0;
            var9 = 0;
            if (this.Field165 && Settings.Instance.GuiMessagesAvatars && !Settings.Instance.DoNotLoadImages) {
               var8 = Button.IconSizeSmall + Class198.Instance.CharSpaceWidth;
               var9 = (Button.IconSizeSmall - Class198.Instance._tbBold.Height) / 2;
               if (this.Field188 != null) {
                  Image var10000 = this._page != null ? (Image)this._page.Field809.get(this.Field188) : null;
                  var10 = var10000;
                  if (var10000 != null) {
                     g.drawImage(var10, this.Field956 + var3, this.VerticalPosition + var2, 20);
                  }
               } else {
                  var6 = true;
                  g.setColor(Class6.ColorsInstanse.Field328);
                  g.fillRect(this.Field956 + var3, this.VerticalPosition + var2, Button.IconSizeSmall, Button.IconSizeSmall);
               }

               if (Button.Field249 != null) {
                  g.drawImage(Button.Field249, this.Field956 + var3, this.VerticalPosition + var2, 20);
               }

               if (this.Field192 != null) {
                  if (Button.Field255 != null) {
                     g.drawImage(Button.Field255, this.Field956 + var3 + Button.IconSizeSmall - Button.Field263 / 2, this.VerticalPosition + var2 + Button.IconSizeSmall - Button.Field263 / 2, 3);
                  }

                  Class252.DrawRle(g, this.Field956 + var3 + Button.IconSizeSmall - Button.Field263 / 2, this.VerticalPosition + var2 + Button.IconSizeSmall - Button.Field263 / 2, this.Field192, 1, Class6.ColorsInstanse.Field349, Class6.ColorsInstanse.Field349, Button.Field263, 3);
               }
            }

            var3 += var8;
            var2 += var9;
            if (this.Field166 != null) {
               g.setColor(Class6.ColorsInstanse.Field292);
               Class198.Instance._tbBold.Draw(g, this.Field166, this.Field956 + var3, this.VerticalPosition + var2, 20);
            }

            if (this.Field181 != null) {
               g.setColor(Class6.ColorsInstanse.Field294);
               g.setFont(Class198.Instance._font);
               g.drawString(this.Field181, this.Field956 + var3 + (this.Field166 != null ? this.Field183 : 0), this.VerticalPosition + var2 + this.Field182, 20);
            }

            var3 -= var8;
            var2 -= var9;
         }

         var3 -= var7;
         var2 += this.Field171;
      }

      var7 = this.Height - (Class198.Instance.CharSpaceWidth << 1) - this.Field171;
      var8 = Math.max(Class198.Instance.CharSpaceWidth + this.Field168 + Class198.Instance.CharSpaceWidth, MessageItemUC.Field1269 << 1);
      var9 = Settings.Instance.GuiMessageDiffSides && this.Field163.Field840 ? this.Field954 - var8 : 0;
      if (Settings.Instance.GuiShowClouds && (this.Field170 != 0 || !this.Field180)) {
         Class252.Method328(g, this.Field956 + var3 + var9, this.VerticalPosition + var2, var8, var7, this.Field163.Field840 ? Class6.ColorsInstanse.Field338 : Class6.ColorsInstanse.Field340, this.Field163.Field840 ? Class6.ColorsInstanse.Field339 : Class6.ColorsInstanse.Field341);
      }

      if (Settings.Instance.GuiShowClouds && Settings.Instance.GuiCloudBorder && (this.Field170 != 0 || !this.Field180) || var5) {
         g.setColor(var5 ? Class6.ColorsInstanse.Field309 : (this.Field163.Field840 ? Class6.ColorsInstanse.Field342 : Class6.ColorsInstanse.Field343));
         g.drawRect(this.Field956 + var3 + var9, this.VerticalPosition + var2, var8 - 1, var7 - 1);
      }

      if ((var10 = MessageItemUC.Field1264) != null && (Settings.Instance.GuiShowClouds && (this.Field170 != 0 || !this.Field180) || var5)) {
         if (Settings.Instance.GuiMessageDiffSides && this.Field163.Field840) {
            g.drawImage(var10, this.Field956 + var3 + var9, this.VerticalPosition + var2, 20);
         } else {
            g.drawRegion(var10, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 3, this.Field956 + var3 + var9 + var8 - MessageItemUC.Field1270, this.VerticalPosition + var2 + var7 - MessageItemUC.Field1270, 20);
         }

         g.drawRegion(var10, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 5, this.Field956 + var3 + var9 + var8 - MessageItemUC.Field1270, this.VerticalPosition + var2, 20);
         g.drawRegion(var10, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 6, this.Field956 + var3 + var9, this.VerticalPosition + var2 + var7 - MessageItemUC.Field1270, 20);
      }

      if (Settings.Instance.GuiShowClouds && Settings.Instance.GuiCloudBorder && (this.Field170 != 0 || !this.Field180) || var5) {
         Image var11;
         if (var5) {
            var11 = MessageItemUC.Field1267;
         } else if (this.Field163 != null && this.Field163.Field840) {
            var11 = MessageItemUC.Field1266;
         } else {
            var11 = MessageItemUC.Field1265;
         }

         if (var11 != null) {
            if (Settings.Instance.GuiMessageDiffSides && this.Field163.Field840) {
               g.drawImage(var11, this.Field956 + var3 + var9, this.VerticalPosition + var2, 20);
            } else {
               g.drawRegion(var11, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 3, this.Field956 + var3 + var9 + var8 - MessageItemUC.Field1270, this.VerticalPosition + var2 + var7 - MessageItemUC.Field1270, 20);
            }

            g.drawRegion(var11, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 5, this.Field956 + var3 + var9 + var8 - MessageItemUC.Field1270, this.VerticalPosition + var2, 20);
            g.drawRegion(var11, 0, 0, MessageItemUC.Field1270, MessageItemUC.Field1270, 6, this.Field956 + var3 + var9, this.VerticalPosition + var2 + var7 - MessageItemUC.Field1270, 20);
         }
      }

      var2 += Class198.Instance.CharSpaceWidth;
      var3 += Class198.Instance.CharSpaceWidth;
      if (this.Field170 != 0) {
         g.setColor(this.Field163.Field840 ? Class6.ColorsInstanse.Field345 : Class6.ColorsInstanse.Field346);
         g.fillRect(this.Field956 + var3 + var9, this.VerticalPosition + var2, Class198.Instance.CharSpaceWidth, this.Field170 - Class198.Instance.CharSpaceWidth);
         var3 += Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
         g.setColor(Class6.ColorsInstanse.Field292);
         if (this.Field174 != null) {
            Class198.Instance._tbBold.Draw(g, this.Field174, this.Field956 + var3 + var9, this.VerticalPosition + var2, 20);
         }

         var2 += Class198.Instance._tbBold.Height;
         if (this.Field175 != null) {
            Class198.Instance._tbNormal.Draw(g, this.Field175, this.Field956 + var3 + var9, this.VerticalPosition + var2, 20);
         }

         var2 += Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth;
         var3 -= Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
      }

      int index;
      if (this.Field167 != null) {
         g.setColor(Class6.ColorsInstanse.Field292);
         index = this.Method24(var4);
         TextElement var13 = Class198.Instance._tbNormal;
         var2 += Math.min(index, this.Field167.length) * var13.Height;
         var4 = this.Method25(var4);

         for(; index < var4; index++) {
            var13.Draw(g, this.Field167[index], this.Field956 + var3 + var9, this.VerticalPosition + var2, 20);
            var2 += var13.Height;
         }

         var2 += Class198.Instance.CharSpaceWidth;
      }

      g.setColor(this.Field163.Field840 ? Class6.ColorsInstanse.Field345 : Class6.ColorsInstanse.Field346);
      g.fillRect(this.Field956 + var3 + var9, this.VerticalPosition + var2, Class198.Instance.CharSpaceWidth, this.Field173 - Class198.Instance.CharSpaceWidth);
      var3 = var3 + Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth - (Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth);
      if (this._img != null) {
         for(index = 0; index < this._img.length; index++) {
            Image var14 = this._img[index];
            if (var14 == null) {
               var6 = true;
               g.setColor(Class6.ColorsInstanse.Field328);
               g.fillRect(this.Field956 + var3 + var9, this.VerticalPosition + var2, this.Field191[index].intValue(), this.Field190[index].intValue());
            } else {
               g.drawImage(var14, this.Field956 + var3 + var9, this.VerticalPosition + var2, 20);
            }

            var2 += this.Field190[index].intValue() + Class198.Instance.CharSpaceWidth;
         }
      }

      if (this.Field178 != null) {
         for(index = 0; index < this.Field178.length; index++) {
            AttachmentItemUC var15= this.Field178[index];
            if (var15 != null)
            {
               var15._page = this._page;
               var15.Field954 = this.Field168;
               var15.Method9(g, this.VerticalPosition + var2, this.Field956 + var3 + var9);
               var2 += var15.Height + Class198.Instance.CharSpaceWidth;
            }
         }
      }

      if (var6) {
         Class198.Instance.Method495(this);
      }

   }

   private int Method24(int var1) {
      var1 = this.VerticalPosition + var1 + this.Field171 + this.Field170 + Class198.Instance.CharSpaceWidth - (!(this._page instanceof Class36) ? Class198.Instance.HeaderHeight : Class198.Instance.Method488()) + Class198.Instance.CharSpaceWidth;
      int var2 = 0;
      if (var1 < 0) {
         var2 = 0 + -var1 / Class198.Instance._tbNormal.Height;
      }

      return var2;
   }

   private int Method25(int var1) {
      var1 = this.VerticalPosition + var1 + this.Field171 + this.Field170 + Class198.Instance.CharSpaceWidth - (!(this._page instanceof Class36) ? Class198.Instance.HeaderHeight : Class198.Instance.Method488()) + Class198.Instance.CharSpaceWidth + this.Field169 - (!(this._page instanceof Class36) ? Class198.Instance.Field646 : Class198.Instance.Method489());
      int var2 = this.Field167.length;
      if (var1 > 0) {
         var2 += -var1 / Class198.Instance._tbNormal.Height;
      }

      return var2;
   }

   public final VKWallReply Method19() {
      return this.Field163;
   }

   public final void CommandExecuted() {
      if (this.Field179 != null) {
         Class198.Instance.Method481(this.Field179);
      }
   }

   public final void Error(Throwable var1) {
      Class198.Instance.ShowError("Comment view: " + var1 != null ? var1.getMessage() : "Unknown error");
   }
}
