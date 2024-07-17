package com.mcsoftware.ticketo.movie.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "t_movie")
data class Movie(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "movie_id", columnDefinition = "uuid", updatable = false, nullable = false)
    val id: UUID,

    @Column(name = "movie_title", nullable = false)
    val title: String,

    @Column(name = "movie_duration", nullable = false)
    val duration: Int,

    @Column(name = "show_date", nullable = false)
    val showDate: Date,

    @Column(name = "price", nullable = false)
    val price: Int,

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "rating_id_list", nullable = false, referencedColumnName = "id")
    val ratingId:List<UUID>
)
