final class Class107 extends Class247 {
   private final Class521 Field460;

   Class107(Class521 var1, boolean var2, Page var3) {
      super(false, var3);
      this.Field460 = var1;
   }

   public final void Method27(String var1) {
      Class521.Method347(this.Field460).Field85 = 4;
      Class521.Method347(this.Field460).Field84 = System.currentTimeMillis() + "";
      Class198.Instance.NavigateBack(Class521.Method347(this.Field460)._page);
      Class362 var2;
      Class459.Method195(var2 = new Class362(Class521.Method347(this.Field460)));
      (new Class93(this, var1, var2)).start();
   }

   static Class521 Method229(Class107 var0) {
      return var0.Field460;
   }
}
