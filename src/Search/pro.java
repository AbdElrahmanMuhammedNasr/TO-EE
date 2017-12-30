package Search;

public class pro {

    int id;
    String name;
    String kind;
    String number;
    int price;
    String date;

    pro(int id, String name, String kind, String number, int price, String date) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.number = number;
        this.price = price;
        this.date = date;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public String getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

}
