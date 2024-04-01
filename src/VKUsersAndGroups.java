public class VKUsersAndGroups extends VKResponse
{
	public VKUser[] users;
	   public VKGroup[] groups;
	   
   public VKUsersAndGroups(String method)
   {
		super(method);
	}

   

   public DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null)
      {
         return this;
      }
      else
      {
    	  json = json.Method180("response");
         if (json != null)
         {
            JSONArray ja;
            
            JSONObject o;
            if ((ja = json.optJSONArray("groups")) != null) {
               this.groups = new VKGroup[ja.Count()];

               for(int i = 0; i < this.groups.length; i++) {
                  if ((o = ja.Method508(i)) != null) {
                     this.groups[i] = (VKGroup)(new VKGroup()).ProcessFields(o);
                  }
               }
            }

            if ((ja = json.optJSONArray("profiles")) != null) {
               this.users = new VKUser[ja.Count()];

               for(int i = 0; i < this.users.length; i++) {
                  if ((o = ja.Method508(i)) != null) {
                     this.users[i] = (VKUser)(new VKUser()).ProcessFields(o);
                  }
               }
            }
         }

         return this;
      }
   }
   
   public VKGroupOrUser GetOwnerById(long id)
   {
	   VKGroupOrUser result=null;
	   if(id>0)
	   {
		   for(int i = 0; i < this.users.length; i++)
		   {
			   if(this.users[i].id==id)
			   {
				   result = this.users[i];
				   break;
			   }
            }
	   }
	   else
	   {
		   for(int i = 0; i < this.groups.length; i++)
		   {
			   if(this.groups[i].id==(-id))
			   {
				   result = this.groups[i];
				   break;
			   }
            }
	   }
	   
	   return result;
   }
}
