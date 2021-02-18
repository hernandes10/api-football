package br.com.team.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "LEAGUE")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class League {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
}
