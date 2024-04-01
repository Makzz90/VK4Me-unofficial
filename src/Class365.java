final class Class365 extends Class28 {
   private final ConversationHistoryPage Field1053;
   private final MessageItemUC Field1054;

   Class365(MessageItemUC var1, String var2, ConversationHistoryPage var3) {
      super(var2);
      this.Field1054 = var1;
      this.Field1053 = var3;
   }

   public final void CommandExecuted()  {
      Class164 var1 = (Class164)(new Class194(this.Field1054.Field1241.peer_id, this.Field1054.Field1241.id)).DoDispatch();
      LongPollInstanse.Field896 = true;
      if (var1 != null && var1.Field561 != null) {
         this.Field1054.Field1257.Method294(this);
         ((VKConversation)this.Field1053.Field474).chat_settings.pinned_message = this.Field1054.Field1241;
         this.Field1054.Method119();
      } else {
         Class198.Instance.ShowError(Localized.GetString("element.pinError"));
      }

      Class198.Instance.Method487();
   }
}
