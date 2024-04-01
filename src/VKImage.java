public final class VKImage extends DataJson {
   public String url;
   public int width;
   public int height;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.url = json.optGetString("url");
         this.width = json.optGetInt("width");
         this.height = json.optGetInt("height");
         return this;
      }
   }
}
