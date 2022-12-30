package it.unical.demacs.progetto.cbeat.cbeat.utility;

public class Settings {
    /* Sample information */
    public static final String samplePath = "it/unical/demacs/progetto/cbeat/cbeat/sample/";

    /* General */
    public static final String mainTitle = "Beat";
    public static final String mediaPath = "it/unical/demacs/progetto/cbeat/cbeat/media/";
    public static final String cssPath = "it/unical/demacs/progetto/cbeat/cbeat/css/";



    /* Login view */
    public static final String loginTitle = mainTitle + " - Login";
    public static final Double loginWidth = 1280.0;
    public static final Double loginHeight = 720.0;

    /* Item card */
    public static final Double itemCardWidth = 150.0;
    public static final Double itemCardHeight = 150.0;

    /* Homepage */
    public static final String clientTitle = mainTitle + " - Tavolo ";
    public static final String staffTitle = mainTitle + "  Area Staff - ";
    public static final String welcomeStaff = "Benvenuto, ";
    public static final Double homepageInitialWidth = 1280.0;
    public static final Double homepageInitialHeight = 720.0;

    /* Api and Database information */
    public static final int ingredientSize = 15;

    public static final String apikey = "1";
    public static final String databaseUrl = "jdbc:sqlite:localDatabase.db";
    public static final String insertionQuery ="""
                INSERT INTO Drink 
                (idDrink, strDrink, strAlcoholic, strDrinkThumb, strInstructionsIT, strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10, strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15, strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5, strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    public static final String insertOrder = """
            INSERT INTO Orders VALUES ( null, ?, ?, ? )
            """;

    public static final String cardQuery= """
            select strDrink, strDrinkThumb
            from Drink
            order by strDrinkThumb
            limit 18;
            """;

    public static final String drinkInfo= """
            select *
            from Drink
            where strDrink = ?
            """;

    public static final String searchQuery= """
            select *
            from Drink
            where strDrink like ?;
            limit 18;
            """;

    public static final String searchOnly= """
            select *
            from Drink
            where strAlcoholic = ?
            order by strDrinkThumb
            limit 18;
            """;

    public static final String searchByIngredient= """
            select *
            from Drink
            where   strIngredient1 = ? or
                    strIngredient2 = ? or
                    strIngredient3 = ? or
                    strIngredient4 = ? or
                    strIngredient5 = ? or
                    strIngredient6 = ? or
                    strIngredient7 = ? or
                    strIngredient8 = ? or
                    strIngredient9 = ? or
                    strIngredient10 = ? or
                    strIngredient11 = ? or
                    strIngredient12 = ? or
                    strIngredient13 = ? or
                    strIngredient14 = ? or
                    strIngredient15 = ?
            order by strDrinkThumb
            limit 18;
            """;
    public static final String queryOrders= """
            select Orders.orderId,Drink.strDrinkThumb, Drink.strDrink, Orders.amount, Orders."table"
            from Drink, Orders
            where Drink.idDrink = Orders.drinkId;
            """;


    public static final String procOrderExists= """
            select * from ProcessedOrders where username=? and date=date();
            
            """;
    public static final String SaveProcessedOrder= """
            INSERT INTO ProcessedOrders Values (?,date(),?);
            
            
             """;
    public static final String UpdateProcessedOrder= """
            update ProcessedOrders set amount=amount+? where username=? and date=date();
            
            """;
    public static final String DeleteFromOrders= """
            DELETE FROM ORDERS WHERE orderId=?;
            """;


    public static final String SearchCorrectUsername= """
            
            select *  from Employee where username=?;
            
           """;

    public static final String InsertEmployee= """
            
            INSERT INTO Employee Values (?,?);
            """;

}
