package com.mcsoftware.ticketo.movie.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import lombok.Builder
import java.util.*

@Entity
@Table(name = "t_movie")
data class Movie(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id", columnDefinition = "uuid", updatable = false, nullable = false)
    val id: UUID,

    @Column(name = "movie_title", nullable = false)
    var title: String,

    @Column(name = "movie_duration", nullable = false)
    var duration: Int,

    @Column(name = "show_date", nullable = false)
    var showDate: Date,

    @Column(name = "price", nullable = false)
    var price: Int,

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "rating_id_list", nullable = false, referencedColumnName = "id")
    var ratingId:String //ganti ke rating id
)
