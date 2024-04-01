final class Class521 extends Class28 {
   private final Class37 Field1372;

   Class521(Class37 var1, String var2) {
      super(var2);
      this.Field1372 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class198.Instance.NavigateForward(new Class107(this, false, this.Field1372._page));
   }

   static Class37 Method347(Class521 var0) {
      return var0.Field1372;
   }
}
