final class Class370 extends Class28 {
   private final VKGroupOrUser Field1076;
   private final MessageItemUC Field1077;

   Class370(MessageItemUC var1, String var2, VKGroupOrUser var3) {
      super(var2);
      this.Field1077 = var1;
      this.Field1076 = var3;
   }

   public final void CommandExecuted() {
      LoginForm.Method254(this.Field1077._page, this.Field1076);
      Class198.Instance.Method487();
   }
}
