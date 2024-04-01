import javax.microedition.lcdui.Graphics;


public final class ConversationHistoryPage extends Class118 {
   private int Field917;
   private String Field918;
   boolean Field919 = false;
   private int Field920;
   public int Field921;
   public int Field922;
   int Field923 = -1;
   int _startMessageId = -1;
   public final Class376 Field925;
   private int Field926;
   private long Field927;

   public final void Method362(Class328 var1)
   {
      if (var1 instanceof Class498)
      {
         VKMessage var2= ((Class498)var1).GetMessageData();
         if (var2 == null)
         {
            return;
         }

         if (!var2.out && var2.id > this.Field920) {
            this.Field920 = var2.id;
         }
      }

   }

   public static void Method415(int var0, long peerId)  {
      Page var3 = Class198.Instance.Field627;
      if (var3 instanceof ConversationHistoryPage)
      {
         ConversationHistoryPage var4= (ConversationHistoryPage)var3;
         if (var4.Field474.GetPeerId() == peerId)
         {
            synchronized(var4._obj)
            {
               if (var4.IsLoaded && var4._startMessageId < var0) {
                  var4._startMessageId = var0;
                  Class289 var6=new Class289();
                  var6.Method387(var0);
                  var6.GetResponse();
                  
                  if (var6 != null && var6.Method36())
                  {
                     VKMessageAction var2;
                     if (var6.Method194().IsAction() && (var2 = var6.Method194().action).type != null && var2.type.equals("chat_title_update") && var2.text != null && var4.Field474.Method37()) {
                        ((VKConversation)var4.Field474).chat_settings.title = var2.text;
                        var4.Method69();
                     }

                     var4.Method298(0);
                     var4.Method69();
                     boolean var8 = var4.ScrollableHeight - var3.Field813 - var4.Field824 <= Class198.Instance._tbNormal.Height << 1;
                     VKMessage var7 = var6.Method194();
                     var4.AddElement(var4.Method418(var7));
                     var4.Method364(var4.GetWidth(), 1);
                     if (var8 && var7 != null && var7.id > var4.Field920) {
                        var4.Method369(var4.Count() - 1);
                     }
                  }

               }
            }
         }
      }
   }

   public static void Method416(int var0, long peerId) {
      Page var3= Class198.Instance.Field627;
      if (var3 instanceof ConversationHistoryPage)
      {
         ConversationHistoryPage var7;
         if ((var7 = (ConversationHistoryPage)var3).Field474.GetPeerId() == peerId) {
            synchronized(var7._obj) {
            	Class289 var5=new Class289();
            	var5.Method387(var0);
            	var5.GetResponse();
            	
               if (var5 != null && var5.Method36())
               {
                  VKMessage msg = var5.Method194();
                  int index = var7.Method24(msg.id);
                  if (index != -1) {
                     var7.RemoveElementAtPosition(index);
                     var7.Method293(var7.Method418(msg), index);
                     var7.Method119();
                  }
               }

            }
         }
      }
   }

   public static void Method417(int var0, long var1) {
      Page var3;
      if ((var3 = Class198.Instance.Field627) instanceof ConversationHistoryPage) {
         ConversationHistoryPage var5;
         if ((var5 = (ConversationHistoryPage)var3).Field474.GetPeerId() == var1) {
            synchronized(var5._obj) {
               if ((var0 = var5.Method24(var0)) != -1) {
                  var5.RemoveElementAtPosition(var0);
                  var5.Method119();
               }

            }
         }
      }
   }

   public final void Method292(Graphics g, int var2) {
      this.Field925.Field954 = Class198.Instance.getWidth();
      this.Field925.Field956 = 0;
      this.Field925.Method8();
      this.Field824 = Class198.Instance.imgH - this.Field925.Height;
      this.Field925.VerticalPosition = Class198.Instance.HeaderHeight + this.Field824;
      if (g != null) {
         super.Method9(g, this.Field824, var2);
         this.Field925.Method9(g, 0, var2);
      }
   }

   public final void Method62(int var1, int var2) {
      this.Field926 = var2;
      if (this.Field926 >= Class198.Instance.HeaderHeight + this.Field824) {
         this.Field925.Method162(var1, var2, 0);
      } else {
         super.Method62(var1, var2);
      }
   }

   public final void Method63(int var1, int var2) throws Exception{
      if (this.Field926 >= Class198.Instance.HeaderHeight + this.Field824) {
         this.Field925.Method114(var1, var2, 0);
      } else {
         super.Method63(var1, var2);
      }
   }

   public final void Method64(int var1, int var2) {
      if (this.Field926 >= Class198.Instance.HeaderHeight + this.Field824) {
         this.Field925.Method163(var1, var2, 0);
      } else {
         super.Method64(var1, var2);
      }
   }

