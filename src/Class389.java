final class Class389 extends Button {
   Class389(String var1, byte var2) {
      super(var1, (byte)3);
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method256(Settings.Instance.UserId, LoginForm.HomePage);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
