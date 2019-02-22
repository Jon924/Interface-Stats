import java.util.ArrayList;
/**
 * Person class represents a Person object
 *
 * @author Jon Grey
 * @version 1.0
 */
public class Person
{
    // instance variables
    private String ownName;
    private int ownAge;
    private ArrayList<String> friendsNames;

    /**
     * Person creates Person object
     * @param givenName Name of Person
     * @param givenAge  Age of Person
     */
    public Person (String givenName, int givenAge){
        ownName = givenName;
        ownAge = givenAge;
        friendsNames = new ArrayList<String>();
    }

    /**
     * Returns Name
     * @returns Name of Person
     */
    public String getOwnName(){
        return ownName;
    }

    /**
     * returns Age
     * @returns Age of Person
     */
    public int getOwnAge(){
        return ownAge;
    }

    /**
     * returns number of friends
     * @returns number of friends
     */
    public int getFriendCount(){
        return friendsNames.size();
    }

    /**
     * returns all friends
     * @returns string representation of friendsNames
     */
    public String getAllFriendsNames() {
        return friendsNames.toString().replace("[", "").replace("]", "");
    }

    /**
     * returns the name of a friend at a specified index
     * @param index index to get name from
     * @returns string name at index
     */
    public String get1FriendsName(int index) {
        return friendsNames.get(index);
    }

    /**
     * sets age of person
     * @param age age to set age to
     */
    public void setOwnAge(int age) {
        ownAge = age;
    }

    /**
     * adds friend to friendsNames
     * @param aFriend Friend whose name is to be added
     */
    public void addFriend(Person aFriend){
        if(friendsNames.size() == 0){
            friendsNames.add(aFriend.ownName);
            return;
        }
        if(!(friendsNames.indexOf(aFriend.ownName) > 0)){
            for(int i = 0; i < friendsNames.size(); i++){
                if(friendsNames.get(i).compareToIgnoreCase(aFriend.ownName)<0){
                    friendsNames.add(aFriend.ownName);
                    break;
                }
            }
        }

    }

    public void unfriend(String nameOf){
        if(friendsNames.contains(nameOf)){
            friendsNames.remove(nameOf);
        } else {
            System.out.println("Nobody with name");
        }
    }

    /**
     * finds index of shortest name
     * @returns index of shortest name
     */
    public int indexOfShortestName() {
        int minIndex;
        if(friendsNames.size() != 0){
            minIndex = 0;
            for (int i = 0; i < friendsNames.size(); i++){
                if(friendsNames.get(i).length() < friendsNames.get(minIndex).length()){
                    minIndex = i;
                }
            }
        }
        else {
            return -1;
        }
        return minIndex;
    }
    
    
    public String toString(){
        return ownName + ": " + friendsNames.toString().replace("[", "").replace("]", "");
    }
}
