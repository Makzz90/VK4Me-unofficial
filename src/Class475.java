final class Class475 extends Button {
   private final Class467 Field1308;

   Class475(Class467 var1, String var2, byte var3) {
      super(var2, (byte)3);
      this.Field1308 = var1;
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method256(this.Field1308.Field1289.GetId(), this.Field1308);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
