package pl.beniaminek.players.group;

public enum Group {
    A("A"),
    B("B"),
    C("C");

    private String groupName;

    Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
