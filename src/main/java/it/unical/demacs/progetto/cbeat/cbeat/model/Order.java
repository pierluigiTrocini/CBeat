package it.unical.demacs.progetto.cbeat.cbeat.model;

public class Order {
    private Integer id;
    private Integer drinkId;
    private Integer amount;
    private Integer table;


    public Order(){}

    public Order(Integer id, Integer drinkId, Integer amount, Integer table) {
        this.id = id;
        this.drinkId = drinkId;
        this.amount = amount;
        this.table = table;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Integer drinkId) {
        this.drinkId = drinkId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }
}
