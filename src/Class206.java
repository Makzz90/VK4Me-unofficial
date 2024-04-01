public final class Class206 extends VKResponse {
   public long owner_id;
   

   public Class206() {
      super(/*Field701 == null ? (Field701 = Method4("hq")) : Field701,*/ "audio.getPlaylists");
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
   }

   public final boolean Method36() {
      return this.owner_id != 0L;
   }

}
