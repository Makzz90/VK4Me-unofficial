import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class311 extends Button {
   Class311(Class442 var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.GuiShowClouds = this.GetIsChecked();
   }
}
