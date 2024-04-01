final class Class269 extends Class28 {
   private final Class376 Field844;

   Class269(Class376 var1, String var2) {
      super(var2);
      this.Field844 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class198.Instance.NavigateForward(new Class211(this, false, this.Field844._page));
   }

   static Class376 Method358(Class269 var0) {
      return var0.Field844;
   }
}
