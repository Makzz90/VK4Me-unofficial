public final class VKComment extends DataJson {
   public int count;
   public boolean can_post;
   public boolean can_close;

   public VKComment(VKNewsfeedPost var1) {
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.count = json.optGetInt("count");
         this.can_post = Method433(json.optGetInt("can_post"));
         json.optGetInt("groups_can_post");
         this.can_close = json.optGetBoolean("can_close");
         json.optGetBoolean("can_open");
         return this;
      }
   }
}
