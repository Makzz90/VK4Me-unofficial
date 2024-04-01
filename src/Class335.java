final class Class335 extends Class247 {
   private final Class8 Field970;

   Class335(Class8 var1, boolean var2, Page var3) {
      super(true, var3);
      this.Field970 = var1;
   }

   public final void Method27(String var1) {
      Logger.SaveToFile(var1);
      Class198.Instance.NavigateBack(Class8.Method333(this.Field970));
   }
}