   public final void Method65(int var1) {
      if ((Class248.Method232(var1) || var1 == 1000011 || var1 == 8 || var1 == 2 || var1 == 5) && !Class198.Instance.Method492() && this.Field474.GetCanWrite() && (this.Field925.Field1087 || !Settings.Instance.UsePQSofts && var1 != 8 && var1 != 50 && var1 != 56)) {
         if (!this.Field925.Field1087) {
            this.Field925.Method305(true);
         }

         this.Field925.Method161(var1, this.VerticalScroll);
      } else {
         super.Method65(var1);
      }
   }

   public final void ButtonPressed(int var1) throws Exception{
      if ((Class248.Method232(var1) || var1 == 1000011 || var1 == 8 || var1 == 2 || var1 == 5) && !Class198.Instance.Method492() && this.Field474.GetCanWrite() && (this.Field925.Field1087 || !Settings.Instance.UsePQSofts && var1 != 8 && var1 != 50 && var1 != 56)) {
         if (!this.Field925.Field1087) {
            this.Field925.Method305(true);
         }

         this.Field925.KeyPressed(var1);
      } else {
         super.ButtonPressed(var1);
      }
   }

   public final void Method67(int var1) {
      if ((Class248.Method232(var1) || var1 == 1000011 || var1 == 8 || var1 == 2 || var1 == 5) && !Class198.Instance.Method492() && this.Field474.GetCanWrite() && (this.Field925.Field1087 || !Settings.Instance.UsePQSofts && var1 != 8 && var1 != 50 && var1 != 56)) {
         if (!this.Field925.Field1087) {
            this.Field925.Method305(true);
         }

         this.Field925.Method159(var1);
      } else {
         super.Method67(var1);
      }
   }

   public final void Method7() {
      if (!Settings.Instance.OldMessagesSoft) {
         super.Method7();
      } else {
         if (this.Field474.GetCanWrite()) {
            this.Field925.Method20();
         }

      }
   }

   public final String Method29() {
      if (!Settings.Instance.OldMessagesSoft) {
         return super.Method29();
      } else if (!this.Field474.GetCanWrite()) {
         return null;
      } else {
         return this.Field925.Field1087 ? Localized.GetString("action.hide") : Localized.GetString("action.reveal");
      }
   }

   public ConversationHistoryPage(VKConversation conversation) {
      super(conversation);
      this.Field920 = this.Field921 = conversation.in_read;
      this.Field922 = conversation.out_read;
      this.Field925 = new Class376(this);
      this.Field825 = new Class36(Localized.GetString("general.actions"));
      if (conversation.GetCanWrite()) {
         this.Field825.AddElement((new Class45(this, Localized.GetString("action.fieldVisibility"))).SetRleIcon("new/pencil.rle"));
      }

      this.Field825.AddElement((new Class43(this, Localized.GetString("action.scrollToBottom"))).SetRleIcon("new/chevron-down.rle"));
      if (conversation.IsDialog()) {
         Class31.Method514(conversation.GetPeerId());
         this.Method360(Button.GetPlatformImage(LoginForm.Method261(Class31.GetUser(conversation.GetPeerId()))));
         this.Field825.AddElement((new Class42(this, Localized.GetString("action.goToProfile"), conversation)).SetRleIcon("new/account.rle"));
      }

      this.Method69();
      this.Method0();
      this.Method292(null, 0);
   }

   public final void Method23()  {
      if (!this.Field919 && !Settings.Instance.ShowMessagesFromEnd) {
         this.Method21();
      } else {
         this.Method305(true);
      }

      this.Method369(this.Count() - 1);
      this.Method305(false);
   }

   public final void Method21()  {
      Class198.Instance.SetInLoadingState(true);
      int var1 = this.Count();
      Class85 var2 = new Class85(this.Field474.GetPeerId(), 5, this.Field923 == -1 ? 0 : 1);
      var2.SetStartMessageId(this.Field923);
      var2.GetResponse();
      
      Class198.Instance.SetInLoadingState(false);
      if (var2 != null && var2.GotSomeItems()) {
         if (var2.items.length < 5) {
            this.IsDone = true;
         }

         int var3 = 0;

         for(int i = var2.items.length - 1; i >= 0; i--) {
            VKMessage var5= var2.items[i];
            if (var5 != null)
            {
               if (this.Field923 == -1 || this.Field923 > var5.id) {
                  this.Field923 = var5.id;
               }

               if (this._startMessageId == -1 || this._startMessageId < var5.id) {
                  this._startMessageId = var5.id;
               }

               this.Method293(this.Method418(var5), var3++);
            }
         }
      } else {
         this.IsDone = true;
         if (var2 == null)
         {
            Class198.Instance.ShowError(Localized.GetString("general.loadError"));
         }
      }

      this.Field814 += (this.Count() - var1);
      this.Method366(this.GetWidth(), this.Count() - var1);
   }

