package com.example.hw3

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import com.example.hw3.Movie_data
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import com.google.gson.Gson
import android.support.*
import com.google.android.material.snackbar.Snackbar
import java.lang.Math.abs

class Task1 : AppCompatActivity() {

    lateinit var movieList:List<Movie_data>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

    }
    private fun createMovieList(){
        val movies = """
            [
                      {
      "popularity": 48.007,
      "vote_count": 17115,
      "video": false,
      "poster_path": "/5KCVkau1HEl7ZzfPsKAPM0sMiKc.jpg",
      "id": 278,
      "adult": false,
      "backdrop_path": "/iNh3BivHyg5sQRPP1KOkzguEX0H.jpg",
      "original_language": "en",
      "original_title": "The Shawshank Redemption",
      "genre_ids": [
        80,
        18
      ],
      "title": "The Shawshank Redemption",
      "vote_average": 8.7,
      "overview": "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
      "release_date": "1994-09-23"
    },
    {
      "popularity": 46.083,
      "vote_count": 12946,
      "video": false,
      "poster_path": "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
      "id": 238,
      "adult": false,
      "backdrop_path": "/41xIKcLiM5ryfz4C9sZFcBOJGsK.jpg",
      "original_language": "en",
      "original_title": "The Godfather",
      "genre_ids": [
        80,
        18
      ],
      "title": "The Godfather",
      "vote_average": 8.7,
      "overview": "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
      "release_date": "1972-03-14"
    },
    {
      "popularity": 37.66,
      "vote_count": 10287,
      "video": false,
      "poster_path": "/t7xhP8SQTVanzecvn1oQRVWCXTI.jpg",
      "id": 424,
      "adult": false,
      "backdrop_path": "/loRmRzQXZeqG78TqZuyvSlEQfZb.jpg",
      "original_language": "en",
      "original_title": "Schindler's List",
      "genre_ids": [
        18,
        36,
        10752
      ],
      "title": "Schindler's List",
      "vote_average": 8.6,
      "overview": "The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.",
      "release_date": "1993-11-30"
    },
    {
      "popularity": 116.588,
      "vote_count": 6325,
      "video": false,
      "poster_path": "/q719jXXEzOoYaps6babgKnONONX.jpg",
      "id": 372058,
      "adult": false,
      "backdrop_path": "/mMtUybQ6hL24FXo0F3Z4j2KG7kZ.jpg",
      "original_language": "ja",
      "original_title": "君の名は。",
      "genre_ids": [
        16,
        18,
        10749
      ],
      "title": "Your Name.",
      "vote_average": 8.6,
      "overview": "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.",
      "release_date": "2016-08-26"
    },
    {
      "popularity": 91.41,
      "vote_count": 10130,
      "video": false,
      "poster_path": "/2TeJfUZMGolfDdW6DKhfIWqvq8y.jpg",
      "id": 129,
      "adult": false,
      "backdrop_path": "/mSDsSDwaP3E7dEfUPWy4J0djt4O.jpg",
      "original_language": "ja",
      "original_title": "千と千尋の神隠し",
      "genre_ids": [
        16,
        14,
        10751
      ],
          "title": "Spirited Away",
      "vote_average": 8.5,
      "overview": "A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.",
      "release_date": "2001-07-20"
    },
    {
      "popularity": 158.965,
      "vote_count": 9182,
      "video": false,
      "poster_path": "/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
      "id": 496243,
      "adult": false,
      "backdrop_path": "/ApiBzeaa95TNYliSbQ8pJv4Fje7.jpg",
      "original_language": "ko",
      "original_title": "기생충",
      "genre_ids": [
        35,
        18,
        53
      ],
      "title": "Parasite",
      "vote_average": 8.5,
      "overview": "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
      "release_date": "2019-05-30"
    },
    {
      "popularity": 37.059,
      "vote_count": 590,
      "video": false,
      "poster_path": "/mi5VN4ww0JZgRFJIaPxxTGKjUg7.jpg",
      "id": 522924,
      "adult": false,
      "backdrop_path": "/6esNUoXh4xQvucB7o7e3TCfjI65.jpg",
      "original_language": "en",
      "original_title": "The Art of Racing in the Rain",
      "genre_ids": [
        35,
        18,
        10749
      ],
      "title": "The Art of Racing in the Rain",
      "vote_average": 8.5,
      "overview": "A family dog—with a near-human soul and a philosopher's mind—evaluates his life through the lessons learned by his human owner, a race-car driver.",
      "release_date": "2019-08-08"
    },
    {
      "popularity": 58.159,
      "vote_count": 410,
      "video": false,
      "poster_path": "/h1B7tW0t399VDjAcWJh8m87469b.jpg",
      "id": 556574,
      "adult": false,
      "backdrop_path": "/uWVkEo9PWHu9algZsiLPi6sRU64.jpg",
      "original_language": "en",
          "original_title": "Hamilton",
      "genre_ids": [
        18,
        36,
        10402
      ],
      "title": "Hamilton",
      "vote_average": 8.5,
      "overview": "Presenting the tale of American founding father Alexander Hamilton, this filmed version of the original Broadway smash hit is the story of America then, told by America now.",
      "release_date": "2020-07-03"
    },
    {
      "popularity": 46.962,
      "vote_count": 10909,
      "video": false,
      "poster_path": "/velWPhVMQeQKcxggNEU8YmIo52R.jpg",
      "id": 497,
      "adult": false,
      "backdrop_path": "/xMIyotorUv2Yz7zpQz2QYc8wkWB.jpg",
      "original_language": "en",
      "original_title": "The Green Mile",
      "genre_ids": [
        80,
        18,
        14
      ],
      "title": "The Green Mile",
      "vote_average": 8.5,
      "overview": "A supernatural tale set on death row in a Southern prison, where gentle giant John Coffey possesses the mysterious power to heal people's ailments. When the cell block's head guard, Paul Edgecomb, recognizes Coffey's miraculous gift, he tries desperately to help stave off the condemned man's execution.",
      "release_date": "1999-12-10"
    },
    {
      "popularity": 51.427,
      "vote_count": 19504,
      "video": false,
          "poster_path": "/plnlrtBUULT0rh3Xsjmpubiso3L.jpg",
      "id": 680,
      "adult": false,
      "backdrop_path": "/52StM7zDmcjeKxWkW55X5LtoLQi.jpg",
      "original_language": "en",
      "original_title": "Pulp Fiction",
      "genre_ids": [
        80,
        53
      ],
      "title": "Pulp Fiction",
      "vote_average": 8.5,
      "overview": "A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.",
      "release_date": "1994-09-10"
    }
    ]
        """.trimIndent()

        // create Movie List from JSON String by using Gson!!
        movieList = Gson().fromJson(movies, Array<Movie_data>::class.java).asList()
    }
}