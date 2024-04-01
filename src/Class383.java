import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class383 extends Button {
   Class383(String var1, byte var2) {
      super(var1, (byte)3);
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method253(LoginForm.HomePage, Settings.Instance.UserId/*Class292.Field603.Field734*/);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
