final class Class155 extends Class28 {
   private final VKGroupOrUser Field543;
   private final Class64 Field544;

   Class155(Class64 var1, String var2, VKGroupOrUser var3) {
      super(var2);
      this.Field544 = var1;
      this.Field543 = var3;
   }

   public final void CommandExecuted() {
      LoginForm.Method254(this.Field544._page, this.Field543);
      Class198.Instance.Method487();
   }
}
