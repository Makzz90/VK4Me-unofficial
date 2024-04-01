

public final class DialogItemUC extends Button {
   private VKMessage _lastMessage;
   VKConversation _conversation;
   public int Field1039;
   private String Field1040;
   private Class277 Field1041;
   private Object Field1042 = new Object();

   public final DialogItemUC PrecessDialogElement(VKConversation conv, VKGroupOrUser profile0)
   {
      if (conv == null)
      {
         return this;
      }
      else
      {
         this._conversation = conv;
 /*
         if (conv.unread_count == 0 && ConversationsPage.Instance != null)
         {
            ConversationsPage.Instance.peerIds.removeElement(new Long(conv.GetPeerId()));
            LoginForm.UpdateCounters();
         }
*/
         if (profile0==null && conv.IsDialog())
         {
            Class31.Method514(conv.GetPeerId());
         }

         VKGroupOrUser profile = profile0;//conv.IsDialog() ? Class31.GetUser(conv.GetPeerId()) : null;
         this.Method107(conv, profile0);
         if (conv.GetPeerId() != Settings.Instance.UserId)
         {
            this.Method97(LoginForm.Method261(profile));
            String lable;
            if (conv.IsDialog())
            {
            	lable = profile0.GetName("nom");
             }
            else
            {
            	lable = conv.Method37() ? conv.chat_settings.title : "";
            }
            this.SetLable(lable/*conv.Method39()*/);
            /*
             * public final String Method39() {
      VKGroupOrUser var1 = this.IsDialog() ? Class31.GetUser(this.peer.id) : null;
      if (this.IsDialog()) {
         return var1 != null ? var1.GetName("nom") : null;
      } else {
         return this.Method37() ? this.chat_settings.title : null;
      }
   }
             * */
             
         }
         else
         {
            this.Method97(0);
            this.SetLable(Localized.GetString("element.favorites"));
         }

         this.Method95(this._lastMessage != null ? this._lastMessage.Method217() : 0);
         this.Method116((short)Math.min(9999, this._conversation.unread_count));
         if (conv.push_settings != null && this._conversation.unread_count > 0) {
            this.Method112((byte)(conv.push_settings.Field525 ? 4 : 3));
         }

         return this;
      }
   }

   public final DialogItemUC ProcessMessageElement(VKConversation conv, VKMessage lastMsg, VKGroupOrUser owner) {
      if (conv != null && lastMsg != null)
      {
         this._lastMessage = lastMsg;
         this.Method65(0);
         this.Method95(this._lastMessage != null ? this._lastMessage.Method217() : 0);
         this.SetSubtitle(lastMsg.Method216(true, conv.IsDialog(), true, true, true, owner));
         boolean isReaded = lastMsg.out && lastMsg.id > conv.out_read;
         this.Method112((byte)(isReaded ? 5 : 3));
         return this;
      } else {
         return this;
      }
   }

   public DialogItemUC(Page page, VKConversation conv, VKMessage lastMsg, VKGroupOrUser convOwner, VKGroupOrUser lastMsgOwner) {
      super(null, (byte)3);
      this.Method109(true);
      this._page = page;
      this.ProcessMessageElement(conv, lastMsg, lastMsgOwner);
      this.PrecessDialogElement(conv, convOwner);
   }

   public final void CommandExecuted()  {
      ConversationsPage var1;
      ConversationHistoryPage var2 = Method209((var1 = (ConversationsPage)this._page).Field768 != null && var1.Field770 != 0 && this._page.Field807 != null ? this._page.Field807 : this._page, this._conversation.GetPeerId());
      if (var1.Field768 != null && var1.Field770 != 0) {
         switch(var1.Field770) {
         case 1:
            var2.Field925.Method307(var1.Field768);
            break;
         case 2:
         case 3:
            var2.Field925.Field1103 = var1.Field768.firstElement();
            var2.Field925.Field1104 = 4;
         }

         var1.Method283(null, 0);
      }

      Class198.Instance.NavigateForward(var2);
   }

   private static ConversationHistoryPage Method209(Page var0, long var1)  {
	   Class49 var3=new Class49();
	   var3.Method525(var1);
	   var3.GetResponse();
	   return var3 != null && var3.Method36() ? (ConversationHistoryPage)(new ConversationHistoryPage(var3.GetConversation())).Method361(var0) : null;
	   
      //return (var3 = (Class517)(new Class49()).Method525(var1).DoDispatch()) != null && var3.Method36() ? (Class296)(new Class296(var3.Method348())).Method361(var0) : null;
   }

   public static ConversationHistoryPage Method210(Page page, long var1)  {
      ConversationHistoryPage var3 = Method209(page, var1);
      Class198.Instance.NavigateForward(var3);
      return var3;
   }

   public final void Method65(int var1) {
      synchronized(this.Field1042) {
         this.Field1039 = Math.max(var1, 0);
         if (this.Field1040 == null) {
            this.Field1040 = this.Field243;
            this.Field1041 = this.SubtitleElement;
         }

         if (this.Field1039 == 0) {
            if (this.Field243 != null && this.Field243.equals(GetPlatformImage(7))) {
               this.Field243 = this.Field1040;
            }

            this.Field1040 = null;
            this.Method111(this.Field1041);
            this.Field1041 = null;
         } else {
            this.Field243 = GetPlatformImage(7);
            if (this.Field1039 == 5) {
               String var10001 = !this._conversation.IsDialog() ? "title.manyUsersTyping" : "title.userTyping";
               String var3 = "";
               this.SetSubtitle(Localized.Method398(var10001, var3, null).trim());
            }
         }

      }
   }
}
