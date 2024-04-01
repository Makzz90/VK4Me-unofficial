final class Class444 extends Class28 {
   private final ConversationHistoryPage Field1220;
   private final MessageItemUC Field1221;

   Class444(MessageItemUC var1, String var2, ConversationHistoryPage var3) {
      super(var2);
      this.Field1221 = var1;
      this.Field1220 = var3;
   }

   public final void CommandExecuted() {
      this.Field1220.Field925.Method309(this.Field1221.Field1241);
      Class198.Instance.Method487();
   }
}
