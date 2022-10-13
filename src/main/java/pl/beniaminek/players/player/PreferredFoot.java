package pl.beniaminek.players.player;

public enum PreferredFoot {
    RIGHT("PRAWA"),
    LEFT("LEWA");

    private String foot;
    PreferredFoot(String f){
        this.foot = f;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
