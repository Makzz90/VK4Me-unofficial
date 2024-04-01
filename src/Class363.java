final class Class363 extends Class28 {
   private final ConversationHistoryPage Field1050;
   private final MessageItemUC Field1051;

   Class363(MessageItemUC var1, String var2, ConversationHistoryPage var3) {
      super(var2);
      this.Field1051 = var1;
      this.Field1050 = var3;
   }

   public final void CommandExecuted()  {
      Class520 var1 = (Class520)(new Class499(this.Field1051.Field1241.peer_id)).DoDispatch();
      LongPollInstanse.Field896 = true;
      if (var1 != null && var1.IsSucsess()) {
         this.Field1051.Field1257.Method294(this);
         ((VKConversation)this.Field1050.Field474).chat_settings.pinned_message = null;
         this.Field1051.Method118();
      } else {
         Class198.Instance.ShowError(Localized.GetString("element.unpinError"));
      }

      Class198.Instance.Method487();
   }
}
