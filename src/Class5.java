import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class5 extends Button {
   Class5(SettingsBehaviorForm var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.LoggerEnabled = this.GetIsChecked();
      Settings.Instance.Method129();
      if (Settings.Instance.LoggerEnabled) {
         Class198.Field618.Method483(Localized.GetString("general.caution"), Localized.GetString("settings.loggingSensitive"));
      } else {
         Logger.Close();
      }
   }
}
