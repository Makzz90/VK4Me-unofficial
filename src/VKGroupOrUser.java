public abstract class VKGroupOrUser extends DataJson {
   public boolean is_group;

   public VKGroupOrUser(boolean isGroup) {
      this.is_group = isGroup;
   }

   public abstract String Method349();

   public final VKGroup GetGroup() {
      return this.is_group ? (VKGroup)this : null;
   }

   public final VKUser GetUser() {
      return !this.is_group ? (VKUser)this : null;
   }

   public abstract String GetPhoto50();

   public abstract String GetPhoto100();

   public abstract String GetName(String var1);

   public abstract long GetId();

   public final long Method354() {
      return this.is_group ? -this.GetId() : this.GetId();
   }

   public final boolean IsStatusExists() {
      return !IsStringEmpty(this.GetStatus());
   }

   public abstract String GetStatus();

   public abstract String Method355(String var1);

   public final String Method356() {
      return this.GetTitle("nom");
   }

   public final String GetTitle(String var1) {
      return this.is_group ? this.GetName(var1) : this.Method355(var1);
   }
}
