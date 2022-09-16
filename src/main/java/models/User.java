package models;
import java.util.Objects;
//plain container for user data
    public class User {
        private int id;
        private int profileID;

        // constructors / standard setters / getters
        public User() {}

        public User(int profileID) {
            this.profileID = profileID;
        }

        public int getId() {
            return id;
        }

        public void setId(int newID) {
            id = newID;
        }

        public int getProfileID() {
            return profileID;
        }

        public void setProfileID(int profileID) {
            this.profileID = profileID;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof User)) return false;
            User per = (User) obj;

            return (Objects.equals(this.id, per.id) &&
                    Objects.equals(this.profileID, per.profileID));
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, profileID);
        }
}
