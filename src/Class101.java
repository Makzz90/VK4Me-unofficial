final class Class101 extends Class247 {
   private final Class522 Field448;

   Class101(Class522 var1, boolean var2, Page var3) {
      super(false, var3);
      this.Field448 = var1;
   }

   public final void Method27(String var1) {
      Class522.Method345(this.Field448).Field85 = 4;
      Class522.Method345(this.Field448).Field84 = System.currentTimeMillis() + "";
      Class198.Instance.NavigateBack(Class522.Method345(this.Field448)._page);
      Class362 var2;
      Class459.Method195(var2 = new Class362(Class522.Method345(this.Field448)));
      (new Class0(this, var1, var2)).start();
   }

   static Class522 Method193(Class101 var0) {
      return var0.Field448;
   }
}
