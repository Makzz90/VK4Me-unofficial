final class Class522 extends Class28 {
   private final Class37 Field1373;

   Class522(Class37 var1, String var2) {
      super(var2);
      this.Field1373 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class198.Instance.NavigateForward(new Class101(this, false, this.Field1373._page));
   }

   static Class37 Method345(Class522 var0) {
      return var0.Field1373;
   }
}
