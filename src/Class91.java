import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class91 extends Button {
   Class91(SettingsBehaviorForm var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.Field393 = this.GetIsChecked();
   }
}