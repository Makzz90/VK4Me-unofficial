final class Class34 extends Button {
   Class34(SettingsBehaviorForm var1, String var2, SettingsPage var3) {
      super(var2);
   }

   public final void CommandExecuted() {
      Class36 var1;
      Class36 var10000 = var1 = new Class36();
      TextBlock var10001 = new TextBlock(Localized.GetString("element.doNotGiveIt"));
      boolean var2 = true;
      TextBlock var3 = var10001;
      var10001.Field1198 = true;
      var10000.AddElement(var3);
      var1.AddElement(new TextBlock(Settings.Instance.Token));
      var1.AddElement(new Class320(this, Localized.GetString("action.close")));
      var1.Field814 = 1;
      Class198.Field618.Method481(var1);
   }
}
