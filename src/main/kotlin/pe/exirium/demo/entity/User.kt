package pe.exirium.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "Users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    val username: String,
    val password: String
)