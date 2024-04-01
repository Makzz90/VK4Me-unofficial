final class Class271 extends Class28 {
   private final Class376 Field846;

   Class271(Class376 var1, String var2) {
      super(var2);
      this.Field846 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class198.Instance.NavigateForward(new Class202(this, false, this.Field846._page));
   }

   static Class376 Method386(Class271 var0) {
      return var0.Field846;
   }
}
