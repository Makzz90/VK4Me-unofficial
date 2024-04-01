final class Class369 extends Class28 {
   private final MessageItemUC Field1075;

   Class369(MessageItemUC var1, String var2) {
      super(var2);
      this.Field1075 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class198.Instance.Method498(Localized.GetString("title.textEditor"), this.Field1075.Field1241.text);
   }
}
