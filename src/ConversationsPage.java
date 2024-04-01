import java.util.Vector;
import javax.microedition.lcdui.Display;
import ru.curoviyxru.phoenix.midlet.Midlet;

public final class ConversationsPage extends Class446
{
//   public static ConversationsPage Instance;
   public Vector Field768;
   public Vector peerIds = new Vector();
   public int Field770;

   public static void Method277(boolean var0, long peer_id)
   {
	   /*
      if (Instance != null)
      {
         synchronized(Instance._obj)
         {
            DialogItemUC var4= Instance.Method284(peer_id, true);
            if (var4 == null) {
               return;
            }

            if (!var0) {
               if (var4.Type != 4) {
                  if (Settings.Instance.FeedNotVibro) {
                     Display.getDisplay(Midlet.Instance).vibrate(100);
                  }

                  if (Settings.Instance.FeedNotSound) {
                     Class198.Play();
                  }
               }

               Long peerId = new Long(peer_id);
               if (!Instance.peerIds.contains(peerId)) {
                  Instance.peerIds.addElement(peerId);
               }

               LoginForm.UpdateCounters();
            }

            Method278(var4);
            Instance.Method294(var4);
            Instance.Method293(var4, 0);
         }

         Instance.Method119();
      }*/
   }

   private static void Method278(DialogItemUC dialogElement) {
	   Class49 var1 = new Class49(dialogElement._conversation.GetPeerId());
	   var1.GetResponse();
      VKConversation conv = var1.GetConversation();//(var1 = (Class517)(new Class49(dialogElement.Field1038.GetPeerId())).DoDispatch()) != null ? var1.Method348() : null;
    
      //Class500
      Class85 var2= new Class85(dialogElement._conversation.GetPeerId(), 1);//messages.getHistory
      var2.GetResponse();
      
      if (var2 != null && var2.GotSomeItems())
      {
    	  VKGroupOrUser lastMsgOwner = var2.GetOwnerById(var2.items[0].from_id);
         dialogElement.ProcessMessageElement(conv != null ? conv : dialogElement._conversation, var2.items[0],lastMsgOwner);
      }

      if (conv != null)
      {
    	  VKGroupOrUser dialogOwner = null;
    	  
    	  if(conv.IsDialog())
    	  {
    		  long id = conv.GetPeerId();
    		  dialogOwner = var2.GetOwnerById(id);
    	  }
    	  
    	  
    	  
    	  
         dialogElement.PrecessDialogElement(conv,dialogOwner);
      }

   }
   /*
   public static void Method1(long var0) {
      try {
		Method282(var0);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   public static void Method279(long var0) {
      try {
		Method282(var0);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   public static void Method280(long var0) {
      try {
		Method282(var0);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   public static void Method281(long var0) {
      try {
		Method282(var0);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   private static void Method282(long var0) throws Exception {
      if (Instance != null)
      {
         synchronized(Instance._obj)
         {
            DialogItemUC var4;
            if ((var4 = Instance.Method284(var0, false)) == null) {
               return;
            }

            Method278(var4);
         }

         Instance.Method119();
      }
   }
*/
   public ConversationsPage() {
      super(Localized.GetString("title.messaging"), false);
//      Instance = this;
      this.Method20();
   }

   public final void Method20()
   {/*
      synchronized(Instance._obj)
      {
         this.peerIds.removeAllElements();
         //Class373 var2=new Class373();//Class373 var2_0=(Class373)(new Class483()).SetCount(0).DoDispatch();
         Class483 var2=(new Class483()).SetCount(0);//"messages.getConversations"
         var2.GetResponse();
         if (var2 != null && var2.Count != 0)
         {
        	 
            Class483 var5 = (new Class483()).SetCount(var2.Count);
            //Class483 var5 = var10000;
            var5.AddParameter("filter", "unread");
            JSONObject temp = var5.GetResponse();
            var2.ProcessFields(temp);//Class373
            
            if (var2 != null && var2.GotSomeItems())
            {
               for(int i = 0; i < var2.Items.length; i++)
               {
                  VKConversationWithLastMessage conv = var2.Items[i];
                  if (conv != null && conv.conversation != null) {
                     Long peer_id = new Long(conv.conversation.GetPeerId());
                     if (!this.peerIds.contains(peer_id)) {
                        this.peerIds.addElement(peer_id);
                     }
                  }
               }
            }
         }
*/
         LoginForm.UpdateCounters();
//      }

      super.Method20();
   }

