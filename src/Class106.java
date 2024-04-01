final class Class106 extends Class28 {
   private final TextBox2 Field457;
   private final Button Field458;
   private final Class247 Field459;

   Class106(Class247 var1, String var2, TextBox2 var3, Button var4) {
      super(var2);
      this.Field459 = var1;
      this.Field457 = var3;
      this.Field458 = var4;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class247.Method243(this.Field459, this.Field457.GetContent(), Class247.Field784 + this.Field458.LableElement + (Class247.Method237(this.Field458) ? Class247.Field780 : ""));
   }
}
