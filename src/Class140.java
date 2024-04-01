import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class140 extends Button {
   Class140(Class442 var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
	   Settings.Instance.SetValueByName(Settings.GuiSlimHeader,this.GetIsChecked());
      if (Settings.Instance.GetValueByName(Settings.GuiTouchHud))
      {
         Class198.Field618.Method464(false);
      }

   }
}
