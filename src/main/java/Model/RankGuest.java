package Model;

public class RankGuest {
    private int id;
    private String rankGuest;
    private double discount;

    public RankGuest(String rankGuest, double discount) {
        this.rankGuest = rankGuest;
        this.discount = discount;
    }

    public RankGuest(int id, String rankGuest, double discount) {
        this.id = id;
        this.rankGuest = rankGuest;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRankGuest() {
        return rankGuest;
    }

    public void setRankGuest(String rankGuest) {
        this.rankGuest = rankGuest;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
