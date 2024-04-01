final class Class173 extends Button {
   private final boolean Field577;
   private final String Field578;
   private final String Field579;
   private final Class247 Field580;

   Class173(Class247 var1, String var2, byte var3, boolean var4, String var5, String var6) {
      super(var2, var3);
      this.Field580 = var1;
      this.Field577 = var4;
      this.Field578 = var5;
      this.Field579 = var6;
   }

   public final void CommandExecuted() {
      if (this.Field577) {
         Class247.Method245(this.Field580, this.Field578 + this.Field579);
      } else {
         Class247.Method238(this.Field580, this.Field578 + this.Field579 + (this.Field577 && !this.Field579.endsWith(Class247.Field780) ? Class247.Field780 : ""));
      }
   }

   public final void Method20() {
      this.Field580.Method20();
   }
}
