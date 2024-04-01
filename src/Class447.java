final class Class447 extends Class28 {
   private final MessageItemUC Field1228;

   Class447(MessageItemUC var1, String var2) {
      super(var2);
      this.Field1228 = var1;
   }

   public final void CommandExecuted()  {
      Class26 var1 = (Class26)(new Class434(this.Field1228.Field1241.id)).Method41(false).DoDispatch();
      LongPollInstanse.Field896 = true;
      Class198.Instance.Method487();
      if (var1 == null || !var1.Method26(this.Field1228.Field1241.id)) {
         Class198.Instance.ShowError(Localized.GetString("element.deleteError"));
      }

   }
}
