final class Null {
   private Null(byte var1) {
   }

   public final boolean equals(Object var1) {
      return var1 == null || var1 == this;
   }

   public final String toString() {
      return "null";
   }

   Null() {
      this((byte)0);
   }
}
