import java.util.Vector;

final class Class148 extends Class28 {
   private final Class64 Field537;

   Class148(Class64 var1, String var2) {
      super(var2);
      this.Field537 = var1;
   }

   public final void CommandExecuted() {
      Vector var1;
      (var1 = new Vector(1, 1)).addElement(this.Field537.Field163);
      Class198.Instance.Method487();
      try {
		LoginForm.Method252(this.Field537._page, var1, 2);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
