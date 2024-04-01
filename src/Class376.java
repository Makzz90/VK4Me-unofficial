import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Class376 extends TextBox2 implements Class80, Class466 {
   public boolean Field1087;
   private Class277[] Field1088;
   private static int Field1089;
   private static int Field1090;
   private static int Field1091;
   private static int Field1092;
   private static int Field1093;
   private static int Field1094;
   private int Field1095 = -1;
   private static int Field1096;
   private static int Field1097;
   private static int Field1098;
   private static int Field1099;
   private long Field1100;
   private boolean Field1101;
   private Class36 Field1102;
   public Object Field1103;
   public int Field1104;
   private Class368 Field1105;

   public Class376(ConversationHistoryPage var1) {
      this.Method287(Localized.GetString("action.writeMessageField"));
      this.Field1087 = Settings.Instance.ShowMsgFieldByOpen && var1.Field474.GetCanWrite();
      this.Height = 0;
      this._page = var1;
   }

   public final Class328 Method159(int var1) {
      if (var1 == 2) {
         this.Field1095 = 0;
      } else if (var1 == 5) {
         this.Field1095 = 2;
      } else {
         Class248.Method230(var1, this);
         if (var1 != 8 && var1 != 1000011) {
            this.Field1101 = true;
         }
      }

      return this;
   }

   public final void Method0() {
      if (this.Field1101 && !Settings.Instance.DNT && System.currentTimeMillis() - this.Field1100 > 4000L) {
         this.Field1101 = false;
         this.Field1100 = System.currentTimeMillis();
         try {
			(new Class250(((ConversationHistoryPage)this._page).Field474.GetPeerId(), "typing")).DoDispatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }

   }

   public final Class328 Method161(int var1, int var2) {
      if (var1 != 2 && var1 != 5) {
         Class248.Method231(var1, this);
         if (var1 != 8 && var1 != 1000011) {
            this.Field1101 = true;
         }
      }

      return this;
   }

   public final Class328 KeyPressed(int var1) throws Exception {
      if (var1 == 2) {
         this.Method22();
         this.Field1095 = -1;
      } else if (var1 == 5) {
         this.Method118();
         this.Field1095 = -1;
      }

      return this;
   }

   public final Class328 Method162(int var1, int var2, int var3) {
      this.Field1095 = this.Method304(var1, var2);
      return this;
   }

   public final Class328 Method163(int var1, int var2, int var3) {
      return this;
   }

   public final Class328 Method114(int var1, int var2, int var3) throws Exception {
      if (this.Field1095 != -1 && this.Field1095 == this.Method304(var1, var2)) {
         if (this.Field1095 == 0) {
            this.Method22();
         } else if (this.Field1095 == 1) {
            super.CommandExecuted();
         } else {
            this.Method118();
         }
      }

      this.Field1095 = -1;
      return this;
   }

   private int Method304(int var1, int var2) {
      if (this.Field1087 && var2 < this.VerticalPosition + Field1096 && var2 >= this.VerticalPosition) {
         if (var1 >= this.Field956 && var1 < this.Field956 + Field1098) {
            return 0;
         }

         if (var2 >= this.VerticalPosition + (Field1096 - Field1097) / 2 && var2 < this.VerticalPosition + Field1096 - (Field1096 - Field1097) / 2 && var1 <= this.Field956 - Field1098 + this.Field954 && var1 >= this.Field956 + Field1098) {
            return 1;
         }

         if (var1 <= this.Field956 + this.Field954 && var1 > this.Field956 - Field1098 + this.Field954) {
            return 2;
         }
      }

      return -1;
   }

   public final void Method139(String var1) {
      this.Field477 = var1 == null ? null : new Class277(var1);
      this.Field1088 = null;
   }

   public final void Method288(Class277 var1) {
      this.Field477 = var1;
      this.Field1088 = null;
   }

   public final void Method9(Graphics var1, int var2, int var3) {
      if (((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         this.Method8();
         if (this.Field1087) {
            var1.setColor(Class6.ColorsInstanse.Field352);
            var1.fillRect(this.Field956 + var3, this.VerticalPosition + var2, this.Field954, Field1096);
            Class252.Method328(var1, this.Field956 + var3, this.VerticalPosition + var2, Field1098, Field1096, this.Field1095 == 0 ? Class6.ColorsInstanse.Field302 : Class6.ColorsInstanse.Field352, this.Field1095 == 0 ? Class6.ColorsInstanse.Field303 : Class6.ColorsInstanse.Field352);
            Class252.Method328(var1, this.Field956 + var3 + this.Field954 - Field1098, this.VerticalPosition + var2, Field1098, Field1096, this.Field1095 == 2 ? Class6.ColorsInstanse.Field302 : Class6.ColorsInstanse.Field352, this.Field1095 == 2 ? Class6.ColorsInstanse.Field303 : Class6.ColorsInstanse.Field352);
            var1.setColor(Class6.ColorsInstanse.Field326);
            var1.fillRect(this.Field956 + var3, this.VerticalPosition + var2, this.Field954, 1);
            boolean var4 = this.Field1103 != null && this.Field1104 != 0;
            int h = Class6.ColorsInstanse.Method140(var1, this.Field956 + var3 + Field1098 / 2, this.VerticalPosition + var2 + Field1096 / 2, var4 ? (this.Field1095 == 0 ? Field1090 : Field1089) : (this.Field1095 == 0 ? Field1092 : Field1091), var4 ? "new/close-circle-outline.rle" : "new/paperclip.rle", this.Field1095 == 0 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, this.Field1095 == 0 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, Field1099, 3);
            if (var4) {
               if (this.Field1095 == 0) {
                  Field1090 = h;
               } else {
                  Field1089 = h;
               }
            } else if (this.Field1095 == 0) {
               Field1092 = h;
            } else {
               Field1091 = h;
            }

            int var7 = Class6.ColorsInstanse.Method140(var1, this.Field956 + var3 + this.Field954 - Field1098 / 2, this.VerticalPosition + var2 + Field1096 - Field1096 / 2, this.Field1095 == 2 ? Field1094 : Field1093, "new/send.rle", this.Field1095 == 2 ? Class6.ColorsInstanse.Field307 : Class6.ColorsInstanse.Field295, this.Field1095 == 2 ? Class6.ColorsInstanse.Field308 : Class6.ColorsInstanse.Field296, Field1099, 3);
            if (this.Field1095 == 2) {
               Field1094 = var7;
            } else {
               Field1093 = var7;
            }

            var7 = this.Field954 - (Field1098 << 1) - (Class198.Instance.CharSpaceWidth << 1);
            if (this.Field954 > 0) {
               if (this.Field477 != null && this.Field477.Field876 != 0 && this.Field1088 == null) {
                  this.Field1088 = Class198.Instance._tbNormal.Method91(this.Field477, var7);
               }

               if (this.Field478 != null && this.Field479 == null) {
                  this.Field479 = Class198.Instance._tbNormal.Method92(this.Field478, var7, true);
               }
            }

            h = Class198.Instance._tbNormal.Height;
            if (this.Field1088 != null) {
               var1.setColor(Class6.ColorsInstanse.Field292);
               int var6 = this.VerticalPosition + var2 + Field1096 / 2 - h / 2;
               if (this.Field1088.length >= 2) {
                  var6 -= (h + Class198.Instance.CharSpaceWidth) / 2;
               }

               for(h = Math.max(0, this.Field1088.length - 2); h < this.Field1088.length; h++) {
                  Class198.Instance._tbNormal.Draw(var1, this.Field1088[h], this.Field956 + var3 + (this.Field954 - var7) / 2, var6, 20);
                  var6 += Class198.Instance._tbNormal.Height;
               }
            } else if (this.Field479 != null) {
               var1.setColor(Class6.ColorsInstanse.Field294);
               Class198.Instance._tbNormal.Draw(var1, this.Field479, this.Field956 + var3 + (this.Field954 - var7) / 2, this.VerticalPosition + var2 + Field1096 / 2 - h / 2, 20);
            }

            if (this.Field1105 != null) {
               this.Field1105.Field954 = this.Field954;
               this.Field1105.Method9(var1, this.VerticalPosition + var2 + this.Height - this.Field1105.Height, this.Field956 + var3);
            }

         }
      }
   }

   private void Method22() {
      if (((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         if (this.Field1103 != null && this.Field1104 != 0) {
            this.Method21();
            Class459.Method198(this.Method73());
            this.Field1105 = null;
         } else {
            if (this.Field1102 == null) {
               this.Field1102 = new Class36();
               this.Field1102.AddElement((new Class271(this, Localized.GetString("action.addPhoto"))).SetRleIcon("new/image-plus.rle"));
               this.Field1102.AddElement((new Class269(this, Localized.GetString("action.addDocument"))).SetRleIcon("new/file-plus.rle"));
            }

            Class198.Instance.Method481(this.Field1102);
         }
      }
   }

   public final void Method305(boolean var1) {
      this.Field1087 = var1;
      if (!((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         this.Field1087 = false;
      }

      Class198.Instance.Method470();
      if (((ConversationHistoryPage)this._page).ScrollableHeight > ((ConversationHistoryPage)this._page).Field824) {
         ConversationHistoryPage var10000 = (ConversationHistoryPage)this._page;
         var10000.Field813 += Math.min(((ConversationHistoryPage)this._page).ScrollableHeight - ((ConversationHistoryPage)this._page).Field824, Field1096) * (this.Field1087 ? 1 : -1);
      }

   }

   private void Method118() throws Exception {
      if (((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         if (this.Field1087) {
            if (this.Field1104 == 1) {
               if (Class291.IsNullOrEmpty(this.GetContent())) {
                  return;
               }

               String var3 = null;
               if (((VKMessage)this.Field1103).Method213()) {
                  var3 = "";

                  for(int i = 0; i < ((VKMessage)this.Field1103).attachments.length; i++) {
                     if (((VKMessage)this.Field1103).attachments[i] != null) {
                        var3 = var3 + ((VKMessage)this.Field1103).attachments[i].toString();
                        if (i != ((VKMessage)this.Field1103).attachments.length - 1) {
                           var3 = var3 + ",";
                        }
                     }
                  }
               }

               Class50 var6;
               (var6 = new Class50(((ConversationHistoryPage)this._page).Field474.GetPeerId(), ((VKMessage)this.Field1103).id, this.GetContent())).AddParameter("attachment", var3);
               Class78 var7 = (Class78)var6.DoDispatch();
               LongPollInstanse.Field896 = true;
               if (var7 != null && var7.Method26(((VKMessage)this.Field1103).id)) {
                  if (Settings.Instance.HideAfterSending) {
                     this.Method305(false);
                  }

                  Class248.Method233();
               } else {
                  Class198.Instance.ShowError(Localized.GetString("element.editError"));
               }
            } else {
               if (Class291.IsNullOrEmpty(this.GetContent()) && (this.Field1104 == 0 || this.Field1103 == null || this.Field1103 instanceof String)) {
                  return;
               }

               Class176 var1 = new Class176(((ConversationHistoryPage)this._page).Field474.GetPeerId(), this.GetContent());
               if (this.Field1104 == 2) {
                  var1.Method414((VKMessage)this.Field1103);
               } else if (this.Field1104 == 3) {
                  var1.Method413((Vector)this.Field1103);
               } else if (this.Field1104 == 4) {
                  var1.Method412(((VKAttachment)this.Field1103).toString());
               }

               Class281 var2 = (Class281)var1.DoDispatch();
               LongPollInstanse.Field896 = true;
               if (var2 != null && var2.IsSucsess()) {
                  if (Settings.Instance.HideAfterSending) {
                     this.Method305(false);
                  }

                  Class248.Method233();
               } else {
                  Class198.Instance.ShowError(Localized.GetString("element.sendError"));
               }
            }

            this.Method21();
            this.Method139("");
         }
      }
   }

   public final void Method8() {
      if (!((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         this.Height = 0;
      }

      this.Height = this.Field1087 ? Field1096 : 0;
   }

   public final void Method306(VKMessage var1) {
      if (((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         if (var1 == null || var1.Method211()) {
            this.Method21();
            this.Method139("");
            if (var1 != null) {
               this.Field1104 = 1;
               this.Field1103 = var1;
               this.Method287(Localized.GetString("action.editMessageField"));
               this.Method139(var1.text);
               this.Method305(true);
            }
         }
      }
   }

   public final void Method307(Vector var1) {
      if (((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         if (this.Field1104 != 3) {
            this.Method21();
         }

         if (var1 != null) {
            if (this.Field1103 == null) {
               this.Field1103 = new Vector();
               this.Field1104 = 3;
            }

            ((Vector)this.Field1103).ensureCapacity(((Vector)this.Field1103).size() + var1.size());

            for(int i = 0; i < var1.size(); i++) {
               if (!((Vector)this.Field1103).contains(var1.elementAt(i))) {
                  ((Vector)this.Field1103).addElement(var1.elementAt(i));
               }
            }

         }
      }
   }

   public final void Method308(VKMessage var1) {
      if (((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         if (this.Field1104 != 3) {
            this.Method21();
         }

         if (var1 != null) {
            if (this.Field1103 == null) {
               this.Field1103 = new Vector();
               this.Field1104 = 3;
            }

            if (!((Vector)this.Field1103).contains(var1)) {
               ((Vector)this.Field1103).addElement(var1);
            }

         }
      }
   }

   public final void Method309(VKMessage var1) {
      if (((ConversationHistoryPage)this._page).Field474.GetCanWrite()) {
         this.Method21();
         if (var1 != null) {
            this.Field1104 = 2;
            this.Field1103 = var1;
            this.Method305(true);
         }
      }
   }

   public final void Method20() {
      this.Method305(!this.Field1087);
   }

   public final void Method21() {
      this.Field1104 = 0;
      this.Field1103 = null;
      this.Method287(Localized.GetString("action.writeMessageField"));
   }

   public final void Method1(long var1) {
      if (this.Field1105 == null) {
         Class368 var10001 = new Class368();
         boolean var4 = true;
         Class368 var3 = var10001;
         var10001.Field959 = var4;
         this.Field1105 = (Class368)var3;
      }

      if (this.Field1105 != null) {
         this.Field1105.Method247(var1);
      }

      this._page.Method119();
   }

   public final void Method27(String var1) {
      this.Field1105 = null;
      this.Method21();
      this._page.Method119();
   }

   public final void Method72() {
      this.Field1105 = null;
      this._page.Method119();
   }

   public final String Method73() {
      return this.Field1103 == null ? null : (String)this.Field1103;
   }

   static {
      Field1096 = Class198.Instance._tbNormal.Height * 5 / 2;
      Field1097 = Class198.Instance._tbNormal.Height << 1;
      Field1098 = Field1096;
      Field1099 = Field1096 - Class198.Instance._tbNormal.Height * 5 / 4;
   }
}
