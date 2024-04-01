import java.util.Random;

public final class Class397 extends MethodsWithParameters {
   private static Random Field1139 = new Random();
   //private static Class Field1140;

   public Class397() {
      super(/*Field1140 == null ? (Field1140 = Method4("ci")) : Field1140,*/ "wall.createComment");
      long var2 = Field1139.nextLong();
      this.AddParameter("guid", String.valueOf(var2 > 0L ? var2 : -var2));
   }

   public Class397(VKNewsfeedPost var1, String var2) {
      this();
      this.AddParameter("owner_id", var1 == null ? null : String.valueOf(var1.owner_id));
      this.AddParameter("post_id", var1 == null ? null : String.valueOf(var1.id));
      this.AddParameter("message", var2 != null ? Class278.Method377(var2) : null);
   }

   public final Class397 Method384(String var1) {
      this.AddParameter("attachments", var1);
      return this;
   }

   public final Class397 Method385(VKWallReply var1) {
      this.AddParameter("reply_to_comment", var1 == null ? null : String.valueOf(var1.id));
      return this;
   }
/*
   private static Class Method4(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var1) {
         throw new NoClassDefFoundError(var1.getMessage());
      }
   }*/
}
