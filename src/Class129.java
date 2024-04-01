final class Class129 extends Class28 {
   private final String Field502;
   private final String Field503;
   private final boolean Field504;
   private final TextBox2 Field505;

   Class129(String var1, String var2, String var3, boolean var4, TextBox2 var5) {
      super(var1);
      this.Field502 = var2;
      this.Field503 = var3;
      this.Field504 = var4;
      this.Field505 = var5;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      LoginForm.Method251(true, null, null, this.Field502, this.Field503, this.Field504, this.Field505.GetContent());
   }
}
