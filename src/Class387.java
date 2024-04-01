final class Class387 extends Button {
   Class387(String var1, byte var2) {
      super(var1, (byte)3);
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method258(LoginForm.HomePage, Settings.Instance.UserId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
