final class Class100 extends Class28 {
   private final TextBox2 Field446;
   private final Class247 Field447;

   Class100(Class247 var1, String var2, TextBox2 var3) {
      super(var2);
      this.Field447 = var1;
      this.Field446 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class247.Method242(this.Field447, Class247.Field784 + this.Field446.GetContent() + Class247.Field780);
   }
}
