final class Class202 extends Class247 {
   private final Class271 Field695;

   Class202(Class271 var1, boolean var2, Page var3) {
      super(false, var3);
      this.Field695 = var1;
   }

   public final void Method27(String var1) {
      Class271.Method386(this.Field695).Field1104 = 4;
      Class271.Method386(this.Field695).Field1103 = System.currentTimeMillis() + "";
      Class198.Instance.NavigateBack(Class271.Method386(this.Field695)._page);
      Class362 var2;
      Class459.Method195(var2 = new Class362(Class271.Method386(this.Field695)));
      (new Class375(this, var1, var2)).start();
   }

   static Class271 Method82(Class202 var0) {
      return var0.Field695;
   }
}
