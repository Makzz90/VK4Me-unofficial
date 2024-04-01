final class Class152 extends Class28 {
   private final Class64 Field541;

   Class152(Class64 var1, String var2) {
      super(var2);
      this.Field541 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class198.Instance.Method498(Localized.GetString("title.textEditor"), this.Field541.Field163.text);
   }
}
