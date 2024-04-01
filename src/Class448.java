final class Class448 extends Class28 {
   private final ConversationHistoryPage Field1229;
   private final MessageItemUC Field1230;

   Class448(MessageItemUC var1, String var2, ConversationHistoryPage var3) {
      super(var2);
      this.Field1230 = var1;
      this.Field1229 = var3;
   }

   public final void CommandExecuted() {
      this.Field1229.Field925.Method306(this.Field1230.Field1241);
      this.Field1229.Field925.Method305(true);
      Class198.Instance.Method487();
   }
}
