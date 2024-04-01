final class Class372 extends Class28 {
   private final ConversationHistoryPage Field1080;
   private final MessageItemUC Field1081;

   Class372(MessageItemUC var1, String var2, ConversationHistoryPage var3) {
      super(var2);
      this.Field1081 = var1;
      this.Field1080 = var3;
   }

   public final void CommandExecuted() {
      if (this.Field1081.Field1241.id > this.Field1080.Field921) {
         this.Field1080.Field921 = this.Field1081.Field1241.id;
         (new Class494(this.Field1080.Field474.GetPeerId(), this.Field1081.Field1241.id)).DoDispatch();
         LongPollInstanse.Field896 = true;
      }

      Class198.Instance.Method487();
   }
}
