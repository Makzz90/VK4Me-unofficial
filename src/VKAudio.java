public class VKAudio extends DataJson {
   public int duration;
   public String url;
   private VKAudioAlbum album;
   public int id;
   public long owner_id;
   public String artist;
   public String title;

   public final String toString() {
      return "audio" + this.owner_id + "_" + this.id;
   }

   public final String Method58() {
      return this.Method36() && this.album.Method36() && !Class71.IsStringEmpty(this.album.Field969.Field203) ? this.album.Field969.Field203 : null;
   }

   private boolean Method36() {
      return this.album != null;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.duration = json.optGetInt("duration");
         this.url = json.optGetString("url");
         this.id = json.optGetInt("id");
         this.owner_id = json.optLong("owner_id");
         this.artist = json.optGetString("artist");
         this.title = json.optGetString("title");
         if ((json = json.Method180("album")) != null) {
            this.album = (VKAudioAlbum)(new VKAudioAlbum()).ProcessFields(json);
         }

         return this;
      }
   }

   public final String Method59() {
      return this.Method36() && this.album.Method36() && !Class71.IsStringEmpty(this.album.Field969.Field204) ? this.album.Field969.Field204 : this.Method58();
   }
}
