import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class314 extends Button {
   Class314(Class442 var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.GuiCloudBorder = this.GetIsChecked();
   }
}
