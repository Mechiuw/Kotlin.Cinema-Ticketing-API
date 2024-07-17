package com.mcsoftware.ticketo.rating.model.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonProperty
import com.mcsoftware.ticketo.movie.model.entity.Movie
import com.mcsoftware.ticketo.rating.constant.ECode
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "t_rating")
data class Rating(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id", updatable = false, nullable = false)
    val id :UUID = UUID.randomUUID(),

    @Column(name = "code", nullable = false)
    @Enumerated(EnumType.STRING)
    var code :ECode,

    @Column(name = "description", nullable = false)
    var description :String,

    @OneToMany(mappedBy = "id", cascade = [CascadeType.ALL])
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    val moviesLinked : List<Movie>
) {
    constructor(code: ECode,description: String):this(
        id = UUID.randomUUID(),
        code = code,
        description = description,
        moviesLinked = emptyList()
    )
}
