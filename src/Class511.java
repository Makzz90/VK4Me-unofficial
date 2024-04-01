final class Class511 extends Class28 {
   private final TextBox2 Field1357;
   private final Class288 Field1358;
   private final boolean Field1359;

   Class511(SettingsBehaviorForm var1, String var2, TextBox2 var3, Class288 var4, boolean var5) {
      super(var2);
      this.Field1357 = var3;
      this.Field1358 = var4;
      this.Field1359 = var5;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      String var1 = this.Field1357.GetContent();

      try {
         this.Field1358.Method247((long)Math.max(Integer.parseInt(var1 != null ? var1 : "0") - (this.Field1359 ? 10 : 1), 0));
      } catch (Throwable var2) {
         this.Field1358.Method247(0L);
      }
   }
}
