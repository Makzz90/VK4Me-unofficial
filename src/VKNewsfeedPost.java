public class VKNewsfeedPost extends DataJson implements Class313, Class353 {
   private String type;
   public long owner_id;
   public long from_id;
   public int date;
   public String text;
   public long signer_id;
   private boolean marked_as_ads;
   public VKAttachment[] attachments;
   public VKComment comments;
   public VKLike likes;
   public VKRepost reposts;
   public int views;
   public int id;
   public VKNewsfeedPost[] copy_history;
   private boolean is_ad;

   public final String toString() {
      return "wall" + this.owner_id + "_" + this.id;
   }

   public final boolean GetIsAds() {
      return this.is_ad;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.owner_id = json.has("owner_id") ? json.optLong("owner_id") : (json.has("to_id") ? json.optLong("to_id") : json.optLong("source_id"));
         this.from_id = json.optLong("from_id");
         this.type = json.optGetString("type");
         this.id = json.has("id") ? json.optGetInt("id") : json.optGetInt("post_id");
         this.date = json.optGetInt("date");
         this.text = json.optGetString("text");
         JSONObject var2 = json.Method180("comments");
         this.comments = (VKComment)(new VKComment(this)).ProcessFields(var2);
         var2 = json.Method180("likes");
         this.likes = (VKLike)(new VKLike()).ProcessFields(var2);
         var2 = json.Method180("reposts");
         this.reposts = (VKRepost)(new VKRepost(this)).ProcessFields(var2);
         if ((var2 = json.Method180("views")) != null) {
            this.views = var2.optGetInt("count");
         }

         json.optGetString("post_type");
         int i;
         JSONObject var4;
         JSONArray ja = json.optJSONArray("attachments");
         if (ja != null)
         {
            this.attachments = new VKAttachment[ja.Count()];

            for(i = 0; i < this.attachments.length; i++)
            {
            	var4 = ja.Method508(i);
               if (var4 != null)
               {
            	   this.attachments[i] = new VKAttachment();
                  this.attachments[i].ProcessFields(var4);
               }
            }
         }

         if ((ja = json.optJSONArray("copy_history")) != null) {
            this.copy_history = new VKNewsfeedPost[ja.Count()];

            for(i = 0; i < this.copy_history.length; i++) {
               if ((var4 = ja.Method508(i)) != null) {
                  this.copy_history[i] = (VKNewsfeedPost)(new VKNewsfeedPost()).ProcessFields(var4);
               }
            }
         }

         this.signer_id = json.has("from_id") ? json.optLong("from_id") : json.optLong("signer_id");
         this.marked_as_ads = Method433(json.optGetInt("marked_as_ads"));
         json.optGetBoolean("is_favorite");
         this.is_ad = this.marked_as_ads || !IsStringEmpty(json.optGetString("ext_id")) && (!IsStringEmpty(this.type) || this.type.equals("post")) || json.has("authors_rec") || json.has("app_widget") || json.has("promo_button") || json.has("friends_recomm") || json.has("live_recommended");
         return this;
      }
   }

   public final boolean IsTextExists() {
      return !IsStringEmpty(this.text);
   }

   public final String GetType() {
      return "post";
   }

   public final long GetOwnerId() {
      return this.owner_id;
   }

   public final int GetId() {
      return this.id;
   }

   public final boolean GetCanWrite() {
      return this.comments != null && this.comments.can_post;
   }

   public final boolean Method37() {
      return false;
   }

   public final long GetPeerId() {
      return (long)this.id;
   }

   public final String Method39() {
      return "";
   }

   public final boolean Method40() {
      return true;
   }
}
