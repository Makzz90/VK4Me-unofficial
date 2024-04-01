final class Class452 extends Class28 {
   private final ConversationHistoryPage Field1234;
   private final MessageItemUC Field1235;

   Class452(MessageItemUC var1, String var2, ConversationHistoryPage var3) {
      super(var2);
      this.Field1235 = var1;
      this.Field1234 = var3;
   }

   public final void CommandExecuted() {
      this.Field1234.Field925.Method308(this.Field1235.Field1241);
      this.Field1234.Field925.Method305(true);
      Class198.Instance.Method487();
   }
}
