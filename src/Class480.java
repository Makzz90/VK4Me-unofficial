final class Class480 extends Button {
   private final Class467 Field1314;

   Class480(Class467 var1, String var2) {
      super(var2);
      this.Field1314 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.NavigateForward((new Class360(this.Field1314.Field1289)).Method361(this.Field1314));
   }
}
