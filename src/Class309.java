

final class Class309 extends Class288 {
   private final TextBlock _tb;

   Class309(SettingsInterfaceForm var1, int var2, SettingsPage var3, TextBlock var4) {
      super(var2);
      this._tb = var4;
   }

   public final void Method1(long value) {
	   int temp = (int)value * 5;
      Settings.Instance.GuiAvatarCircleType = temp;
      TextBlock var10000 = this._tb;
      String var2 = temp + "%";
      
      var10000.Method57(Localized.Method398("settings.cornerRadius", var2, null));
      Class198.Instance.Method493();
   }
}
