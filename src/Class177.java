

final class Class177 extends Class28 {
   private final TextBox2 _tb;
   private final Class10 Field588;

   Class177(Class10 var1, String var2, TextBox2 var3) {
      super(var2);
      this.Field588 = var1;
      this._tb = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      String var1 = this._tb.GetContent();

      try {
         Settings.Instance.SleepTimeout = Math.max(Integer.parseInt(var1 != null ? var1 : "10"), 10);
      } catch (Throwable var3) {
         Settings.Instance.SleepTimeout = Math.max(Integer.parseInt(var1 != null ? var1 : "10"), 10);
      }

      TextBlock var10000 = Class10.Method443(this.Field588);
      String var2 = Settings.Instance.SleepTimeout + "";
      
      var10000.Method57(Localized.Method398("settings.sleepTimeout", var2, null));
   }
}
