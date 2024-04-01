final class Class478 extends Button {
   private final Class467 Field1312;

   Class478(Class467 var1, String var2) {
      super(var2);
      this.Field1312 = var1;
   }

   public final void CommandExecuted()  {
	   Class49 var1=new Class49();
	   var1.Method525(this.Field1312.Field1289.GetId());
	   var1.GetResponse();
	   
      if (var1 != null && var1.Method36())
      {
         DialogItemUC.Method210(this.Field1312, this.Field1312.Field1289.GetId());
      }
   }
}
