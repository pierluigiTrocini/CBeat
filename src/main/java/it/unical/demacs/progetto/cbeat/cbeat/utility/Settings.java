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
    public static final String cardQuery= """
            select strDrink, strDrinkThumb
            from Drink
            order by strDrinkThumb
            limit 1;
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
            """;

}
