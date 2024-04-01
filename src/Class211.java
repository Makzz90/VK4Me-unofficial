final class Class211 extends Class247 {
   private final Class269 Field706;

   Class211(Class269 var1, boolean var2, Page var3) {
      super(false, var3);
      this.Field706 = var1;
   }

   public final void Method27(String var1) {
      Class269.Method358(this.Field706).Field1104 = 4;
      Class269.Method358(this.Field706).Field1103 = System.currentTimeMillis() + "";
      Class198.Instance.NavigateBack(Class269.Method358(this.Field706)._page);
      Class362 var2;
      Class459.Method195(var2 = new Class362(Class269.Method358(this.Field706)));
      (new Class465(this, var1, var2)).start();
   }

   static Class269 Method138(Class211 var0) {
      return var0.Field706;
   }
}