   public final void Method20() {
      try {
		this.Method305(false);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   private void Method305(boolean fromTheEnd) 
   {
      Class198.Instance.SetInLoadingState(true);
      int count = this.Count();
      Class85 var3 = new Class85(this.Field474.GetPeerId(), 5, fromTheEnd ? 0 : (-(count+5)));//-5
      if (!fromTheEnd)
      {
         var3.SetStartMessageId(this._startMessageId);
      }

      var3.GetResponse();//(Class500)var3.DoDispatch();
      Class198.Instance.SetInLoadingState(false);
      if (var3 != null && var3.GotSomeItems())
      {
         if (var3.items.length < 5)
         {
            this.IsLoaded = true;
         }

         for(int l = var3.items.length - 1; l >= 0; l--)
         {
            VKMessage msg= var3.items[l];
            if (msg != null)
            {
               if (this.Field923 == -1 || this.Field923 > msg.id)
               {
                  this.Field923 = msg.id;
               }

               if (this._startMessageId == -1 || this._startMessageId < msg.id)
               {
                  this._startMessageId = msg.id;
               }

               this.AddElement(this.Method418(msg));
            }
         }
      }
      else
      {
         this.IsLoaded = true;
         if (var3.error_code>0)
         {
            Class198.Instance.ShowError(var3.error_msg/*Localized.GetString("general.loadError")*/);
         }
      }

      this.Method364(this.GetWidth(), this.Count() - count);
   }

   private int Method24(int var1) {
      for(int i = this.Count() - 1; i >= 0; i--) {
         Class328 var3= this.ElementAt(i);
         VKMessage var4;
         if (var3 instanceof Class498 && (var4 = ((Class498)var3).GetMessageData()) != null && var4.id == var1) {
            return i;
         }
      }

      return -1;
   }

   public static void Method1(long var0) {
      Page var2;
      if ((var2 = Class198.Instance.Field627) instanceof ConversationHistoryPage) {
         ConversationHistoryPage var4;
         if ((var4 = (ConversationHistoryPage)var2).Field474.GetPeerId() == var0) {
            synchronized(var4._obj) {
               var4.Method298(5);
               var4.Method69();
            }
         }
      }
   }

   public final void Method69()  {
      if (this.Field920 > this.Field921 && !Settings.Instance.DNR) {
         this.Field921 = Math.max(this.Field920, this.Field921);
         (new Class494(this.Field474.GetPeerId(), this.Field920)).DoDispatch();
      }

      String var1 = "";
      DialogItemUC var2= null;//ConversationsPage.Instance.Method284(this.Field474.GetPeerId(), false); //TODO
      if (var2 != null && var2.IsChecked > 0)
      {
         var1 = "(+" + var2.IsChecked + ") ";
      }

      this.Method287(var1 + (this.Field474.GetPeerId() == Settings.Instance.UserId ? Localized.GetString("element.favorites") : this.Field474.Method39()));
      if (Class198.Field620 instanceof Class376 && !Settings.Instance.DNT && System.currentTimeMillis() - this.Field927 > 4000L) {
         this.Field927 = System.currentTimeMillis();
         (new Class250(this.Field474.GetPeerId(), "typing")).DoDispatch();
      }

      this.Method119();
   }

   public final void Method298(int var1) {
      synchronized(this._obj) {
         this.Field917 = Math.max(var1, 0);
         if (this.Field918 == null) {
            this.Field918 = this.Title;
         }

         if (this.Field917 == 0) {
            if (this.Title != null && this.Title.equals(Button.GetPlatformImage(7))) {
               this.Method360(this.Field918);
            }

            this.Field918 = null;
         } else {
            this.Method360(Button.GetPlatformImage(7));
         }

      }
   }

   public final void Method370() {
      if (this.Field917 > 0) {
         this.Method298(this.Field917 - 1);
      }

   }

   public final Page Method293(Class328 var1, int var2) {
      super.Method293(var1, var2);
      this.Method299(var2);
      this.Method299(var2 + 1);
      return this;
   }

   public final Page Method294(Class328 var1) {
      return this.RemoveElementAtPosition(this.GetElementIndex(var1));
   }

   public final Page RemoveElementAtPosition(int var1) {
      super.RemoveElementAtPosition(var1);
      this.Method299(var1 + 1);
      return this;
   }

   public final Page AddElement(Class328 var1) {
      super.AddElement(var1);
      this.Method299(this.Count() - 1);
      return this;
   }

   private void Method299(int var1)
   {
      Class328 var2 = var1 >= 0 && var1 < this.Count() ? this.ElementAt(var1) : null;
      Class328 var3 = var1 - 1 >= 0 && var1 - 1 < this.Count() ? this.ElementAt(var1 - 1) : null;
      if (var2 instanceof MessageItemUC)
      {
         ((MessageItemUC)var2).Method121(var3 instanceof MessageItemUC ? (MessageItemUC)var3 : null);
      }

   }

   private Class328 Method418(VKMessage msg) {
	   if(msg.IsAction())
		   return new MessageActionItemUC((VKConversation)this.Field474, msg);
	   else
		   return new MessageItemUC(this, msg);
      
   }
}
