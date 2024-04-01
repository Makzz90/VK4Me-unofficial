import java.util.Vector;

final class Class453 extends Class28 {
   private final MessageItemUC Field1236;

   Class453(MessageItemUC var1, String var2) {
      super(var2);
      this.Field1236 = var1;
   }

   public final void CommandExecuted() {
      Vector var1;
      (var1 = new Vector(1, 1)).addElement(this.Field1236.Field1241);
      Class198.Instance.Method487();
      try {
		LoginForm.Method252(this.Field1236._page, var1, 1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
