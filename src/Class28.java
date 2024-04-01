public class Class28 extends Button {
   private Class36 Field47;

   public Class28(String var1, Class36 var2) {
      super(var1, (byte)(var2 != null && var2.Field63 ? 2 : 0));
      this.Field47 = var2;
   }

   public Class28(String var1) {
      this(var1, (Class36)null);
   }

   public Class28() {
      this(null, (Class36)null);
   }

   public void CommandExecuted()  {
      if (this.Field47 != null && this.Field47.Field63) {
         Class198.Instance.Method481(this.Field47);
      }

   }
}
