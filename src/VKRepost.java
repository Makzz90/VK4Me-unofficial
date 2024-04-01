public final class VKRepost extends DataJson {
   public int count;
   public boolean user_reposted;

   public VKRepost(VKNewsfeedPost var1) {
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.count = json.optGetInt("count");
         this.user_reposted = Method433(json.optGetInt("user_reposted"));
         return this;
      }
   }
}
