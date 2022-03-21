package com.example.lv1drugiput

fun favoriteMovies(): List<Movie>{
    return listOf(
        Movie(1,"Pride and prejudice",
            "Sparks fly when spirited Elizabeth Bennet meets single, rich, and proud " +
                    "Mr. Darcy. But Mr. Darcy reluctantly finds himself falling in love with a woman " +
                    "beneath his class. Can each overcome their own pride and prejudice?",
        "16.02.2005.","https://www.imdb.com/title/tt0414387/",
        "drama")
    )
}

fun recentMovies(): List<Movie>{
    return listOf(
        Movie(1,"The Contractor",
            "A discharged U.S. Special Forces sergeant, James Harper, risks everything" +
                    "for his family when he joins a private contracting organization.",
            "01.04.2022.","https://www.imdb.com/title/tt10323676/",
            "thriller")
    )
}
