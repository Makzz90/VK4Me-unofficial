import javax.microedition.lcdui.Graphics;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Class37 extends TextBox2 implements Class80, Class466 {
   public boolean Field70;
   private Class277[] Field71;
   private static int Field72;
   private static int Field73;
   private static int Field74;
   private static int Field75;
   private static int Field76;
   private static int Field77;
   private int Field78 = -1;
   private static int Field79;
   private static int Field80;
   private static int Field81;
   private static int Field82;
   private Class36 Field83;
   public Object Field84;
   int Field85;
   private Class368 Field86;

   public Class37(Class240 var1) {
      this.Method287(Localized.GetString("action.writeMessageField"));
      this.Field70 = Settings.Instance.ShowCmtFieldByOpen && var1.Field758.GetCanWrite();
      this.Height = 0;
      this._page = var1;
   }

   public final Class328 Method159(int var1) {
      if (var1 == 2) {
         this.Field78 = 0;
      } else if (var1 == 5) {
         this.Field78 = 2;
      } else {
         Class248.Method230(var1, this);
      }

      return this;
   }

   public final Class328 Method161(int var1, int var2) {
      if (var1 != 2 && var1 != 5) {
         Class248.Method231(var1, this);
      }

      return this;
   }

   public final Class328 KeyPressed(int var1) {
      if (var1 == 2) {
         this.Method21();
         this.Field78 = -1;
      } else if (var1 == 5) {
         this.Method22();
         this.Field78 = -1;
      }

      return this;
   }

   public final Class328 Method162(int var1, int var2, int var3) {
      this.Field78 = this.Method304(var1, var2);
      return this;
   }

   public final Class328 Method163(int var1, int var2, int var3) {
      return this;
   }

   public final Class328 Method114(int var1, int var2, int var3) {
      if (this.Field78 != -1 && this.Field78 == this.Method304(var1, var2)) {
         if (this.Field78 == 0) {
            this.Method21();
         } else if (this.Field78 == 1) {
            super.CommandExecuted();
         } else {
            this.Method22();
         }
      }

      this.Field78 = -1;
      return this;
   }

   private int Method304(int var1, int var2) {
      if (this.Field70 && var2 < this.VerticalPosition + Field79 && var2 >= this.VerticalPosition) {
         if (var1 >= this.Field956 && var1 < this.Field956 + Field81) {
            return 0;
         }

         if (var2 >= this.VerticalPosition + (Field79 - Field80) / 2 && var2 < this.VerticalPosition + Field79 - (Field79 - Field80) / 2 && var1 <= this.Field956 - Field81 + this.Field954 && var1 >= this.Field956 + Field81) {
            return 1;
         }

         if (var1 <= this.Field956 + this.Field954 && var1 > this.Field956 - Field81 + this.Field954) {
            return 2;
         }
      }

      return -1;
   }

   public final void Method139(String var1) {
      this.Field477 = var1 == null ? null : new Class277(var1);
      this.Field71 = null;
   }

   public final void Method288(Class277 var1) {
      this.Field477 = var1;
      this.Field71 = null;
   }

   public final void Method9(Graphics var1, int var2, int var3) {
      if (((Class240)this._page).Field758.GetCanWrite()) {
         this.Method8();
         if (this.Field70) {
            var1.setColor(Class6.ColorsInstanse.Field352);
            var1.fillRect(this.Field956 + var3, this.VerticalPosition + var2, this.Field954, Field79);
            Class252.Method328(var1, this.Field956 + var3, this.VerticalPosition + var2, Field81, Field79, this.Field78 == 0 ? Class6.ColorsInstanse.Field302 : Class6.ColorsInstanse.Field352, this.Field78 == 0 ? Class6.ColorsInstanse.Field303 : Class6.ColorsInstanse.Field352);
            Class252.Method328(var1, this.Field956 + var3 + this.Field954 - Field81, this.VerticalPosition + var2, Field81, Field79, this.Field78 == 2 ? Class6.ColorsInstanse.Field302 : Class6.ColorsInstanse.Field352, this.Field78 == 2 ? Class6.ColorsInstanse.Field303 : Class6.ColorsInstanse.Field352);
            var1.setColor(Class6.ColorsInstanse.Field326);
            var1.fillRect(this.Field956 + var3, this.VerticalPosition + var2, this.Field954, 1);
            boolean var4 = this.Field84 != null && this.Field85 != 0;
            int h = Class6.ColorsInstanse.Method140(var1, this.Field956 + var3 + Field81 / 2, this.VerticalPosition + var2 + Field79 / 2, var4 ? (this.Field78 == 0 ? Field73 : Field72) : (this.Field78 == 0 ? Field75 : Field74), var4 ? "new/close-circle-outline.rle" : "new/paperclip.rle", this.Field78 == 0 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, this.Field78 == 0 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, Field82, 3);
            if (var4) {
               if (this.Field78 == 0) {
                  Field73 = h;
               } else {
                  Field72 = h;
               }
            } else if (this.Field78 == 0) {
               Field75 = h;
            } else {
               Field74 = h;
            }

            int var7 = Class6.ColorsInstanse.Method140(var1, this.Field956 + var3 + this.Field954 - Field81 / 2, this.VerticalPosition + var2 + Field79 - Field79 / 2, this.Field78 == 2 ? Field77 : Field76, "new/send.rle", this.Field78 == 2 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, this.Field78 == 2 ? Class6.ColorsInstanse.Field308 : Class6.ColorsInstanse.Field296, Field82, 3);
            if (this.Field78 == 2) {
               Field77 = var7;
            } else {
               Field76 = var7;
            }

            var7 = this.Field954 - (Field81 << 1) - (Class198.Instance.CharSpaceWidth << 1);
            if (this.Field954 > 0) {
               if (this.Field477 != null && this.Field477.Field876 != 0 && this.Field71 == null) {
                  this.Field71 = Class198.Instance._tbNormal.Method91(this.Field477, var7);
               }

               if (this.Field478 != null && this.Field479 == null) {
                  this.Field479 = Class198.Instance._tbNormal.Method92(this.Field478, var7, true);
               }
            }

            h = Class198.Instance._tbNormal.Height;
            if (this.Field71 != null) {
               var1.setColor(Class6.ColorsInstanse.Field292);
               int var6 = this.VerticalPosition + var2 + Field79 / 2 - h / 2;
               if (this.Field71.length >= 2) {
                  var6 -= (h + Class198.Instance.CharSpaceWidth) / 2;
               }

               for(h = Math.max(0, this.Field71.length - 2); h < this.Field71.length; h++) {
                  Class198.Instance._tbNormal.Draw(var1, this.Field71[h], this.Field956 + var3 + (this.Field954 - var7) / 2, var6, 20);
                  var6 += Class198.Instance._tbNormal.Height;
               }
            } else if (this.Field479 != null) {
               var1.setColor(Class6.ColorsInstanse.Field294);
               Class198.Instance._tbNormal.Draw(var1, this.Field479, this.Field956 + var3 + (this.Field954 - var7) / 2, this.VerticalPosition + var2 + Field79 / 2 - h / 2, 20);
            }

            if (this.Field86 != null) {
               this.Field86.Field954 = this.Field954;
               this.Field86.Method9(var1, this.VerticalPosition + var2 + this.Height - this.Field86.Height, this.Field956 + var3);
            }

         }
      }
   }

   private void Method21() {
      if (((Class240)this._page).Field758.GetCanWrite()) {
         if (this.Field84 != null && this.Field85 != 0) {
            this.Method20();
            Class459.Method198(this.Method73());
            this.Field86 = null;
         } else {
            if (this.Field83 == null) {
               this.Field83 = new Class36();
               this.Field83.AddElement((new Class522(this, Localized.GetString("action.addPhoto"))).SetRleIcon("new/image-plus.rle"));
               this.Field83.AddElement((new Class521(this, Localized.GetString("action.addDocument"))).SetRleIcon("new/file-plus.rle"));
            }

            Class198.Instance.Method481(this.Field83);
         }
      }
   }

   public final void Method305(boolean var1) {
      this.Field70 = var1;
      if (!((Class240)this._page).Field758.GetCanWrite()) {
         this.Field70 = false;
      }

      Class198.Instance.Method470();
      if (((Class240)this._page).ScrollableHeight > ((Class240)this._page).Field824) {
         Class240 var10000 = (Class240)this._page;
         var10000.Field813 += Math.min(((Class240)this._page).ScrollableHeight - ((Class240)this._page).Field824, Field79) * (this.Field70 ? 1 : -1);
      }

   }

   private void Method22() {
      if (((Class240)this._page).Field758.GetCanWrite()) {
         if (this.Field70) {
            if (this.Field85 == 1) {
               if (Class291.IsNullOrEmpty(this.GetContent())) {
                  return;
               }

               String var3 = null;
               if (((VKWallReply)this.Field84).IsAttachmentsExists()) {
                  var3 = "";

                  for(int i = 0; i < ((VKWallReply)this.Field84).attachments.length; i++) {
                     if (((VKWallReply)this.Field84).attachments[i] != null) {
                        var3 = var3 + ((VKWallReply)this.Field84).attachments[i].toString();
                        if (i != ((VKWallReply)this.Field84).attachments.length - 1) {
                           var3 = var3 + ",";
                        }
                     }
                  }
               }

               Class479 var6;
               (var6 = new Class479(((Class240)this._page).Field758.owner_id, ((VKWallReply)this.Field84).id, this.GetContent())).AddParameter("attachments", var3);
               Class426 var7;
               if ((var7 = (Class426)var6.DoDispatch()) != null && var7.Method26(((VKWallReply)this.Field84).id)) {
                  if (Settings.Instance.HideAfterSending) {
                     this.Method305(false);
                  }

                  Class240.Method299(((VKWallReply)this.Field84).id);
                  Class248.Method233();
               } else {
                  Class198.Instance.ShowError(Localized.GetString("element.editError"));
               }
            } else {
               if (Class291.IsNullOrEmpty(this.GetContent()) && (this.Field85 == 0 || this.Field84 == null || this.Field84 instanceof String)) {
                  return;
               }

               Class397 var1 = new Class397(((Class240)this._page).Field758, this.GetContent());
               if (this.Field85 == 2) {
                  var1.Method385((VKWallReply)this.Field84);
               } else if (this.Field85 != 3 && this.Field85 == 4) {
                  var1.Method384(((VKAttachment)this.Field84).toString());
               }

               Class66 var2;
               if ((var2 = (Class66)var1.DoDispatch()) != null && var2.IsSucsess()) {
                  if (Settings.Instance.HideAfterSending) {
                     this.Method305(false);
                  }

                  Class240.Method300(var2.Field195);
                  Class248.Method233();
               } else {
                  Class198.Instance.ShowError(Localized.GetString("element.sendError"));
               }
            }

            this.Method20();
            this.Method139("");
         }
      }
   }

   public final void Method8() {
      if (!((Class240)this._page).Field758.GetCanWrite()) {
         this.Height = 0;
      }

      this.Height = this.Field70 ? Field79 : 0;
   }

   public final void Method456(VKWallReply var1) {
      if (((Class240)this._page).Field758.GetCanWrite()) {
         if (var1 == null || var1.Method211()) {
            this.Method20();
            this.Method139("");
            if (var1 != null) {
               this.Field85 = 1;
               this.Field84 = var1;
               this.Method287(Localized.GetString("action.editMessageField"));
               this.Method139(var1.text);
               this.Method305(true);
            }
         }
      }
   }

   public final void Method457(VKWallReply var1) {
      if (((Class240)this._page).Field758.GetCanWrite()) {
         this.Method20();
         if (var1 != null) {
            this.Field85 = 2;
            this.Field84 = var1;
            this.Method305(true);
         }
      }
   }

   public final void Method0() {
      this.Method305(!this.Field70);
   }

   public final void Method20() {
      this.Field85 = 0;
      this.Field84 = null;
      this.Method287(Localized.GetString("action.writeMessageField"));
   }

   public final void Method1(long var1) {
      if (this.Field86 == null) {
         Class368 var10001 = new Class368();
         boolean var4 = true;
         Class368 var3 = var10001;
         var10001.Field959 = var4;
         this.Field86 = (Class368)var3;
      }

      if (this.Field86 != null) {
         this.Field86.Method247(var1);
      }

      this._page.Method119();
   }

   public final void Method27(String var1) {
      this.Field86 = null;
      this.Method20();
      this._page.Method119();
   }

   public final void Method72() {
      this.Field86 = null;
      this._page.Method119();
   }

   public final String Method73() {
      return this.Field84 == null ? null : (String)this.Field84;
   }

   static {
      Field79 = Class198.Instance._tbNormal.Height * 5 / 2;
      Field80 = Class198.Instance._tbNormal.Height << 1;
      Field81 = Field79;
      Field82 = Field79 - Class198.Instance._tbNormal.Height * 5 / 4;
   }
}
