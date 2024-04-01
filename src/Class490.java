final class Class490 extends Class28 {
   private final VKAudio Field1337;
   private final AttachmentItemUC Field1338;

   Class490(AttachmentItemUC var1, String var2, VKAudio var3) {
      super(var2);
      this.Field1338 = var1;
      this.Field1337 = var3;
   }

   public final void CommandExecuted()  {
      Class198.Instance.Method487();
      VKAudio audio = this.Field1337;
      Class72 temp =new Class72(audio.owner_id, audio.id);
      temp.GetResponse();
      
      if (!temp.IsSucsess())
      {
         Class198.Instance.ShowError(Localized.GetString("element.addTrackError"));
      }

   }
}
