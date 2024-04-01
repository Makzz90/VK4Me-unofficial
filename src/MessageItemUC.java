import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public class MessageItemUC extends Class328 implements Class463, Class498 {
   private static Object Field1240 = new Object();
   VKMessage Field1241;
   public boolean Field1242;
   private boolean Field1243;
   private Class277 Field1244;
   private Class277[] Field1245;
   private int Field1246;
   private int Field1247;
   private int Field1248;
   private int Field1249;
   private int Field1250;
   private int Field1251;
   private Class277 Field1252;
   private Class277 Field1253;
   private Class277[] Field1254;
   private Class277[] Field1255;
   private AttachmentItemUC[] Field1256;
   Class36 Field1257;
   private boolean Field1258;
   private String Field1259;
   private int Field1260;
   private int Field1261;
   private int Field1262;
   public static Image Field1263;
   public static Image Field1264;
   public static Image Field1265;
   public static Image Field1266;
   public static Image Field1267;
   private boolean Field1268;
   public static int Field1269;
   public static int Field1270;
   private Image[] Field1271;
   private String[] Field1272;
   private String Field1273;
   private boolean Field1274;
   private Integer[] Field1275;
   private Integer[] Field1276;
   private String Field1277;
   private int Field1278;
   private boolean Field1279;

   public final int Method5() {
      return this.Field1278;
   }

   public final void Method6() {
      if (this.Field1278 <= 5) {
         ++this.Field1278;
      }
   }

   public final int Count() {
      return 1 + (this.Field1272 != null ? this.Field1272.length : 0);
   }

   public final boolean Method11(int var1) {
      return var1 == 0 && this.Field1274;
   }

   public final String GetUrl(int var1) {
      if (var1 == 0 && this.Field1273 != null && this._page != null && this._page.Field809.get(this.Field1273) == null) {
         return this.Field1273;
      } else {
         return var1 > 0 && var1 < this.Count() && this.Field1271 != null && this.Field1271[var1 - 1] == null ? this.Field1272[var1 - 1] : null;
      }
   }

   public final void SetImage(int var1, Image var2) {
      if (var2 != null) {
         if (var1 == 0 && this.Field1273 != null && this._page.Field809.get(this.Field1273) == null) {
            if (this._page != null) {
               this._page.Field809.put(this.Field1273, Class252.Method329(var2, Button.IconSizeSmall));
               return;
            }
         } else if (var1 > 0 && var1 < this.Count() && this.Field1271 != null && this.Field1271[var1 - 1] == null) {
            this.Field1271[var1 - 1] = Class252.Method325(Field1270, Class252.Method329(var2, this.Field1275[var1 - 1].intValue()), 15);
         }

      }
   }

   public MessageItemUC(ConversationHistoryPage var1, VKMessage var2) {
      this.Field1241 = var2;
      this._page = var1;
      this.Field1279 = this._page != null;
      this.Field1243 = this._page != null && ((ConversationHistoryPage)this._page).Field474.Method40();
      this.Field1242 = true;
   }

   public final void Method21() {
      if (this.Field1241.Method213()) {
         Page page = (new Page(Localized.GetString("title.attachmentsList"))).Method361(this._page);

         for(int i = 0; i < this.Field1241.attachments.length; i++) {
            VKAttachment var3= this.Field1241.attachments[i];
            if (var3 != null) {
               page.AddElement(new AttachmentItemUC(var3));
            }
         }

         Class198.Instance.Method487();
         Class198.Instance.NavigateForward(page);
      }
   }

   public final void Method22() {
      if (this.Field1241.Method2() || this.Field1241.Method40()) {
         Page var1 = (new Page(Localized.GetString("title.attachmentsList"))).Method361(this._page);
         TextBlock var10001;
         TextBlock var2;
         //boolean var3;
         if (this.Field1241.Method40()) {
            var10001 = new TextBlock(Localized.GetString("attachments.reply"));
            //var3 = true;
            var2 = var10001;
            var10001.IsBold = true;
            var1.AddElement(var2);
            var1.AddElement(new MessageItemUC((ConversationHistoryPage)null, this.Field1241.reply_message));
         }

         if (this.Field1241.Method2()) {
            String var6 = "";
            
            var10001 = new TextBlock(Localized.Method398("attachments.fwds", var6, null));
            //var3 = true;
            var2 = var10001;
            var10001.IsBold = true;
            var1.AddElement(var2);

            for(int i = 0; i < this.Field1241.fwd_messages.length; i++) {
               if (this.Field1241.fwd_messages[i] != null) {
                  var1.AddElement(new MessageItemUC((ConversationHistoryPage)null, this.Field1241.fwd_messages[i]));
               }
            }
         }

         Class198.Instance.Method487();
         Class198.Instance.NavigateForward(var1);
      }
   }

   public void Method20() {
      synchronized(Field1240) {
         if (this.Field1241 != null && this._page != null && this.Field1257 == null) {
            this.Field1257 = new Class36(Localized.GetString("general.actions"));
            ConversationHistoryPage var2 = this.Field1279 ? (ConversationHistoryPage)this._page : null;
            VKGroupOrUser var3 = Class31.GetUser(this.Field1241.from_id);
            Class36 var4 = new Class36();
            if (var2 != null && var2.Field474.GetCanWrite()) {
               var4.AddElement(new Class444(this, Localized.GetString("action.replyThisChat"), var2));
            }

            if (var3 != null && !var3.is_group && var3.GetUser().can_write_private_message && this.Field1241.from_id != this.Field1241.peer_id) {
               var4.AddElement(new Class451(this, Localized.GetString("action.replyPrivately")));
            }

            if (var4.Count() > 0) {
               this.Field1257.AddElement((new Class28(Localized.GetString("action.reply"), var4)).SetRleIcon("new/reply.rle"));
            }

            var4 = new Class36();
            if (var2 != null && var2.Field474.GetCanWrite()) {
               var4.AddElement(new Class452(this, Localized.GetString("action.fwdThisChat"), var2));
            }

            var4.AddElement(new Class453(this, Localized.GetString("action.fwdAnotherChat")));
            if (var4.Count() > 0) {
               this.Field1257.AddElement((new Class28(Localized.GetString("action.fwdMessage"), var4)).SetRleIcon("new/share.rle"));
            }

            var4 = new Class36();
            if (var2 != null && var2.Field474.GetCanWrite() && this.Field1241.Method211() && this.Field1241.peer_id != Settings.Instance.UserId && (this.Field1241.from_id == Settings.Instance.UserId || var2.Field474.Method37() && ((VKConversation)var2.Field474).chat_settings.Method192(Settings.Instance.UserId))) {
               var4.AddElement(new Class454(this, Localized.GetString("action.deleteForEveryone")));
            }

            var4.AddElement(new Class447(this, Localized.GetString("action.deleteForMyself")));
            if (var2 != null && var2.Field474.GetCanWrite() && var4.Count() > 0) {
               this.Field1257.AddElement((new Class28(Localized.GetString("action.deleteMessage"), var4)).SetRleIcon("new/delete.rle"));
            }

            if (var2 != null && var2.Field474.GetCanWrite() && this.Field1241.Method211() && this.Field1241.from_id == Settings.Instance.UserId) {
               this.Field1257.AddElement((new Class448(this, Localized.GetString("action.editMessage"), var2)).SetRleIcon("new/pencil.rle"));
            }

            if (this.Field1241.Method213()) {
               this.Field1257.AddElement((new Class449(this, Localized.GetString("action.showAttachmentsList"))).SetRleIcon("new/paperclip.rle"));
            }

            if (this.Field1241.Method2() || this.Field1241.Method40()) {
               this.Field1257.AddElement((new Class450(this, Localized.GetString("action.additionalMessages"))).SetRleIcon("new/message.rle"));
            }

            if (!Class291.IsNullOrEmpty(this.Field1241.text)) {
               this.Field1257.AddElement((new Class369(this, Localized.GetString("action.showTextInEditor"))).SetRleIcon("new/content-copy.rle"));
            }

            if (var2 != null && !this.Field1241.out) {
               this.Field1257.AddElement((new Class372(this, Localized.GetString("action.markAsReaded"), var2)).SetRleIcon("new/eye.rle"));
            }

            this.Field1257.AddElement((new Class370(this, Localized.GetString("action.goToProfile"), var3)).SetRleIcon("new/account.rle"));
            this.Method118();
            this.Method119();
         }
      }
   }

   public final void Method118() {
      ConversationHistoryPage var10000 = this.Field1279 ? (ConversationHistoryPage)this._page : null;
      ConversationHistoryPage var1 = var10000;
      if (var10000 != null && var1.Field474.Method40() && var1.Field474.Method37() && ((VKConversation)var1.Field474).chat_settings.Method192(Settings.Instance.UserId) && (((VKConversation)var1.Field474).chat_settings.pinned_message == null || ((VKConversation)var1.Field474).chat_settings.pinned_message.id != this.Field1241.id)) {
         this.Field1257.AddElement((new Class365(this, Localized.GetString("action.pin"), var1)).SetRleIcon("new/pin.rle"));
      }

   }

   public final void Method119() {
      ConversationHistoryPage var10000 = this.Field1279 ? (ConversationHistoryPage)this._page : null;
      ConversationHistoryPage var1 = var10000;
      if (var10000 != null && var1.Field474.Method40() && var1.Field474.Method37() && ((VKConversation)var1.Field474).chat_settings.Method192(Settings.Instance.UserId) && ((VKConversation)var1.Field474).chat_settings.pinned_message != null && ((VKConversation)var1.Field474).chat_settings.pinned_message.id == this.Field1241.id) {
         this.Field1257.AddElement((new Class363(this, Localized.GetString("action.unpin"), var1)).SetRleIcon("new/pin-off.rle"));
      }

   }

   public final void Method23() {
      this.Field1245 = null;
      this.Field1273 = null;
      this.Field1244 = null;
      this.Field1259 = null;
      this.Field1252 = null;
      this.Field1253 = null;
      this.Field1254 = null;
      this.Field1255 = null;
      this.Field1246 = 0;
      this.Field1268 = true;
   }

   public final void Method8() {
      if (this.Field1241 != null) {
         boolean var1 = this.Field1268;
         boolean var2 = false;
         if (this.Field954 > 0 && this.Field1241 != null && this.Field1241.Method37() && this.Field1245 == null) {
            Class277 var3 = new Class277(this.Field1241.text);
            this.Field1245 = Class198.Instance._tbNormal.Method91(var3, this.Field954 - (Class198.Instance.CharSpaceWidth << 1));
            var1 = true;
         }

         if (Settings.Instance.GuiMessagesAvatars && !Settings.Instance.DoNotLoadImages && (!Settings.Instance.GuiMessageDiffSides || !this.Field1241.out) && this.Field954 > 0 && this.Field1242 && this.Field1243 && this.Field1273 == null) {
            VKGroupOrUser var14 = Class31.GetUser(this.Field1241.from_id);
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

            this.Field1277 = Button.GetPlatformImage(LoginForm.Method261(var14));
            this.Field1273 = var12;
            this.Field1274 = var4;
            var2 = true;
            var1 = true;
         }

         if (this.Field954 > 0 && this.Field1242 && this.Field1243 && this.Field1244 == null) {
            this.Field1244 = Class198.Instance._tbBold.Method92(new Class277(Class31.GetUser(this.Field1241.from_id).Method356()), this.Field954 - (this.Field1273 != null ? Button.IconSizeSmall + Class198.Instance.CharSpaceWidth : 0), true);
            this.Field1261 = Class198.Instance._tbBold.Method90(this.Field1244) + Class198.Instance.CharSpaceWidth;
            var1 = true;
         }

         if (this.Field954 > 0 && this.Field1242 && this.Field1259 == null) {
            this.Field1259 = Class328.Method164(SomeStringUtils.Method429(this.Field1241.Method217()), this.Field954 - (Class198.Instance.CharSpaceWidth << 1) - (this.Field1244 != null ? this.Field1261 : 0) - (this.Field1273 != null ? Button.IconSizeSmall + Class198.Instance.CharSpaceWidth : 0), true, Class198.Instance._font);
            this.Field1260 = (Class198.Instance._tbBold.Height - Class198.Instance._font.getHeight()) / 2;
            this.Field1262 = Class198.Instance._font.stringWidth(this.Field1259);
            var1 = true;
         }

         if (!this.Field1242) {
            this.Field1259 = null;
         }

         if (this.Field954 > 0 && this.Field1241.Method40()) {
            if (this.Field1252 == null) {
               this.Field1252 = Class198.Instance._tbBold.Method92(new Class277(Class31.GetUser(this.Field1241.reply_message.from_id).Method356()), this.Field954, true);
               var1 = true;
            }

            if (this.Field1253 == null) {
               this.Field1253 = Class198.Instance._tbNormal.Method92(new Class277(this.Field1241.reply_message.Method216(false, false, false, true, true, null)), this.Field954 - (Class198.Instance.CharSpaceWidth << 2), true);
               var1 = true;
            }
         }

         Vector var18;
         if (this.Field954 > 0 && this.Field1241.Method2() && (this.Field1254 == null || this.Field1255 == null)) {
            Vector var15 = new Vector();
            var18 = new Vector();

            for(int i = 0; i < this.Field1241.fwd_messages.length; i++) {
               VKMessage var5;
               if ((var5 = this.Field1241.fwd_messages[i]) != null) {
                  Class277 var6 = Class198.Instance._tbBold.Method92(new Class277(Class31.GetUser(var5.from_id).Method356()), this.Field954 - (Class198.Instance.CharSpaceWidth << 2), true);
                  Class277 var7 = Class198.Instance._tbNormal.Method92(new Class277(var5.Method216(false, false, false, true, true, null)), this.Field954 - (Class198.Instance.CharSpaceWidth << 2), true);
                  var15.addElement(var6);
                  var18.addElement(var7);
               }
            }

            this.Field1254 = new Class277[var15.size()];
            this.Field1255 = new Class277[var18.size()];
            var15.copyInto(this.Field1254);
            var18.copyInto(this.Field1255);
            var1 = true;
         }

         int var16 = -1;
         if (this.Field954 > 0 && this.Field1241.Method213() && (this.Field1271 == null || this.Field1256 == null)) {
            var16 = 0;
            var18 = new Vector();
            Vector var20 = new Vector();
            Vector var19 = new Vector();
            Vector var22 = new Vector();
            boolean var24 = false;

            for(int i = 0; i < this.Field1241.attachments.length; i++) {
               VKAttachment attach = this.Field1241.attachments[i];
               if (attach != null) {
                  var24 = var24 || attach.sticker!=null || attach.gift!=null;
                  if (attach instanceof Class184 && !Settings.Instance.DoNotLoadImages) {
                     int var26 = Math.min(Class198.Instance.getWidth() / 2, Class198.Instance.getHeight() / 2);
                     String var11;
                     if ((var11 = ((Class184)attach).GetUrl(var26)) != null) {
                        int var13 = ((Class184)attach).GetWidth(var26);
                        int var25 = ((Class184)attach).GetHeight(var26);
                        var25 = Math.min(var26, var13) * var25 / var13;
                        var13 = Math.min(var26, var13);
                        var18.addElement(var11);
                        var20.addElement(new Integer(var25));
                        var19.addElement(new Integer(var13));
                        this.Field1246 = Math.max(this.Field1246, var13);
                        var16 += var25 + Class198.Instance.CharSpaceWidth;
                        var2 = true;
                     }
                  } else {
                     AttachmentItemUC var10;
                     (var10 = new AttachmentItemUC(attach)).Method8();
                     var22.addElement(var10);
                     this.Field1246 = Math.max(this.Field1246, this.Field954 - (Class198.Instance.CharSpaceWidth << 1));
                     var16 += var10.Height + Class198.Instance.CharSpaceWidth;
                  }
               }
            }

            this.Field1271 = new Image[var18.size()];
            this.Field1272 = new String[var18.size()];
            var18.copyInto(this.Field1272);
            this.Field1275 = new Integer[var20.size()];
            var20.copyInto(this.Field1275);
            this.Field1276 = new Integer[var19.size()];
            var19.copyInto(this.Field1276);
            this.Field1256 = new AttachmentItemUC[var22.size()];
            var22.copyInto(this.Field1256);
            this.Field1258 = var24;
            var1 = true;
         }

         if (var1) {
            int i;
            if (this.Field1245 != null) {
               for(i = 0; i < this.Field1245.length; i++) {
                  this.Field1246 = Math.max(this.Field1246, Class198.Instance._tbNormal.Method90(this.Field1245[i]));
               }
            }

            this.Field1246 = Math.max(this.Field1246, Class198.Instance._tbBold.Method90(this.Field1252) + (Class198.Instance.CharSpaceWidth << 1));
            this.Field1246 = Math.max(this.Field1246, Class198.Instance._tbNormal.Method90(this.Field1253) + (Class198.Instance.CharSpaceWidth << 1));
            if (this.Field1254 != null && this.Field1255 != null) {
               for(i = 0; i < this.Field1254.length; i++) {
                  this.Field1246 = Math.max(this.Field1246, Class198.Instance._tbBold.Method90(this.Field1254[i]) + (Class198.Instance.CharSpaceWidth << 1));
                  this.Field1246 = Math.max(this.Field1246, Class198.Instance._tbNormal.Method90(this.Field1255[i]) + (Class198.Instance.CharSpaceWidth << 1));
               }
            }

            if (this.Field1276 != null) {
               for(i = 0; i < this.Field1276.length; i++) {
                  this.Field1246 = Math.max(this.Field1246, this.Field1276[i].intValue());
               }
            }

            if (this.Field1256 != null && this.Field1256.length > 0) {
               this.Field1246 = Math.max(this.Field1246, this.Field954 - (Class198.Instance.CharSpaceWidth << 1));
            }

            this.Field1247 = this.Field1245 == null ? 0 : this.Field1245.length * Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth;
            this.Field1249 = !this.Field1242 ? 0 : (!this.Field1243 || !Settings.Instance.GuiMessagesAvatars || Settings.Instance.DoNotLoadImages || Settings.Instance.GuiMessageDiffSides && this.Field1241.out ? Class198.Instance._tbBold.Height : Button.IconSizeSmall) + Class198.Instance.CharSpaceWidth;
            this.Field1248 = this.Field1241.reply_message != null ? Class198.Instance._tbBold.Height + Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth : 0;
            if (var16 == -1) {
               var16 = 0;
               if (this.Field1275 != null) {
                  for(i = 0; i < this.Field1275.length; i++) {
                     var16 += this.Field1275[i].intValue() + Class198.Instance.CharSpaceWidth;
                  }
               }

               if (this.Field1256 != null) {
                  for(i = 0; i < this.Field1256.length; i++) {
                     AttachmentItemUC var21;
                     if ((var21 = this.Field1256[i]) != null) {
                        var21.Method8();
                        var16 += var21.Height + Class198.Instance.CharSpaceWidth;
                     }
                  }
               }
            }

            this.Field1250 = var16;
            this.Field1251 = this.Field1255 != null && this.Field1254 != null ? this.Field1255.length * (Class198.Instance._tbBold.Height + Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth) : 0;
            this.Height = this.Field1249 + Math.max(Field1269 << 1, Class198.Instance.CharSpaceWidth + this.Field1248 + this.Field1247 + this.Field1251 + this.Field1250) + (Class198.Instance.CharSpaceWidth << 1);
            this.Field1268 = false;
         }

         if (var2) {
            Class198.Instance.Method495(this);
         }

         if (this.Field1257 == null) {
            this.Method20();
         }

      }
   }

   public final void Method9(Graphics g, int var2, int var3) {
      this.Method8();
      int var4 = var2;
      var2 += Class198.Instance.CharSpaceWidth;
      boolean var5 = this.Field959 && this.Field958;
      boolean var6 = false;
      boolean var7;
      if (var7 = this.Field1279 && (!this.Field1241.out && ((ConversationHistoryPage)this._page).Field921 < this.Field1241.id || this.Field1241.out && ((ConversationHistoryPage)this._page).Field922 < this.Field1241.id)) {
         Class252.Method328(g, this.Field956 + var3 - (Class198.Instance.CharSpaceWidth << 1), this.VerticalPosition + var4, this.Field954 + (Class198.Instance.CharSpaceWidth << 2), this.Height, Class6.ColorsInstanse.Field318, Class6.ColorsInstanse.Field319);
      }

      int var8;
      int var9;
      int var10;
      Image var11;
      if (this.Field1242) {
         var8 = Settings.Instance.GuiMessageDiffSides && this.Field1241.out ? this.Field954 - this.Field1261 - this.Field1262 - (this.Field1273 != null ? Button.IconSizeSmall : 0) : 0;
         var3 += var8;
         if (Settings.Instance.GuiMessageDiffSides && this.Field1241.out) {
            if (this.Field1259 != null) {
               g.setColor(Class6.ColorsInstanse.Field294);
               g.setFont(Class198.Instance._font);
               g.drawString(this.Field1259, this.Field956 + var3 + (this.Field1244 != null ? this.Field1261 : 0), this.VerticalPosition + var2 + this.Field1260, 20);
            }
         } else {
            var9 = 0;
            var10 = 0;
            if (this.Field1243 && Settings.Instance.GuiMessagesAvatars && !Settings.Instance.DoNotLoadImages) {
               var9 = Button.IconSizeSmall + Class198.Instance.CharSpaceWidth;
               var10 = (Button.IconSizeSmall - Class198.Instance._tbBold.Height) / 2;
               if (this.Field1273 != null) {
                  Image var10000 = this._page != null ? (Image)this._page.Field809.get(this.Field1273) : null;
                  var11 = var10000;
                  if (var10000 != null) {
                     g.drawImage(var11, this.Field956 + var3, this.VerticalPosition + var2, 20);
                  }
               } else {
                  var6 = true;
                  g.setColor(Class6.ColorsInstanse.Field328);
                  g.fillRect(this.Field956 + var3, this.VerticalPosition + var2, Button.IconSizeSmall, Button.IconSizeSmall);
               }

               if (Button.Field249 != null) {
                  g.drawImage(Button.Field249, this.Field956 + var3, this.VerticalPosition + var2, 20);
               }

               if (this.Field1277 != null) {
                  if (Button.Field255 != null) {
                     g.drawImage(Button.Field255, this.Field956 + var3 + Button.IconSizeSmall - Button.Field263 / 2, this.VerticalPosition + var2 + Button.IconSizeSmall - Button.Field263 / 2, 3);
                  }

                  Class252.DrawRle(g, this.Field956 + var3 + Button.IconSizeSmall - Button.Field263 / 2, this.VerticalPosition + var2 + Button.IconSizeSmall - Button.Field263 / 2, this.Field1277, 1, Class6.ColorsInstanse.Field349, Class6.ColorsInstanse.Field349, Button.Field263, 3);
               }
            }

            var3 += var9;
            var2 += var10;
            if (this.Field1244 != null) {
               g.setColor(Class6.ColorsInstanse.Field292);
               Class198.Instance._tbBold.Draw(g, this.Field1244, this.Field956 + var3, this.VerticalPosition + var2, 20);
            }

            if (this.Field1259 != null) {
               g.setColor(Class6.ColorsInstanse.Field294);
               g.setFont(Class198.Instance._font);
               g.drawString(this.Field1259, this.Field956 + var3 + (this.Field1244 != null ? this.Field1261 : 0), this.VerticalPosition + var2 + this.Field1260, 20);
            }

            var3 -= var9;
            var2 -= var10;
         }

         var3 -= var8;
         var2 += this.Field1249;
      }

      var8 = this.Height - (Class198.Instance.CharSpaceWidth << 1) - this.Field1249;
      var9 = Math.max(Class198.Instance.CharSpaceWidth + this.Field1246 + Class198.Instance.CharSpaceWidth, Field1269 << 1);
      var10 = Settings.Instance.GuiMessageDiffSides && this.Field1241.out ? this.Field954 - var9 : 0;
      if (Settings.Instance.GuiShowClouds && (this.Field1248 != 0 || !this.Field1258)) {
         Class252.Method328(g, this.Field956 + var3 + var10, this.VerticalPosition + var2, var9, var8, this.Field1241.out ? Class6.ColorsInstanse.Field338 : Class6.ColorsInstanse.Field340, this.Field1241.out ? Class6.ColorsInstanse.Field339 : Class6.ColorsInstanse.Field341);
      }

      if (Settings.Instance.GuiShowClouds && Settings.Instance.GuiCloudBorder && (this.Field1248 != 0 || !this.Field1258) || var5) {
         g.setColor(var5 ? Class6.ColorsInstanse.Field309 : (this.Field1241.out ? Class6.ColorsInstanse.Field342 : Class6.ColorsInstanse.Field343));
         g.drawRect(this.Field956 + var3 + var10, this.VerticalPosition + var2, var9 - 1, var8 - 1);
      }

      if (var7) {
         var11 = Field1263;
      } else {
         var11 = Field1264;
      }

      if (var11 != null && (Settings.Instance.GuiShowClouds && (this.Field1248 != 0 || !this.Field1258) || var5)) {
         if (Settings.Instance.GuiMessageDiffSides && this.Field1241.out) {
            g.drawImage(var11, this.Field956 + var3 + var10, this.VerticalPosition + var2, 20);
         } else {
            g.drawRegion(var11, 0, 0, Field1270, Field1270, 3, this.Field956 + var3 + var10 + var9 - Field1270, this.VerticalPosition + var2 + var8 - Field1270, 20);
         }

         g.drawRegion(var11, 0, 0, Field1270, Field1270, 5, this.Field956 + var3 + var10 + var9 - Field1270, this.VerticalPosition + var2, 20);
         g.drawRegion(var11, 0, 0, Field1270, Field1270, 6, this.Field956 + var3 + var10, this.VerticalPosition + var2 + var8 - Field1270, 20);
      }

      if (Settings.Instance.GuiShowClouds && Settings.Instance.GuiCloudBorder && (this.Field1248 != 0 || !this.Field1258) || var5) {
         Image var13;
         if (var5) {
            var13 = Field1267;
         } else if (this.Field1241 != null && this.Field1241.out) {
            var13 = Field1266;
         } else {
            var13 = Field1265;
         }

         if (var13 != null) {
            if (Settings.Instance.GuiMessageDiffSides && this.Field1241.out) {
               g.drawImage(var13, this.Field956 + var3 + var10, this.VerticalPosition + var2, 20);
            } else {
               g.drawRegion(var13, 0, 0, Field1270, Field1270, 3, this.Field956 + var3 + var10 + var9 - Field1270, this.VerticalPosition + var2 + var8 - Field1270, 20);
            }

            g.drawRegion(var13, 0, 0, Field1270, Field1270, 5, this.Field956 + var3 + var10 + var9 - Field1270, this.VerticalPosition + var2, 20);
            g.drawRegion(var13, 0, 0, Field1270, Field1270, 6, this.Field956 + var3 + var10, this.VerticalPosition + var2 + var8 - Field1270, 20);
         }
      }

      var2 += Class198.Instance.CharSpaceWidth;
      var3 += Class198.Instance.CharSpaceWidth;
      if (this.Field1248 != 0) {
         g.setColor(this.Field1241.out ? Class6.ColorsInstanse.Field345 : Class6.ColorsInstanse.Field346);
         g.fillRect(this.Field956 + var3 + var10, this.VerticalPosition + var2, Class198.Instance.CharSpaceWidth, this.Field1248 - Class198.Instance.CharSpaceWidth);
         var3 += Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
         g.setColor(Class6.ColorsInstanse.Field292);
         if (this.Field1252 != null) {
            Class198.Instance._tbBold.Draw(g, this.Field1252, this.Field956 + var3 + var10, this.VerticalPosition + var2, 20);
         }

         var2 += Class198.Instance._tbBold.Height;
         if (this.Field1253 != null) {
            Class198.Instance._tbNormal.Draw(g, this.Field1253, this.Field956 + var3 + var10, this.VerticalPosition + var2, 20);
         }

         var2 += Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth;
         var3 -= Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
      }

      int i;
      if (this.Field1245 != null) {
         g.setColor(Class6.ColorsInstanse.Field292);
         i = this.Method24(var4);
         TextElement var15 = Class198.Instance._tbNormal;
         var2 += Math.min(i, this.Field1245.length) * var15.Height;
         var4 = this.Method25(var4);

         for(i = i; i < var4; ++i) {
            var15.Draw(g, this.Field1245[i], this.Field956 + var3 + var10, this.VerticalPosition + var2, 20);
            var2 += var15.Height;
         }

         var2 += Class198.Instance.CharSpaceWidth;
      }

      g.setColor(this.Field1241.out ? Class6.ColorsInstanse.Field345 : Class6.ColorsInstanse.Field346);
      g.fillRect(this.Field956 + var3 + var10, this.VerticalPosition + var2, Class198.Instance.CharSpaceWidth, this.Field1251 - Class198.Instance.CharSpaceWidth);
      var3 += Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
      if (this.Field1255 != null && this.Field1254 != null) {
         for(i = 0; i < this.Field1255.length; i++) {
            Class277 var16 = this.Field1254[i];
            Class277 var12 = this.Field1255[i];
            g.setColor(Class6.ColorsInstanse.Field292);
            if (var16 != null) {
               Class198.Instance._tbBold.Draw(g, var16, this.Field956 + var3 + var10, this.VerticalPosition + var2, 20);
            }

            var2 += Class198.Instance._tbBold.Height;
            if (var12 != null) {
               Class198.Instance._tbNormal.Draw(g, var12, this.Field956 + var3 + var10, this.VerticalPosition + var2, 20);
            }

            var2 += Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth;
         }
      }

      var3 -= Class198.Instance.CharSpaceWidth + Class198.Instance.CharSpaceWidth;
      if (this.Field1271 != null) {
         for(i = 0; i < this.Field1271.length; i++) {
            Image var17 = this.Field1271[i];
            if (var17 == null) {
               var6 = true;
               g.setColor(Class6.ColorsInstanse.Field328);
               g.fillRect(this.Field956 + var3 + var10, this.VerticalPosition + var2, this.Field1276[i].intValue(), this.Field1275[i].intValue());
            } else {
               g.drawImage(var17, this.Field956 + var3 + var10, this.VerticalPosition + var2, 20);
            }

            var2 += this.Field1275[i].intValue() + Class198.Instance.CharSpaceWidth;
         }
      }

      if (this.Field1256 != null)
      {
         for(i = 0; i < this.Field1256.length; i++) {
            AttachmentItemUC var18 = this.Field1256[i];
            if (var18 != null) {
               var18._page = this._page;
               var18.Field954 = this.Field1246;
               var18.Method9(g, this.VerticalPosition + var2, this.Field956 + var3 + var10);
               var2 += var18.Height + Class198.Instance.CharSpaceWidth;
            }
         }
      }

      if (var6) {
         Class198.Instance.Method495(this);
      }

   }

   private int Method24(int var1) {
      var1 = this.VerticalPosition + var1 + this.Field1249 + this.Field1248 + Class198.Instance.CharSpaceWidth - (!(this._page instanceof Class36) ? Class198.Instance.HeaderHeight : Class198.Instance.Method488()) + Class198.Instance.CharSpaceWidth;
      int var2 = 0;
      if (var1 < 0) {
         var2 = 0 + -var1 / Class198.Instance._tbNormal.Height;
      }

      return var2;
   }

   private int Method25(int var1) {
      var1 = this.VerticalPosition + var1 + this.Field1249 + this.Field1248 + Class198.Instance.CharSpaceWidth - (!(this._page instanceof Class36) ? Class198.Instance.HeaderHeight : Class198.Instance.Method488()) + Class198.Instance.CharSpaceWidth + this.Field1247 - (!(this._page instanceof Class36) ? Class198.Instance.Field646 : Class198.Instance.Method489());
      int var2 = this.Field1245.length;
      if (var1 > 0) {
         var2 += -var1 / Class198.Instance._tbNormal.Height;
      }

      return var2;
   }

   public final VKMessage GetMessageData() {
      return this.Field1241;
   }

   public void CommandExecuted() {
      if (this.Field1257 != null) {
         Class198.Instance.Method481(this.Field1257);
      }
   }

   public final void Method121(MessageItemUC var1) {
      this.Field1242 = var1 == null || var1.Field1241 == null || this.Field1241 == null || var1.Field1241.from_id != this.Field1241.from_id || Math.abs(var1.Field1241.Method217() - this.Field1241.Method217()) > 300;
      this.Field1268 = true;
   }

   public final void Error(Throwable var1) {
      Class198.Instance.ShowError("Message view: " + var1 != null ? var1.getMessage() : "Unknown error");
   }

   static {
      Field1269 = (Class198.Instance._tbNormal.Height + Class198.Instance.CharSpaceWidth) / 2;
   }
}
