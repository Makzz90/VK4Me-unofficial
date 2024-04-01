final class Class227 extends Button {
   private final boolean Field729;
   private final AboutForm Field730;

   Class227(AboutForm var1, String var2, byte var3, SettingsPage var4, boolean var5) {
      super(var2, var3);
      this.Field730 = var1;
      this.Field729 = var5;
   }

   public final void CommandExecuted() {
      if (this.Field729) {
         try {
			LoginForm.Method254(this.Field730, Class31.GetUser(-185833676L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }

   }
}
