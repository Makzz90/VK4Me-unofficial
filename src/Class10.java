final class Class10 extends Button {
   private final TextBlock Field20;

   Class10(SettingsBehaviorForm var1, String var2, SettingsPage var3, TextBlock var4) {
      super(var2);
      this.Field20 = var4;
   }

   public final void CommandExecuted() {
      Class36 var1;
      Class36 var10000 = var1 = new Class36();
      TextBlock var10001 = new TextBlock(Localized.GetString("element.setCustomValue"));
      //boolean var2 = true;
      TextBlock var3 = var10001;
      var10001.IsBold = true;
      var10000.AddElement(var3.Method157(true));
      TextBox2 var4 = new TextBox2(Localized.GetString("element.timeInSecs"));
      var1.AddElement(var4);
      var1.AddElement(new Class177(this, Localized.GetString("action.ok"), var4));
      var1.AddElement(new Class175(this, Localized.GetString("action.cancel")));
      Class198.Instance.Method481(var1);
      var1.Field814 = 1;
   }

   static TextBlock Method443(Class10 var0) {
      return var0.Field20;
   }
}