   public final void Method283(Vector var1, int var2) {
      this.Field768 = var1;
      this.Field770 = var2;
      this.Method23();
      this.Method361(LoginForm.HomePage);
   }

   public final void Method23() {
      String var1 = Class467.Method12(Math.min(9999, this.peerIds.size()));
      String title;
      if (this.Field768 != null && this.Field770 != 0)
      {
         title = Localized.GetString("title.forwardTo");//Переслать...
      }
//      else if (this.peerIds.size() > 0)
//      {
         //String var2 = var1;
//         title = Localized.Method398("title.messagingWithCount", var1, null);//Сообщения (%%)
//      }
      else
      {
         title = Localized.GetString("title.messaging");//Сообщения
      }

      this.Method287(title);
   }

   public final DialogItemUC Method284(long peerId, boolean var3)
   {
      for(int i = 0; i < this.Count(); i++) {
         Class328 var5= this.ElementAt(i);
         DialogItemUC var12;
         if (var5 instanceof DialogItemUC && (var12 = (DialogItemUC)var5)._conversation.GetPeerId() == peerId) {
            return var12;
         }
      }

      Object var10000;
      if (var3)
      {
    	  Class49 var2=new Class49(peerId);
    	  var2.GetResponse();
         if (var2.Method36())
         {
        	 Class85 var11 = new Class85(peerId, 1);
        	 var11.GetResponse();
        	 
            DialogItemUC var10 = new DialogItemUC(this, var2.GetConversation(), var11 != null && var11.GotSomeItems() ? var11.items[0] : null,null,null);
            this.Method293(var10, 0);
            return var10;
         }

         var10000 = null;
      } else {
         var10000 = null;
      }

      return (DialogItemUC)var10000;
   }

   public final void LoadData() 
   {
      Class198.Instance.SetInLoadingState(true);
      boolean var2 = this.next_from == null;
      if (var2)
      {
         this.next_from = new Integer(-5);
      }

      this.next_from = new Integer(((Integer)this.next_from).intValue() + 5);
      Class483 var4 = new Class483();
      var4.SetCount(10);
      int offset = ((Integer)this.next_from).intValue();
      var4.AddIntiger("offset", offset);
      if (!var2)
      {
         offset = ((Integer)this.LastElementId).intValue();
         var4.AddIntiger("start_message_id", offset);
      }
      else
      {
         this.LastElementId = new Integer(Integer.MIN_VALUE);
      }

      //Class373 var3 = new Class373();
      //JSONObject temp = var4.GetResponse();
      //var3.ProcessFields(temp);
      
      var4.GetResponse();
      
      if (var4 != null && var4.GotSomeItems())
      {
         if (var4.Items.length < 5)
         {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var4.Items.length; i++)
         {
            VKConversationWithLastMessage convWithMsg = var4.Items[i];
            VKConversation conv = convWithMsg.conversation;
            VKMessage lastMsg = convWithMsg.last_message;
            
            if (conv != null && lastMsg != null)
            {
               if (var2 && ((Integer)this.LastElementId).intValue() < lastMsg.id)
               {
                  this.LastElementId = new Integer(lastMsg.id);
               }
               
               VKGroupOrUser profile = null;
               if(conv.IsDialog())
               {
            	   long peerId = conv.GetPeerId();
            	   profile=var4.GetOwnerById(peerId);
               }

               VKGroupOrUser lastMsgOwner = var4.GetOwnerById(lastMsg.from_id);
               
               this.AddElement(new DialogItemUC(this, conv, lastMsg,profile,lastMsgOwner));
            }
         }
      }
      else
      {
         this.IsAllLoaded = true;
         if (var4.error_code>0)
         {
            Class198.Instance.ShowError(var4.error_msg/*Localized.GetString("general.loadError")*/);
         }
      }

      this.Method364(this.GetWidth(), 5);
      Class198.Instance.SetInLoadingState(false);
   }

   public final void Method285(long var1)
   {
      if (Settings.Instance.TypingInDialogs) {
         DialogItemUC var3= this.Method284(var1, false);
         if (var3 != null)
         {
            var3.Method65(5);
            this.Method119();
         }
      }
   }

   public final void Method286(long var1)  {
      if (Settings.Instance.TypingInDialogs) {
         DialogItemUC var3= this.Method284(var1, false);
         if (var3 != null)
         {
            var3.Method65(5);
            this.Method119();
         }
      }
   }
}
