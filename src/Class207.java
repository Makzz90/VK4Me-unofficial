final class Class207 extends Button {
   private final Class467 Field702;

   Class207(Class467 var1, String var2, byte var3) {
      super(var2, (byte)3);
      this.Field702 = var1;
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method256(this.Field702.Field1289.GetId(), this.Field702);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
