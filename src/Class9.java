final class Class9 extends Class28 {
   private final VKAudioMessage Field18;
   private final AttachmentItemUC Field19;

   Class9(AttachmentItemUC var1, String var2, VKAudioMessage var3) {
      super(var2);
      this.Field19 = var1;
      this.Field18 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field19.Method222(true, this.Field18);
   }
}
