package august.learn;

import java.time.Instant;


public class ClickEvent {
    String sessionId;
    String userId;
    String pageVisited;
    Instant timeStamp;

    public ClickEvent(String sessionId, String userId, String pageVisited, Instant timeStamp) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.pageVisited = pageVisited;
        this.timeStamp = timeStamp;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPageVisited() {
        return pageVisited;
    }

    public void setPageVisited(String pageVisited) {
        this.pageVisited = pageVisited;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
}
