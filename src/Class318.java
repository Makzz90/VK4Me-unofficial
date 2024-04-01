import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class318 extends Button {
   Class318(Class442 var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.DebugDrawFPS = this.GetIsChecked();
   }
}
