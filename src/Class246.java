public class Class246 {
   public void Method248()
   {
      Class198.Instance.Field616 = true;
      Class198.Instance.Repaint();
   }

   public void Method249()
   {
      Class198.Instance.Field616 = false;
 //     Class198.Field618.Repaint();//TODO
   }

   public void ProcessUpdates(JSONArray json)
   {
      if (json != null)
      {
         Logger.PrintToConsole("[UPD] " + json.toString());
         byte var4 = 0;
         Page var3;
         ConversationHistoryPage var7;
         long var12;
         ConversationsPage var14;
         int var15;
         long var10000;
         long var10001;
         int var2 = json.Method506(var4, 0);
         switch(var2) {
         case 1:
         case 2:
            var4 = 2;
            if (((var2 = json.Method506(var4, 0)) & 131072) == 131072 || (var2 & 128) == 128) {
               var4 = 3;
//               ConversationsPage.Method280(ja.Method509(var4, 0L));
               var4 = 1;
               var15 = json.Method506(var4, 0);
               var4 = 3;
               ConversationHistoryPage.Method417(var15, json.Method509(var4, 0L));
               return;
            }
            break;
         case 4:
            var4 = 2;
            boolean var16 = (json.Method506(var4, 0) & 2) == 2;
            var4 = 3;
            ConversationsPage.Method277(var16, json.Method509(var4, 0L));
            var4 = 1;
            var15 = json.Method506(var4, 0);
            var4 = 3;
            ConversationHistoryPage.Method415(var15, json.Method509(var4, 0L));
            return;
         case 5:
            var4 = 3;
//            ConversationsPage.Method281(ja.Method509(var4, 0L));//TODO
            var4 = 1;
            var15 = json.Method506(var4, 0);
            var4 = 3;
            ConversationHistoryPage.Method416(var15, json.Method509(var4, 0L));
            return;
         case 6:
         case 7:
            var4 = 1;
//            ConversationsPage.Method1(ja.Method509(var4, 0L));
            var15 = var2;
            var4 = 1;
            var10001 = json.Method509(var4, 0L);
            var4 = 2;
            var2 = json.Method506(var4, 0);
            long var5 = var10001;
            int var13 = var15;
            if (!((var3 = Class198.Instance.Field627) instanceof ConversationHistoryPage) || (var7 = (ConversationHistoryPage)var3).Field474.GetPeerId() != var5) {
               return;
            }

            synchronized(var7._obj) {
               if (var13 == 7) {
                  var7.Field922 = Math.max(var2, var7.Field922);
               } else {
                  var7.Field921 = Math.max(var2, var7.Field921);
               }

               var7.Method119();
               break;
            }
         case 8:
         case 9:
            var4 = 1;
            var12 = -json.Method509(var4, 0L);
            Page var6;
            ConversationHistoryPage var11;
            if ((var6 = Class198.Instance.Field627) instanceof ConversationHistoryPage && (var11 = (ConversationHistoryPage)var6).Field474.GetPeerId() == var12) {
               Class31.Method514(var12);
               synchronized(var11._obj) {
                  var11.Method360(Button.GetPlatformImage(LoginForm.Method261(Class31.GetUser(var12))));
                  var11.Method119();
               }
            }

            var4 = 1;
//            ConversationsPage.Method279(-ja.Method509(var4, 0L));
            return;
         case 61:
            var4 = 1;
            var10000 = json.Method509(var4, 0L);
            var4 = 1;
            json.Method509(var4, 0L);
            ConversationHistoryPage.Method1(var10000);
//            var14 = ConversationsPage.Instance;
            var4 = 1;
            var10001 = json.Method509(var4, 0L);
            var4 = 1;
            json.Method509(var4, 0L);
//            var14.Method285(var10001);
            return;
         case 62:
            var4 = 2;
            var10000 = json.Method509(var4, 0L);
            var4 = 1;
            json.Method509(var4, 0L);
            ConversationHistoryPage.Method1(var10000);
//            var14 = ConversationsPage.Instance;
            var4 = 2;
            var10001 = json.Method509(var4, 0L);
            var4 = 1;
            json.Method509(var4, 0L);
//            var14.Method285(var10001);
            return;
         case 63:
            json.optJSONArray(1);
            var4 = 2;
            var10000 = json.Method509(var4, 0L);
            var4 = 4;
            json.Method506(var4, 0);
            var12 = var10000;
            if ((var3 = Class198.Instance.Field627) instanceof ConversationHistoryPage && (var7 = (ConversationHistoryPage)var3).Field474.GetPeerId() == var12) {
               synchronized(var7._obj) {
                  var7.Method298(5);
                  var7.Method69();
               }
            }

//            var14 = ConversationsPage.Instance;
            json.optJSONArray(1);
            var4 = 2;
            var10001 = json.Method509(var4, 0L);
            var4 = 4;
            json.Method506(var4, 0);
 //           var14.Method286(var10001);
         case 114:
         }
      }

   }
}
