public final class UnknownAttachment extends VKAttachment {
   private int id;
   private long owner_id;
   private String _type;

   public UnknownAttachment(String type) {
      this._type = type;
   }

   public final String toString() {
      return this._type + this.owner_id + "_" + this.id;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optGetInt("id");
         this.owner_id = json.optLong("owner_id");
         return this;
      }
   }
}
