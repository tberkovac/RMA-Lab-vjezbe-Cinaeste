package com.example.lv1drugiput

import com.example.lv1drugiput.data.Movie

fun favoriteMovies(): List<Movie>{
    return listOf(
        Movie(1,"Pride and prejudice",
            "Sparks fly when spirited Elizabeth Bennet meets single, rich, and proud " +
                    "Mr. Darcy. But Mr. Darcy reluctantly finds himself falling in love with a woman " +
                    "beneath his class. Can each overcome their own pride and prejudice?",
        "16.02.2005.","https://www.imdb.com/title/tt0414387/",
        "drama"),
        Movie(2,"Pulp Fiction",
            "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of " +
                    "diner bandits intertwine in four tales of violence and redemption.",
            "21.05.1994.","https://www.imdb.com/title/tt0110912/",
            "crime"),
        Movie(3,"The Lord of the Rings",
        "The Lord of the Rings is a series of three epic fantasy adventure films directed" +
                " by Peter Jackson, based on the novel written by J. R. R. Tolkien. The films are" +
                " subtitled The Fellowship of the Ring, The Two Towers, and The Return of the King.",
        "29.07.1954.","https://www.imdb.com/title/tt9419884/",
        "adventure")
    )
}

fun recentMovies(): List<Movie>{
    return listOf(
        Movie(1,"The Contractor",
            "A discharged U.S. Special Forces sergeant, James Harper, risks everything" +
                    "for his family when he joins a private contracting organization.",
            "01.04.2022.","https://www.imdb.com/title/tt10323676/",
            "thriller"),
        Movie(2,"Morbius",
            "Biochemist Michael Morbius tries to cure himself of a rare blood disease, but " +
                    "he inadvertently infects himself with a form of vampirism instead.",
            "30.03.2022.","https://www.imdb.com/title/tt5108870/",
            "action"),
        Movie(3,"Doctor Strange in the Multiverse of Madness",
            "Dr. Stephen Strange casts a forbidden spell that opens the door to the " +
                    "multiverse, including an alternate version of himself, whose threat to " +
                    "humanity is too great for the combined forces of Strange, Wong, and Wanda Maximoff.",
            "04.05.2022.","https://www.imdb.com/title/tt9419884/",
            "fantasy")
    )
}
