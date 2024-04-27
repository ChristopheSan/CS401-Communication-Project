import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements Serializable {
    private String chatID; // what is this going to be?
    // private String filename; // filename on server - this is the chatID
    private List<User> participants;
    private List<Message> messages;

    // Constructor for a new chatroom from a user
    public ChatRoom(List<User> participants) {
        this.participants = participants;
        this.messages = new ArrayList<>();
        //this.filename = "";
        this.chatID = createChatID();
    }

    // Constructor for a complete object - loading from server
    public ChatRoom(List<User> participants, List<Message> messages, String chatID, String filename) {
        this.chatID = chatID;
        //this.filename = filename;
        this.participants = participants;
        this.messages = messages;
    }

    // Public Methods
    // Getters
    public String getChatID() {
        return chatID;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public List<Message> getMesssages() {
        return messages;
    }

    // Other public methods
    public boolean addMessage(Message msg) {
        if (!messageExists(msg.getID())) { 
            messages.add(msg);
            return true;
        }
        return false; // not added
    }

    public boolean addMember(User user) {
        if (!isParticipant(user.getUsername())){
            participants.add(user);
            return true;
        }
        return false;
    }

    public boolean messageExists(String messageID) {
        for (Message m : messages) {
            if (messageID == m.getID())
                return true;
        }
        // not found
        return false;
    }

    public boolean isParticipant(String userID) {
        for (User user : participants) {
            if (userID == user.getID())
                return true;
        }
        // not found
        return false;
    }

    // TODO finish this method once we know the naming convention for the server files
    public String createChatID() {
        String id = "";
        for (User user : participants) {
            // what naming convention are we using?
        }
        return id;
    } 

    // private methods
}