final class Class174 extends Button {
   private final boolean Field581;
   private final String Field582;
   private final String Field583;
   private final Class247 Field584;

   Class174(Class247 var1, String var2, byte var3, boolean var4, String var5, String var6) {
      super(var2, (byte)2);
      this.Field584 = var1;
      this.Field581 = var4;
      this.Field582 = var5;
      this.Field583 = var6;
   }

   public final void CommandExecuted() {
      if (this.Field581) {
         Class247.Method246(this.Field584);
      } else {
         Class247.Method245(this.Field584, this.Field582);
      }

      this.Field584.Method139(this.Field583.substring(this.Field582.length() + Class247.Field780.length(), this.Field583.length() - Class247.Field780.length()));
   }
}
