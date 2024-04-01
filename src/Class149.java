

final class Class149 extends Button {
   Class149(SettingsInterfaceForm var1, String var2, byte var3, SettingsPage var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
	   Settings.Instance.GuiReverseSofts = this.GetIsChecked();
      Class198.Instance.Method464(false);
   }
}
