import javax.microedition.lcdui.Graphics;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class Class240 extends Class446 implements Class11 {
   public final Class37 Field755;
   boolean Field756 = false;
   private int Field757;
   public VKNewsfeedPost Field758;
   private int Field759 = 0;
   public VKWallReply Field760;
   boolean Field761;

   public final void Method292(Graphics var1, int var2) {
      this.Field755.Field954 = Class198.Instance.getWidth();
      this.Field755.Field956 = 0;
      this.Field755.Method8();
      this.Field824 = Class198.Instance.imgH - this.Field755.Height;
      this.Field755.VerticalPosition = Class198.Instance.HeaderHeight + this.Field824;
      if (var1 != null) {
         super.Method9(var1, this.Field824, var2);
         this.Field755.Method9(var1, 0, var2);
      }
   }

   public final Page Clear() {
      int var1 = this.Field759;

      while(var1 < this.Count()) {
         super.RemoveElementAtPosition(var1);
      }

      System.gc();
      return this;
   }

   public final void AddItem(Class328 var1) {
      this.AddElement(var1);
      ++this.Field759;
   }

   public final void Method62(int var1, int var2) {
      this.Field757 = var2;
      if (this.Field757 >= Class198.Instance.HeaderHeight + this.Field824) {
         this.Field755.Method162(var1, var2, 0);
      } else {
         super.Method62(var1, var2);
      }
   }

   public final void Method63(int var1, int var2) throws Exception {
      if (this.Field757 >= Class198.Instance.HeaderHeight + this.Field824) {
         this.Field755.Method114(var1, var2, 0);
      } else {
         super.Method63(var1, var2);
      }
   }

   public final void Method64(int var1, int var2) {
      if (this.Field757 >= Class198.Instance.HeaderHeight + this.Field824) {
         this.Field755.Method163(var1, var2, 0);
      } else {
         super.Method64(var1, var2);
      }
   }

   public final void Method65(int var1) {
      if ((Class248.Method232(var1) || var1 == 1000011 || var1 == 8 || var1 == 2 || var1 == 5) && !Class198.Instance.Method492() && this.Field758.GetCanWrite() && (this.Field755.Field70 || !Settings.Instance.UsePQSofts && var1 != 8 && var1 != 50 && var1 != 56)) {
         if (!this.Field755.Field70) {
            this.Field755.Method305(true);
         }

         this.Field755.Method161(var1, this.VerticalScroll);
      } else {
         super.Method65(var1);
      }
   }

   public final void ButtonPressed(int var1) throws Exception {
      if ((Class248.Method232(var1) || var1 == 1000011 || var1 == 8 || var1 == 2 || var1 == 5) && !Class198.Instance.Method492() && this.Field758.GetCanWrite() && (this.Field755.Field70 || !Settings.Instance.UsePQSofts && var1 != 8 && var1 != 50 && var1 != 56)) {
         if (!this.Field755.Field70) {
            this.Field755.Method305(true);
         }

         this.Field755.KeyPressed(var1);
      } else {
         super.ButtonPressed(var1);
      }
   }

   public final void Method67(int var1) {
      if ((Class248.Method232(var1) || var1 == 1000011 || var1 == 8 || var1 == 2 || var1 == 5) && !Class198.Instance.Method492() && this.Field758.GetCanWrite() && (this.Field755.Field70 || !Settings.Instance.UsePQSofts && var1 != 8 && var1 != 50 && var1 != 56)) {
         if (!this.Field755.Field70) {
            this.Field755.Method305(true);
         }

         this.Field755.Method159(var1);
      } else {
         super.Method67(var1);
      }
   }

   public final void Method7() {
      if (!Settings.Instance.OldCommentsSoft) {
         super.Method7();
      } else {
         if (this.Field758.GetCanWrite()) {
            this.Field755.Method0();
         }

      }
   }

   public final String Method29() {
      if (!Settings.Instance.OldCommentsSoft) {
         return super.Method29();
      } else if (!this.Field758.GetCanWrite()) {
         return null;
      } else {
         return this.Field755.Field70 ? Localized.GetString("action.hide") : Localized.GetString("action.reveal");
      }
   }

   public Class240(VKNewsfeedPost post, VKWallReply var2) {
      super(Localized.GetString("title.comments"), true);
      this.Field761 = Settings.Instance.ShowReplies;
      this.Field758 = post;
      this.Field760 = var2;
      this.Field755 = new Class37(this);
      this.Field825 = new Class36(Localized.GetString("general.actions"));
      if (post.GetCanWrite()) {
         this.Field825.AddElement((new Class356(this, Localized.GetString("action.fieldVisibility"))).SetRleIcon("new/pencil.rle"));
      }

      this.Field825.AddElement((new Class359(this, Localized.GetString("action.refresh"))).SetRleIcon("new/refresh.rle"));
      this.Field825.AddElement((new Class354(this, Localized.GetString("action.upperComments"))).SetRleIcon("new/chevron-up.rle"));
      this.Field825.AddElement((new Class355(this, Localized.GetString("action.switchOrder"))).SetRleIcon("new/chevron-down.rle"));
      this.Field825.AddElement((new Class361(this, Localized.GetString("action.switchReplies"))).SetRleIcon("new/message.rle"));
      NewsfeedPage.ProcessPost(this, post,null);
      this.Method21();
      this.Method292((Graphics)null, 0);
   }

   public final void LoadData()  {
      Class198.Instance.SetInLoadingState(true);
      int var1 = this.Count();
      Class282 var10000 = new Class282(5, this.next_from == null ? 0 : 1);
      VKNewsfeedPost var3 = this.Field758;
      Class282 var5 = var10000;
      var10000.AddLong("owner_id", var3.owner_id);
      var5.AddIntiger("post_id", var3.id);
      Class282 var2 = var5.Method404(this.Field756 ? "desc" : "asc");
      int commentId;
      if (this.Field760 != null) {
         commentId = this.Field760.id;
         var2.AddIntiger("comment_id", commentId);
      }

      if (this.next_from != null) {
         commentId = ((Integer)this.next_from).intValue();
         var2.AddIntiger("start_comment_id", commentId);
      } else {
         this.next_from = new Integer(this.Field756 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
      }

      var2.GetResponse();
      //Class267 var7 = (Class267)var2.DoDispatch();
      Class198.Instance.SetInLoadingState(false);
      if (var2 != null && var2.Items != null && var2.Items.length > 0)
      {
         if (var2.Items.length < 5)
         {
            this.IsAllLoaded = true;
         }

         for(commentId = 0; commentId < var2.Items.length; commentId++) {
            VKWallReply var4= var2.Items[commentId];
            if (var4 != null) {
               if (!this.Field756 && ((Integer)this.next_from).intValue() < var4.id || this.Field756 && ((Integer)this.next_from).intValue() > var4.id) {
                  this.next_from = new Integer(var4.id);
               }

               this.AddElement(this.Method297(var4));
               Class186 var9= var4.thread;
               if (this.Field761 && var4.Method2() && var9.Items != null && var9.Items.length > 0) {
                  for(int var10 = 0; var10 < var4.thread.Items.length; var10++) {
                     VKWallReply var6;
                     if ((var6 = var4.thread.Items[var10]) != null) {
                        var6.Field841 = var4;
                        this.AddElement(this.Method297(var6));
                     }
                  }
               }
            }
         }
      } else {
         this.IsAllLoaded = true;
         if (var2 == null) {
            Class198.Instance.ShowError(Localized.GetString("general.loadError"));
         }
      }

      this.Method364(this.GetWidth(), this.Count() - var1);
   }

   private int Method24(int var1) {
      for(int i = this.Count() - 1; i >= 0; i--) {
         Class328 var3;
         VKWallReply var4;
         if ((var3 = this.ElementAt(i)) instanceof Class266 && (var4 = ((Class266)var3).Method19()) != null && var4.id == var1) {
            return i;
         }
      }

      return -1;
   }

   public final Page Method293(Class328 var1, int var2) {
      super.Method293(var1, var2);
      return this;
   }

   public final Page Method294(Class328 var1) {
      int var2 = this.GetElementIndex(var1);
      super.RemoveElementAtPosition(var2);
      return this;
   }

   public final Page RemoveElementAtPosition(int var1) {
      super.RemoveElementAtPosition(var1);
      return this;
   }

   public final Page AddElement(Class328 var1) {
      super.AddElement(var1);
      this.Count();
      return this;
   }

   private Class328 Method297(VKWallReply var1) {
	   if(var1.Method36())
	   {
		   return new Class62(var1);
	   }
	   else
	   {
		   return new Class64(this, var1);
	   }
      
   }

   public static void Method298(int var0) {
      Page var1;
      if ((var1 = Class198.Instance.Field627) instanceof Class240) {
         Class240 var5;
         synchronized((var5 = (Class240)var1)._obj) {
            if ((var0 = var5.Method24(var0)) != -1) {
               var5.RemoveElementAtPosition(var0);
               var5.Method119();
            }

         }
      }
   }

   public static void Method299(int var0)  {
      Page var1;
      if ((var1 = Class198.Instance.Field627) instanceof Class240) {
         Class240 var9;
         synchronized((var9 = (Class240)var1)._obj) {
        	 Class217 var7 = new Class217(var9.Field758.owner_id, var0);
        	 var7.GetResponse();
            if ((var7) != null && var7.Method36()) {
               VKWallReply var8 = var7.Method410();
               int var3;
               if ((var3 = var9.Method24(var8.id)) != -1) {
                  var9.RemoveElementAtPosition(var3);
                  var9.Method293(var9.Method297(var8), var3);
                  var9.Method119();
               }
            }

         }
      }
   }

   public static void Method300(int var0)  {
      Page var1;
      if ((var1 = Class198.Instance.Field627) instanceof Class240) {
         Class240 var2;
         synchronized((var2 = (Class240)var1)._obj) {
        	 Class217 var5 = new Class217(var2.Field758.owner_id, var0);
        	 var5.GetResponse();
            if ((var5) != null && var5.Method36()) {
               boolean var7 = var2.ScrollableHeight - var1.Field813 - var2.Field824 <= Class198.Instance._tbNormal.Height << 1;
               VKWallReply var6 = var5.Method410();
               var2.AddElement(var2.Method297(var6));
               var2.Method364(var2.GetWidth(), 1);
               if (var7 && var6 != null) {
                  var2.Method369(var2.Count() - 1);
               }
            }

         }
      }
   }
}
