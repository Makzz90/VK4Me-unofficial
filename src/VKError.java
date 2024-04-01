public class VKError extends DataJson {
   public String error;
   public String error_description;
   public String error_type;
   public String error_msg;
   public int error_code;

   public boolean IsSucsess() {
      return IsStringEmpty(this.error) && !this.IsErrorExists() && IsStringEmpty(this.error_description) && this.error_code == 0 && IsStringEmpty(this.error_msg);
   }

   public final boolean IsErrorExists() {
      return !IsStringEmpty(this.error_type);
   }

   public DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         if (json.has("error")) {
            JSONObject var2 = json.Method180("error");
            if (var2 != null)
            {
               this.error_code = var2.optGetInt("error_code");
               this.error_msg = var2.optGetString("error_msg");
            } else {
               this.error = json.optGetString("error");
            }
         } else {
            this.error_code = json.optGetInt("error_code");
            this.error_msg = json.optGetString("error_msg");
         }

         this.error_description = json.optGetString("error_description");
         this.error_type = json.optGetString("error_type");
         return this;
      }
   }
}
