import java.util.Vector;

public final class Class49 extends VKUsersAndGroups {
   private Vector _peerIds;
   private VKConversation[] _conversations;

   public final VKConversation GetConversation() {
	      return this._conversations != null && this._conversations.length > 0 ? this._conversations[0] : null;
	   }

	   public final boolean Method36() {
	      return this.GetConversation() != null;
	   }
	   
   public Class49() {
      super( "messages.getConversationsById");
      this._peerIds = new Vector();
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
   }

   public Class49(long peerId) {
      this();
      this.Method525(peerId);
   }

   public final Class49 Method525(long peerId) {
      if (this._peerIds.indexOf(new Long(peerId)) != -1) {
         return this;
      } else {
         this._peerIds.addElement(new Long(peerId));
         if (this._peerIds != null && this._peerIds.size() > 0) {
            this.AddParameter("peer_ids", Method432(",", this._peerIds));
         } else {
            this.AddParameter("peer_ids", null);
         }

         return this;
      }
   }
   
   public final DataJson ProcessFields(JSONObject json) {
	      super.ProcessFields(json);
	      if (json == null) {
	         return this;
	      } else {
	         if ((json = json.Method180("response")) != null) {
	            json.optGetInt("count");
	            JSONArray var4 = json.optJSONArray("items");
	            if (var4 != null) {
	               this._conversations = new VKConversation[var4.Count()];

	               for(int i = 0; i < this._conversations.length; i++) {
	                  JSONObject var3 = var4.Method508(i);
	                  if (var3 != null) {
	                     this._conversations[i] = (VKConversation)(new VKConversation()).ProcessFields(var3);
	                  }
	               }
	            }
	         }

	         return this;
	      }
	   }

}
