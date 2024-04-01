final class Class42 extends Class28 {
   private final VKConversation Field92;
   private final ConversationHistoryPage Field93;

   Class42(ConversationHistoryPage var1, String var2, VKConversation var3) {
      super(var2);
      this.Field93 = var1;
      this.Field92 = var3;
   }

   public final void CommandExecuted() {
      LoginForm.Method254(this.Field93, Class31.GetUser(this.Field92.GetPeerId()));
      Class198.Instance.Method487();
   }
}
