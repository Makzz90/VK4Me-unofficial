public class AuthData extends VKError {
   public String access_token;
   public String captcha_sid;
   public String captcha_img;
   public String validation_type;
   public String phone_mask;
   public String validation_sid;
   public int user_id;

   public final boolean Method36() {
      return !IsStringEmpty(this.validation_sid);
   }

   public final boolean IsSucsess() {
      return super.IsSucsess() && !IsStringEmpty(this.access_token) && this.user_id > 0L;
   }

   public final DataJson ProcessFields(JSONObject json)
   {
      super.ProcessFields(json);
      if (json == null)
      {
         return this;
      }
      else
      {
         this.access_token = json.optGetString("access_token");
         this.captcha_sid = json.optGetString("captcha_sid");
         this.captcha_img = json.optGetString("captcha_img");
         this.validation_type = json.optGetString("validation_type");
         this.phone_mask = json.optGetString("phone_mask");
         this.validation_sid = json.optGetString("validation_sid");
         this.user_id = json.optGetInt("user_id");
         return this;
      }
   }
}
