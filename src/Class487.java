final class Class487 extends Class28 {
   private final VKAudioMessage Field1329;
   private final AttachmentItemUC Field1330;

   Class487(AttachmentItemUC var1, String var2, VKAudioMessage var3) {
      super(var2);
      this.Field1330 = var1;
      this.Field1329 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1330.Method222(false, this.Field1329);
   }
}
