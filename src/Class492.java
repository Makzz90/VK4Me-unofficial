final class Class492 extends Class28 {
   private final VKAudio Field1343;
   private final AttachmentItemUC Field1344;

   Class492(AttachmentItemUC var1, String var2, VKAudio var3) {
      super(var2);
      this.Field1344 = var1;
      this.Field1343 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1344.Method220(true, this.Field1343);
   }
}
