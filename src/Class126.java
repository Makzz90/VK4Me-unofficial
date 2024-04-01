final class Class126 extends Class28 {
   private final TextBox2 Field494;
   private final String Field495;
   private final String Field496;
   private final String Field497;
   private final boolean Field498;
   private final String Field499;

   Class126(String var1, TextBox2 var2, String var3, String var4, String var5, boolean var6, String var7) {
      super(var1);
      this.Field494 = var2;
      this.Field495 = var3;
      this.Field496 = var4;
      this.Field497 = var5;
      this.Field498 = var6;
      this.Field499 = var7;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      LoginForm.Method251(true, this.Field494.GetContent(), this.Field495, this.Field496, this.Field497, this.Field498, this.Field499);
   }
}
