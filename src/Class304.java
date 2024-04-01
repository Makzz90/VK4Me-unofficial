

final class Class304 extends Class288 {
   private final TextBlock _tb;

   Class304(SettingsInterfaceForm var1, int var2, SettingsPage var3, TextBlock var4) {
      super(var2);
      this._tb = var4;
   }

   public final void Method1(long value) {
	   int temp = (int)(value * 5);
	      Settings.Instance.GuiPhotosCircleType = temp;
      //Settings.Instance.GuiPhotosCircleType = (int)value * 5;
      TextBlock var10000 = this._tb;
      String var2 = temp + "%";
      
      var10000.Method57(Localized.Method398("settings.avatarsCircling", var2, null));
      Class198.Instance.Method493();
   }
}
