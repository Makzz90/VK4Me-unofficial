final class Class454 extends Class28 {
   private final MessageItemUC Field1237;

   Class454(MessageItemUC var1, String var2) {
      super(var2);
      this.Field1237 = var1;
   }

   public final void CommandExecuted()  {
      Class26 var1 = (Class26)(new Class434(this.Field1237.Field1241.id)).Method41(true).DoDispatch();
      LongPollInstanse.Field896 = true;
      Class198.Instance.Method487();
      if (var1 == null || !var1.Method26(this.Field1237.Field1241.id)) {
         Class198.Instance.ShowError(Localized.GetString("element.deleteError"));
      }

   }
}
