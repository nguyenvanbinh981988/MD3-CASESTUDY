package Model;

public class Costumer {
    private int id;
    private String name;
    private int bankCard;
    private String rankGuest;
    private String address;

    public Costumer(String name, int bankCard, String rankGuest, String address) {
        this.name = name;
        this.bankCard = bankCard;
        this.rankGuest = rankGuest;
        this.address = address;
    }

    public Costumer(int id, String name, int bankCard, String rankGuest, String address) {
        this.id = id;
        this.name = name;
        this.bankCard = bankCard;
        this.rankGuest = rankGuest;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBankCard() {
        return bankCard;
    }

    public void setBankCard(int bankCard) {
        this.bankCard = bankCard;
    }

    public String getRankGuest() {
        return rankGuest;
    }

    public void setRankGuest(String rankGuest) {
        this.rankGuest = rankGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
