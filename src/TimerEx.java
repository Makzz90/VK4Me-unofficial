import java.util.TimerTask;


final class TimerEx extends TimerTask {
   private final Class198 Field798;

   TimerEx(Class198 var1) {
      this.Field798 = var1;
   }

   public final void run() {
      try {
         if (!Settings.Instance.SleepWithTimeout) {
            this.Field798.Field688 = 0;
         } else if (this.Field798.Field688 > Settings.Instance.SleepTimeout) {
            if (!LongPollInstanse.IsAppPaused && Settings.Instance.SetOffline && Settings.Instance.IsAutorized()) {
               LongPollInstanse.IsAppPaused = true;
               //Class190.Field603.Method36();
            }

            LongPollInstanse.IsAppPaused = true;
            if (Settings.Instance.DebugLongPoll) {
               this.Field798.Repaint();
            }
         } else if (Class198.Field620 == null) {
            ++this.Field798.Field688;
         }
      } catch (Exception var7) {
      }

      try {
         if (this.Field798.Field669 != -1) {
            if (this.Field798.Field669 == 0) {
               if (Settings.Instance.GuiAnimations) {
                  this.Field798._recordStore2.Field378 = 0;
                  this.Field798._recordStore2.Method153(100);
               } else {
                  this.Field798._recordStore2.Field379 = 0;
               }

               this.Field798.Repaint();
            }

            --this.Field798.Field669;
         }

         if (this.Field798.Field629 != System.currentTimeMillis() / 60000L) {
            this.Field798.Field629 = System.currentTimeMillis() / 60000L;
            this.Field798.Field658 = Class291.Method441(System.currentTimeMillis() / 1000L, false);
//            this.Field798.Repaint();//TODO
         }
      } catch (Throwable var6) {
         Logger.PrintErrorWithMessage(var6);
      }
/*
      try
      {
         if (ConversationsPage.Instance != null)
         {
            ConversationsPage var3 = ConversationsPage.Instance;
            if (Settings.Instance.TypingInDialogs)
            {
               for(int i = 0; i < var3.Count(); i++)
               {
                  DialogItemUC var2=(DialogItemUC)var3.ElementAt(i);
                  if (var2 != null && var2.Field1039 > 0) {
                     var2.Method65(var2.Field1039 - 1);
                  }
               }

               var3.Method119();
            }
         }
      } catch (Exception var8) {
         Logger.PrintErrorWithMessage(var8);
      }
*/
      try {
         if (this.Field798.Field627 instanceof ConversationHistoryPage) {
            ((ConversationHistoryPage)this.Field798.Field627).Method370();
            ((ConversationHistoryPage)this.Field798.Field627).Method69();
            ConversationHistoryPage var12;
            if ((var12 = (ConversationHistoryPage)this.Field798.Field627).Field925 != null) {
               var12.Field925.Method0();
            }
         }
      } catch (Throwable var5) {
         Logger.PrintErrorWithMessage(var5);
      }

      try {
         TextBox2 var9;
         if ((var9 = this.Field798.Method492() ? this.Field798.Field630.Method368() : (this.Field798.Field627 != null ? this.Field798.Field627.Method368() : null)) instanceof PasswordBox) {
            PasswordBox var10;
            int var11 = (var10 = (PasswordBox)var9).Field968;
            if (var10.Field968 > 0) {
               var10.Field968--;
               if (var10.Field968 == 0) {
                  var10.Field967 = null;
               }
            }

            if (var11 > 0 && var10.Field968 == 0) {
               this.Field798.Repaint();
            }
         }

      } catch (Throwable var4) {
         Logger.PrintErrorWithMessage(var4);
      }
   }
}
