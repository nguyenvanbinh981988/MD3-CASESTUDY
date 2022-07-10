package Model;

public class RankGuest {
    private int id;
    private String rankG;
    private double discount;

    public RankGuest(String rankG, double discount) {
        this.rankG = rankG;
        this.discount = discount;
    }

    public RankGuest(int id, String rankG, double discount) {
        this.id = id;
        this.rankG = rankG;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRankG() {
        return rankG;
    }

    public void setRankG(String rankG) {
        this.rankG = rankG;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
