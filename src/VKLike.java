public final class VKLike extends DataJson {
   public int count;
   public boolean user_likes;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.count = json.optGetInt("count");
         this.user_likes = Method433(json.optGetInt("user_likes"));
         json.optGetInt("can_like");
         json.optGetInt("can_publish");
         return this;
      }
   }
}
