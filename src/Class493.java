final class Class493 extends Class28 {
   private final VKAudio Field1345;
   private final AttachmentItemUC Field1346;

   Class493(AttachmentItemUC var1, String var2, VKAudio var3) {
      super(var2);
      this.Field1346 = var1;
      this.Field1345 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1346.Method220(false, this.Field1345);
   }
}
