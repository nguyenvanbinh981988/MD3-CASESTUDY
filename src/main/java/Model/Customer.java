package Model;

public class Customer {
    private int id;
    private String name;
    private String bankCard;
    private RankGuest rankGuest;
    private String address;
    private String passWord;

    public Customer(String name, String bankCard, RankGuest rankGuest, String address,String passWord) {
        this.name = name;
        this.bankCard = bankCard;
        this.rankGuest = rankGuest;
        this.address = address;
        this.passWord = passWord;
    }

    public Customer(int id, String name, String bankCard, RankGuest rankGuest, String address,String passWord) {
        this.id = id;
        this.name = name;
        this.bankCard = bankCard;
        this.rankGuest = rankGuest;
        this.address = address;
        this.passWord = passWord;
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

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public RankGuest getRankGuest() {
        return rankGuest;
    }

    public void setRankGuest(RankGuest rankGuest) {
        this.rankGuest = rankGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
