final class Class519 extends Class28 {
   private final Class467 Field1370;

   Class519(Class467 var1, String var2) {
      super(var2);
      this.Field1370 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Class198.Instance.NavigateForward(Class75.Field206.Method60(this.Field1370.Field1289.is_group ? this.Field1370.Field1289.GetGroup().Field868 : this.Field1370.Field1289.GetUser().Field123, (AttachmentItemUC)null, (ImageElement)null).Method361(this.Field1370));
   }
}
