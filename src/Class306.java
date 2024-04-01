

final class Class306 extends Button {
   private final Button Field938;
   private final VKUser _user;

   Class306(SettingsInterfaceForm var1, String var2, byte var3, SettingsPage var4, Button var5, VKUser var6) {
      super(var2, (byte)1);
      this.Field938 = var5;
      this._user = var6;
   }

   public final void ButtonPressed() {
      Settings.Instance.GuiReverseNames = this.GetIsChecked();
      Settings.Instance.Method129();
      this.Field938.SetLable(Settings.Instance.GuiReverseNames ? this._user.Method527("nom") : this._user.Method526("nom"));
   }
}
