public final class Class429 extends VKResponse {
   private long _ownerId;
   

   public Class429() {
      super(/*Field1194 == null ? (Field1194 = Method4("pq")) : Field1194,*/ "audio.get");
   }

   public final Class429 Method77(long owner_id) {
      this._ownerId = owner_id;
      if (this.Method36()) {
         this.AddLong("owner_id", this._ownerId);
      } else {
         this.AddParameter("owner_id", null);
      }
      
      this.AddParameter("v", "5.90");//todo: wtf?

      return this;
   }

   public final boolean Method36() {
      return this._ownerId != 0L;
   }

   
   
   public VKAudio[] Items;

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         JSONArray var4;
         if ((json = json.Method180("response")) != null && (var4 = json.optJSONArray("items")) != null) {
            this.Items = new VKAudio[var4.Count()];

            for(int var2 = 0; var2 < this.Items.length; ++var2) {
               JSONObject var3;
               if ((var3 = var4.Method508(var2)) != null) {
                  this.Items[var2] = (VKAudio)(new VKAudio()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
